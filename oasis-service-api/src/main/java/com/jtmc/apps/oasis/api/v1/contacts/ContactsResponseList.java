package com.jtmc.apps.oasis.api.v1.contacts;

import java.util.List;

public class ContactsResponseList {

    private List<ContactsResponse> contactsList;

    public List<ContactsResponse> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<ContactsResponse> contactsList) {
        this.contactsList = contactsList;
    }
}
