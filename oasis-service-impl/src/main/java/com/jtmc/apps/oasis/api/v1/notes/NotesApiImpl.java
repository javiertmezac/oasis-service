package com.jtmc.apps.oasis.api.v1.notes;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.payments.PaymentResponse;
import com.jtmc.apps.oasis.application.abonos.AbonoAppImpl;
import com.jtmc.apps.oasis.application.blocks.BlockAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.Opt;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class NotesApiImpl implements NotesApi {

    @Inject
    private NotesAppImpl notesApp;

    @Inject
    private AbonoAppImpl abonoApp;

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private BlockAppImpl blockApp;

    @Inject
    private NotesResponseConverter notesResponseConverter;

    @Inject
    private NoteConverterToNotesResponse converterToNotesResponse;

    @Inject
    private NotesConverter notesConverter;

    @Override
    public NotesResponseList getNotes() {
        List<CustomNote> noteList = notesApp.selectAllRecords();

        if(noteList == null || noteList.size() == 0) {
            throw new WebApplicationException("Could not fetch Notes",
                    Response.Status.NOT_FOUND);
        }

        Stream<NotesResponse> noteResponseStream =
                noteList.stream().map(n -> notesResponseConverter.apply(n));

        NotesResponseList response = new NotesResponseList();
        response.setNotesResponse(noteResponseStream.collect(Collectors.toList()));
        return response;
    }

    @Override
    public NotesResponse getNote(int noteId) {
        Optional<Nota> note = notesApp.selectOneNote(noteId);
        if(!note.isPresent()) {
            throw new WebApplicationException("Note not found", Response.Status.NOT_FOUND);
        }

        NotesResponse notesBaseResponse = converterToNotesResponse.apply(note.get());

        Optional<Abono> paymentStatus = abonoApp.selectNotePaymentStatus(noteId);
        if (!paymentStatus.isPresent()) {
            notesBaseResponse.setPaid(false);
            notesBaseResponse.setDebt(note.get().getTotal());
        } else {
            System.out.printf("NotePaymentStatus found for Note %s.%n", note.get().getNonota());
            double remainingNoteTotal = notesBaseResponse.getTotal() - paymentStatus.get().getCantidad();
            notesBaseResponse.setPaid(remainingNoteTotal == 0);
            notesBaseResponse.setDebt(remainingNoteTotal);
        }
        return notesBaseResponse;
    }

    @Override
    public Response createNote(NotesRequest notesRequest) {
        checkNotNull(notesRequest, "NotesRequest object is null");

        int newNote = 0;
        checkArgument(notesRequest.getNoteId() != null && notesRequest.getNoteId() == newNote,
                "Invalid NoteId");
        checkNotNull(notesRequest.getRegistrationDate(), "Provide a registrationDate");
        checkArgument(notesRequest.getEmployeeId() > 0,"Invalid EmployeeId");
        checkArgument(notesRequest.getInitialData() > 0, "Invalid InitialData");
        checkArgument(notesRequest.getFinalData() > 0, "Invalid FinalData");
        checkArgument(notesRequest.getInitialData() < notesRequest.getFinalData(),
                "FinalData should be greater than InitialData");
        checkArgument(StringUtils.isNotBlank(notesRequest.getNote()), "Note number is not valid");

        Optional<Nota> note = notesApp.selectNoteByOrderId(notesRequest.getOrderId());
        if (note.isPresent()) {
            System.out.printf("OrderId %s already has a NOTE linked to it. NoteId: %s%n", notesRequest.getOrderId(), note.get().getId());
            throw new WebApplicationException("This Order already has a NOTE", Response.Status.CONFLICT);
        }

        Optional<Trabajador> employee = employeesApp.selectOne(notesRequest.getEmployeeId());
        if(!employee.isPresent()) {
            throw new WebApplicationException("Employee not Found", Response.Status.NOT_FOUND);
        }

        Optional<Bloque> block = blockApp.getNextNumberForActiveEmployee(notesRequest.getEmployeeId());
        if(!block.isPresent()) {
            System.out.printf("Could not found block for employee %s%n", notesRequest.getEmployeeId());
            throw new WebApplicationException("Block Not Found", Response.Status.NOT_FOUND);
        }

        System.out.printf("Found Block with Id %s%n", block.get().getId());
        System.out.printf("Proceeding to create note %s%n", notesRequest.getNote());
        notesRequest.setNoteId(null);
        int result = notesApp.insertNote(notesConverter.apply(notesRequest));
        int validState = 1;
        if(result != validState) {
            throw new WebApplicationException("Note record not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Note inserted successfully");

        System.out.printf("Proceeding to update nextBlockNumber: %s%n", block.get().getSecuencia());
        int nextNumber = block.get().getSecuencia() + 1;
        Bloque nextBlock = block.get();
        nextBlock.setSecuencia(nextNumber);

        if (nextNumber > nextBlock.getNumfinal()) {
            System.out.printf("BlockId #%s has no more available notes. It will be terminated.%n", nextBlock.getId());
            nextBlock.setStatus(false);
        }

        if (blockApp.updateNextNumber(nextBlock) != 1) {
            System.out.printf("Error updating block for nextNumber: %s on blockId: %s", nextNumber, nextBlock.getId());
            throw new WebApplicationException("Could not update nextBlockNumber for Block", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("BlockId #%s update correctly.%n", nextBlock.getId());

        return Response.ok().build();
    }

    @Override
    public NotePaymentResponseList fetchPaymentsFromNote(int noteId) {
        checkArgument(noteId > 0, "Invalid noteId");
        Optional<Nota> note = notesApp.selectOneNote(noteId);
        if(!note.isPresent()) {
            System.out.printf("Note #%s not found", noteId);
            throw new WebApplicationException("Note not found", Response.Status.NOT_FOUND);
        }

        NotePaymentResponseList responseList = new NotePaymentResponseList();
        List<Abono> payments = abonoApp.selectPaymentsFromNote(noteId);
        Stream<PaymentResponse> paymentResponseStream = payments.stream().map(x -> {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPayment(x.getCantidad());
            paymentResponse.setEmployeeName(String.valueOf(x.getIdchofer()));
            paymentResponse.setRegistration(new Date(x.getFecharegistro().toEpochMilli()));
            return paymentResponse;
        });

        responseList.setNotePayments(paymentResponseStream.collect(Collectors.toList()));
        return responseList;
    }
}
