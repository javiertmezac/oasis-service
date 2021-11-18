package com.jtmc.apps.oasis.api.v1.clients;

import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.CustomClientMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.function.Function;

public class CustomClientsResponseConverter implements Function<CustomClient, ClientsResponse> {

    @Override
    public ClientsResponse apply(CustomClient empresa) {
        ClientsResponse response = new ClientsResponse();
        response.setClientId(empresa.getId());
        response.setClientCode(empresa.getNocliente());
        response.setClientInvoice(empresa.getNofactura());
        response.setClientName(empresa.getNombre());
        response.setClientRfc(empresa.getRfc());
        response.setClientTel(empresa.getTelefono());
        response.setClientNeighborhood(empresa.getColonia());
        response.setClientStreet(empresa.getCalle());
        response.setClientNoInt(String.valueOf(empresa.getNoint()));
        response.setClientNoOut(String.valueOf(empresa.getNoext()));
        response.setClientCp(String.valueOf(empresa.getCpostal()));
        response.setClientStatus(empresa.getStatus());
        response.setClientRegistration(new Date(empresa.getFecharegistro().toEpochMilli()));
        response.setClientPriceId(empresa.getIdprecio());
        response.setClientNextClean(empresa.getSiglavado() != null ?
                new Date(empresa.getSiglavado().toEpochMilli()) : null);
        response.setClientPrice(empresa.getPrice());
        return response;
    }
}
