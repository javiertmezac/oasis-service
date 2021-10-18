package com.jtmc.apps.oasis.api.v1.contacts;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.application.contacts.ContactsAppImpl;
import com.jtmc.apps.oasis.domain.Contacto;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JWTRequired
public class ContactsApiImpl implements ContactsApi {

    @Inject
    private ContactsAppImpl contactsApp;

    @Inject
    private ContactsResponseConverter contactsResponseConverter;

    @Override
    public ContactsResponseList getContacts() {
        List<Contacto> contactList = contactsApp.selectAllRows();

        if (contactList == null || contactList.size() == 0) {
            throw new WebApplicationException("Could not getch ContactsList",
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
}
