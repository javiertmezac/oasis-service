package com.jtmc.apps.oasis.api.v1.contacts;

import com.jtmc.apps.oasis.domain.Contacto;

import java.util.function.Function;

public class ContactsConverter implements Function<ContactRequest, Contacto> {
    @Override
    public Contacto apply(ContactRequest contactRequest) {
        Contacto c = new Contacto();
        c.setNombre(contactRequest.getContactName());
        c.setApellidop(contactRequest.getContactLastName());
        c.setId(contactRequest.getContactId());

        c.setApellidom(contactRequest.getContactSurName());
        c.setCelular(contactRequest.getContactPhone());
        c.setCasa(contactRequest.getContactTel());
        c.setEmail(contactRequest.getContactEmail());
        return c;
    }
}
