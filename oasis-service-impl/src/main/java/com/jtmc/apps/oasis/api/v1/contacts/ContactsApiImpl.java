package com.jtmc.apps.oasis.api.v1.contacts;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.application.contacts.ContactsAppImpl;
import com.jtmc.apps.oasis.domain.Contacto;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JWTRequired
public class ContactsApiImpl implements ContactsApi {

    @Inject
    private ContactsAppImpl contactsApp;

    @Inject
    private ContactsResponseConverter contactsResponseConverter;

    @Inject
    private ContactsConverter contactsConverter;

    @Override
    public ContactsResponseList getContacts() {
        List<Contacto> contactList = contactsApp.selectAllRows();

        if (contactList == null || contactList.size() == 0) {
            throw new WebApplicationException("Could not fetch ContactsList",
                    Response.Status.NOT_FOUND);
        }

        Stream<ContactsResponse> clientsResponseStream =
                contactList.stream().map(c -> contactsResponseConverter.apply(c));

        ContactsResponseList responseList = new ContactsResponseList();
        responseList.setContactsList(clientsResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public ContactsResponse getContact(int contactId) {
        Optional<Contacto> contact = contactsApp.selectOne(contactId);
        if (!contact.isPresent()) {
            throw new WebApplicationException("Contact not Found",
                    Response.Status.NOT_FOUND);
        }
        return contactsResponseConverter.apply(contact.get());
    }

    @Override
    public Response createContact(ContactRequest contactRequest) {
        checkNotNull(contactRequest, "ContactRequest object is null");
        checkArgument(StringUtils.isNotBlank(contactRequest.getContactName()), "ContactName is not valid");
        checkArgument(StringUtils.isNotBlank(contactRequest.getContactLastName()), "ContactLastName is not valid");

        int newContact = 0;
        checkArgument(contactRequest.getContactId() == newContact, "ContactId not valid");

        contactRequest.setContactId(null);
        int value = contactsApp.createContact(contactsConverter.apply(contactRequest));
        if (value != 1) {
            throw new WebApplicationException("Contact record not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Contact Inserted successfully");
        return Response.ok().build();
    }

    @Override
    public Response updateContact(ContactRequest contactRequest){
        checkNotNull(contactRequest, "ContactRequest object is null");
        checkArgument(StringUtils.isNotBlank(contactRequest.getContactName()), "ContactName is not valid");
        checkArgument(StringUtils.isNotBlank(contactRequest.getContactLastName()), "ContactLastName is not valid");

        int newContact = 0;
        checkArgument(contactRequest.getContactId() != newContact, "ContactId not valid");
        int value = contactsApp.updateContact(contactsConverter.apply(contactRequest));
        if (value != 1) {
            throw new WebApplicationException("Contact record not updated", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("Contact %d updated successfully", contactRequest.getContactId());
        return Response.ok().build();
    }

    @Override
    public Response deleteMarkerContact(int contactId) {
        checkArgument(contactId > 0, "Invalid Contact Id");

        int value = contactsApp.deleteMark(contactId);
        if(value != 1) {
            System.out.printf("Attempted to delete contactId %d but it failed.%n", contactId);
            throw new WebApplicationException("Contact was not deleted mark successfully",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("Contact %d was deleted marked successfully.%n", contactId);
        return Response.ok().build();
    }
}
