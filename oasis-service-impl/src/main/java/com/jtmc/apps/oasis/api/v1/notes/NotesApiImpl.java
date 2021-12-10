package com.jtmc.apps.oasis.api.v1.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.oasis.api.v1.payments.PaymentResponse;
import com.jtmc.apps.oasis.application.abonos.AbonoAppImpl;
import com.jtmc.apps.oasis.application.blockerror.BlockErrorAppImpl;
import com.jtmc.apps.oasis.application.blocks.BlockAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.application.users.UserAppImpl;
import com.jtmc.apps.oasis.domain.*;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JWTRequired
public class NotesApiImpl implements NotesApi {

    @Inject
    private JwtUserClaim userClaim;

    @Inject
    private UserAppImpl userApp;

    @Inject
    private NotesAppImpl notesApp;

    @Inject
    private AbonoAppImpl abonoApp;

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private BlockAppImpl blockApp;

    @Inject
    private BlockErrorAppImpl blockErrorApp;

    @Inject
    private NoteConverterToNotesResponse converterToNotesResponse;

    @Inject
    private NotesConverter notesConverter;

    @Override
    public NotesResponseList getNotes() {
        List<CustomNote> noteList = notesApp.selectAllRecords();


        //todo: is this the correct use case? return 404 if empty list?
        if(noteList == null || noteList.size() == 0) {
            throw new WebApplicationException("Could not fetch Notes",
                    Response.Status.NOT_FOUND);
        }

        Stream<NotesResponse> noteResponseStream =
                noteList.stream().map(n -> converterToNotesResponse.apply(n));

        NotesResponseList response = new NotesResponseList();
        response.setNotesResponse(noteResponseStream.collect(Collectors.toList()));
        return response;
    }

    @Override
    public NotesResponse getNote(int noteId) {
        Optional<CustomNote> note = notesApp.selectOneNote(noteId);
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

        calculatePaymentForNote(notesRequest);

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

    //todo: do not accept discount_value to be greater than totalData
    //consider scenarios where there are payments already done.. (what is the expected flow in this scenario)

    @Override
    public Response updateNote(NotesRequest notesRequest) {
        checkNotNull(notesRequest, "NotesRequest object is null");

        int newNote = 0;
        checkArgument(notesRequest.getNoteId() != null && notesRequest.getNoteId() > newNote,
                "Invalid NoteId");
        checkNotNull(notesRequest.getRegistrationDate(), "Provide a registrationDate");
        checkArgument(notesRequest.getEmployeeId() > 0,"Invalid EmployeeId");
        checkArgument(notesRequest.getInitialData() > 0, "Invalid InitialData");
        checkArgument(notesRequest.getFinalData() > 0, "Invalid FinalData");
        checkArgument(notesRequest.getInitialData() < notesRequest.getFinalData(),
                "FinalData should be greater than InitialData");
        checkArgument(StringUtils.isNotBlank(notesRequest.getNote()), "Note number is not valid");

        Optional<CustomNote> note = notesApp.selectOneNote(notesRequest.getNoteId());
        if(!note.isPresent()) {
            System.out.printf("Note #%s note found.%n", notesRequest.getNoteId());
            throw new WebApplicationException("Note Not Found", Response.Status.NOT_FOUND);
        }

        if (note.get().getIdchofer().intValue() != notesRequest.getEmployeeId().intValue()) {
            System.out.printf("EmployeeId does not match for note %s on update operation.%n", notesRequest.getNoteId());
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        if(!note.get().getNonota().equals(notesRequest.getNote())) {
            System.out.printf("Note-Number does not match for note %s on update operation.%n", notesRequest.getNoteId());
            System.out.printf("Current Note: %s%n", note.get().getNonota());
            System.out.printf("Note from Request: %s%n", notesRequest.getNote());
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        if(note.get().getIdpedido().intValue() != notesRequest.getOrderId()) {
            System.out.printf("OrderId does not match for note %s on update operation.%n", notesRequest.getNoteId());
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        calculatePaymentForNote(notesRequest);

        System.out.printf("Proceeding to update note %s%n", notesRequest.getNote());
        int result = notesApp.updateNote(notesConverter.apply(notesRequest));
        int validState = 1;
        if(result != validState) {
            throw new WebApplicationException("Note record not updated", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Note updated successfully");
        return Response.ok().build();
    }

    private void calculatePaymentForNote(NotesRequest notesRequest) {

        int discount = notesRequest.getDiscount() != null ? notesRequest.getDiscount() : 0;
        long liters = notesRequest.getFinalData() - (notesRequest.getInitialData() + discount);
        double paymentTotal = liters * notesRequest.getPrice().doubleValue();
        if(notesRequest.getLiters() != liters &&
                notesRequest.getTotal() != paymentTotal) {
            System.out.println("Note Payment details are not the same!");
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        long realLiters = notesRequest.getFinalData() - notesRequest.getInitialData();
        if(notesRequest.getDiscount() != null && (notesRequest.getDiscount() > realLiters)) {
            System.out.printf("Discount should not be greater than totalLiters. note %s on update operation.%n", notesRequest.getNoteId());
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }
    }

    private void verifyAdminRole() {
        if (!userClaim.getSubject().equals("ADMINISTRADOR")) {
            System.out.println(userClaim.getSubject());
            System.out.println("UserClaim is not admin");
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public Response deleteNote(int noteId) {
        verifyAdminRole();

        checkArgument(noteId > 0, "Invalid NoteId");

        Optional<CustomNote> note = notesApp.selectOneNote(noteId);
        if(!note.isPresent()) {
            System.out.printf("Note #%d not found, so not able to deleteMark.%n", noteId);
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        int result = notesApp.deleteMarkNote(noteId);
        if(result != 1) {
            System.out.printf("Not able to deleteMark note #%d.%n", noteId);
            throw new WebApplicationException("Internal Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("DeleteMark for note #%d done successfully.%n", noteId);

        System.out.printf("About to set SerieError related to Note #%d%n", noteId);
        Serieerror error = new Serieerror();
        error.setId(null);
        error.setFecharegistro(Instant.now());
        error.setNonota(String.format("%s", note.get().getNonota()));
        error.setIdchofer(note.get().getIdchofer());
        //todo: this text is only valid if JWT validation is properly done: ADMIN
        error.setObservaciones("Nota Eliminada por el ADMIN");
        if(blockErrorApp.insertBlockError(error) != 1) {
            System.out.printf("Could not set SerieError for note %d", noteId);
            throw new WebApplicationException("Error inserting SerieError", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Finished DeleteNote process successfully");
        return Response.ok().build();
    }

    @Override
    public NotePaymentResponseList fetchPaymentsFromNote(int noteId) {
        checkArgument(noteId > 0, "Invalid noteId");
        Optional<CustomNote> note = notesApp.selectOneNote(noteId);
        if(!note.isPresent()) {
            System.out.printf("Note #%s not found", noteId);
            throw new WebApplicationException("Note not found", Response.Status.NOT_FOUND);
        }

        NotePaymentResponseList responseList = new NotePaymentResponseList();
        List<CustomPayment> payments = abonoApp.selectPaymentsFromNote(noteId);
        Stream<PaymentResponse> paymentResponseStream = payments.stream().map(x -> {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPayment(x.getCantidad());
            paymentResponse.setEmployeeName(x.getEmployeeName());
            paymentResponse.setRegistration(new Date(x.getFecharegistro().toEpochMilli()));
            return paymentResponse;
        });

        responseList.setNotePayments(paymentResponseStream.collect(Collectors.toList()));
        return responseList;
    }
}
