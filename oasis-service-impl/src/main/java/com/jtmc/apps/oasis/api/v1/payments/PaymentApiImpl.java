package com.jtmc.apps.oasis.api.v1.payments;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.abonos.AbonoAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.application.orders.OrdersAppImpl;
import com.jtmc.apps.oasis.domain.Abono;
import com.jtmc.apps.oasis.domain.Nota;
import com.jtmc.apps.oasis.domain.Trabajador;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class PaymentApiImpl implements PaymentApi {

   @Inject
   private AbonoAppImpl abonoApp;

   @Inject
   private EmployeesAppImpl employeesApp;

   @Inject
   private NotesAppImpl notesApp;

   @Inject
   private OrdersAppImpl ordersApp;

    @Override
    public Response insertPayment(PaymentRequest paymentRequest) {
        //todo: logger for paymentRequest?
        checkNotNull(paymentRequest, "Invalid PaymentRequest");

        int newPayment = 0;
        checkArgument(paymentRequest.getPaymentId() == newPayment, "Invalid PaymentId");
        checkArgument(paymentRequest.getEmployeeId() > 0, "Invalid EmployeeId");
        checkArgument(paymentRequest.getNoteId() > 0, "Invalid NoteId");
        checkNotNull(paymentRequest.getRegistration(), "Invalid RegistrationDate");
        checkArgument(paymentRequest.getTotal() > 0.0, "Invalid Total");

        System.out.printf("PaymentRequest.Total: %s.%n",paymentRequest.getTotal());

        Optional<Trabajador> employee = employeesApp.selectOne(paymentRequest.getEmployeeId());
        if(!employee.isPresent()) {
            System.out.printf("Employee $%d not found.%n", paymentRequest.getEmployeeId());
            throw new WebApplicationException("Employee Not Found", Response.Status.NOT_FOUND);
        }

        Optional<Nota> note = notesApp.selectOneNote(paymentRequest.getNoteId());
        if(!note.isPresent()) {
            System.out.printf("Note $%d not found.%n", paymentRequest.getNoteId());
            throw new WebApplicationException("Note Not Found", Response.Status.NOT_FOUND);
        }
        System.out.printf("Found NoteId %d Note %s.%n", note.get().getId(), note.get().getNonota());

        Optional<Abono> notePaymentStatus = abonoApp.selectNotePaymentStatus(note.get().getId());
        if(notePaymentStatus.isPresent()) {
            double remainingTotal = note.get().getTotal() - notePaymentStatus.get().getCantidad();
            System.out.printf("Found NotePaymentStatus, Current StatusPaymentAmount: %s, RemainingTotal: %s .%n",
                    notePaymentStatus.get().getCantidad(), remainingTotal);
            if (paymentRequest.getTotal() > remainingTotal) {
                System.out.println("It looks like PaymentTotal is greater than NoteRemainingTotal.");
                throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
            }
        } else {
            System.out.printf("Was not able to fetch NotePaymentStatus for NoteId %d.%n",
                    note.get().getId());
            if(paymentRequest.getTotal() > note.get().getTotal()) {
                System.out.println("It looks like PaymentTotal is greater than NoteTotal.");
                throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
            }
        }

        Abono payment = new Abono();
        payment.setCantidad(paymentRequest.getTotal());
        payment.setFecharegistro(paymentRequest.getRegistration());
        payment.setIdchofer(paymentRequest.getEmployeeId());
        payment.setIdnota(paymentRequest.getNoteId());
        payment.setId(null);

        int result = abonoApp.insertPayment(payment);
        if(result != 1) {
            System.out.println("Could not insert new Payment");
            throw new WebApplicationException("Payment not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.println("Payment inserted successfully");

        Optional<Abono> notePaymentStatusAfterPaying = abonoApp.selectNotePaymentStatus(note.get().getId());
        if (notePaymentStatusAfterPaying.isPresent() &&
                note.get().getTotal().doubleValue() ==
                        notePaymentStatusAfterPaying.get().getCantidad().doubleValue()) {
            System.out.printf("Order %d linked to Note %d should be marked as TERMINATED.%n",
                    note.get().getIdpedido(), note.get().getId());

            if(ordersApp.terminateOrder(note.get().getIdpedido()) != 1) {
                System.out.printf("Was not able to TERMINATE Order %d linked to Note %d.%n",
                        note.get().getIdpedido(), note.get().getId());
                throw new WebApplicationException("Order was not TERMINATED Correctly",
                        Response.Status.INTERNAL_SERVER_ERROR);
            }

            System.out.printf("Order %d linked to Note %d TERMINATED successfully.%n",
                    note.get().getIdpedido(), note.get().getId());
        } else {
            System.out.printf("Order %d linked to Note %d is not TERMINATED yet.%n",
                    note.get().getIdpedido(), note.get().getId());
        }

        return Response.ok().build();
    }
}
