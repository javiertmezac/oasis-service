package com.jtmc.apps.oasis.api.v1.clients;

import com.jtmc.apps.oasis.domain.Empresa;

import java.util.function.Function;

public class ClientsResponseConverter implements Function<Empresa, ClientsResponse> {

    @Override
    public ClientsResponse apply(Empresa empresa) {
        ClientsResponse response = new ClientsResponse();
        response.setClientId(empresa.getId());
        response.setClientCode(empresa.getNocliente());
        response.setClientInvoice(empresa.getNofactura());
        response.setClientName(empresa.getNombre());
        response.setClientRfc(empresa.getRfc());
        response.setClientTel(empresa.getTelefono());
        response.setClientNeighborhood(empresa.getColonia());
        response.setClientStreet(empresa.getCalle());
        response.setClientNoInt(empresa.getNoint());
        response.setClientNoOut(empresa.getNoext());
        response.setClientCp(empresa.getCpostal());
        response.setClientStatus(empresa.getStatus());
        response.setClientRegistration(empresa.getFecharegistro());
        response.setClientPrice(empresa.getIdprecio());
        response.setClientNextClean(empresa.getFecharegistro());
        return response;
    }
}
