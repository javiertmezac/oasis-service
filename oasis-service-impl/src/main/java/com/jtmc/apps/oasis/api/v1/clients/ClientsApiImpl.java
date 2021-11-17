package com.jtmc.apps.oasis.api.v1.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JWTRequired
public class ClientsApiImpl implements ClientsApi {

    @Inject
    private ClientAppImpl clientApp;

    @Inject
    private ClientsResponseConverter clientsResponseConverter;

    @Inject
    private CustomClientsResponseConverter customClientsResponseConverter;

    @Override
    public ClientsResponseList getClients() {

        List<Empresa> empresaList = clientApp.selectAllRows();
        if(empresaList == null || empresaList.size() == 0) {
            throw new WebApplicationException("Could not fetch EmpresaList", Response.Status.NOT_FOUND);
        }

        Stream<ClientsResponse> clientsResponseStream = empresaList
                    .stream().map(c -> clientsResponseConverter.apply(c)
        );

        ClientsResponseList responseList = new ClientsResponseList();
        responseList.setClientsResponses(clientsResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public ClientsResponse getClient(int clientId) {
         Optional<CustomClient> empresa = clientApp.selectOne(clientId);

        if (!empresa.isPresent()){
            throw new WebApplicationException("Empresa not Found", Response.Status.NOT_FOUND);
        }

        return customClientsResponseConverter.apply(empresa.get());
    }

    @Override
    public Response insertClient(ClientRequest clientRequest) {
        checkNotNull(clientRequest, "Invalid ClientRequest");
        checkArgument(StringUtils.isNotBlank(clientRequest.getClientName()), "Invalid ClientName");
        checkArgument(StringUtils.isNotBlank(clientRequest.getClientCode()),
                "Invalid ClientCode / ClientTak");
        checkArgument(StringUtils.isNotBlank(clientRequest.getClientRfc()), "Invalid ClientRfc");
        int newClient = 0;
        checkArgument(clientRequest.getClientId() == newClient, "Invalid ClientId");
        checkArgument(clientRequest.getClientPriceId() > 0, "Invalid ClientPriceId");

        Empresa client = new Empresa();
        client.setId(null);
        client.setNocliente(clientRequest.getClientCode());
        client.setNofactura(clientRequest.getClientInvoice());
        client.setNombre(clientRequest.getClientName());
        client.setRfc(clientRequest.getClientRfc());
        client.setTelefono(clientRequest.getClientTel());
        client.setColonia(clientRequest.getClientNeighborhood());
        client.setCalle(clientRequest.getClientStreet());
        client.setNoint(clientRequest.getClientNoInt());
        client.setNoext(clientRequest.getClientNoOut());
        client.setCpostal(clientRequest.getClientCp());
        client.setFecharegistro(new Date(clientRequest.getClientInstantRegistration().getEpochSecond()));
        client.setIdprecio(clientRequest.getClientPriceId());
        client.setSiglavado(new Date(clientRequest.getClientInstantNextClean().getEpochSecond()));

        if (clientApp.insertClient(client) != 1) {
            System.out.println("Could not insert new Client Record");
            throw new WebApplicationException("Client/Empresa not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.println("Empresa/Client inserted successfully");
        return Response.ok().build();
    }
}
