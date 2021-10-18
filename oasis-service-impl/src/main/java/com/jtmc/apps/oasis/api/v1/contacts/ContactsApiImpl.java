package com.jtmc.apps.oasis.api.v1.contacts;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.contacts.ContactsAppImpl;
import com.jtmc.apps.oasis.domain.Contacto;

import java.util.List;

public class ContactsApiImpl implements ContactsApi {

    @Inject
    private ContactsAppImpl contactsApp;

    @Override
    public ContactsResponseList getContacts() {
        List<Contacto> contactList = contactsApp.selectAllRows();
    }

    @Override
    public ContactsResponse getContact(int contactId) {
        return null;
    }
}
