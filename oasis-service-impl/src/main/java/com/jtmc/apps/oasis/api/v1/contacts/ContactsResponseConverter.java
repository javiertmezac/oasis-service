package com.jtmc.apps.oasis.api.v1.contacts;

import com.jtmc.apps.oasis.domain.Contacto;

import java.util.function.Function;

public class ContactsResponseConverter implements Function<Contacto, ContactsResponse> {

    @Override
    public ContactsResponse apply(Contacto contacto) {
        ContactsResponse response = new ContactsResponse();
        response.setContactId(contacto.getId());
        response.setContactName(contacto.getNombre());
        response.setContactLastName(contacto.getApellidop());
        response.setContactSurName(contacto.getApellidom());
        response.setContactPhone(contacto.getCelular());
        response.setContactTel(contacto.getCasa());
        response.setContactEmail(contacto.getEmail());
        return response;
    }
}
