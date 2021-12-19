package com.jtmc.apps.oasis.api.v1.clients;

import com.jtmc.apps.oasis.domain.ClientCleaningTank;

import java.util.Date;
import java.util.function.Function;

public class CleaningTankConverter implements Function<ClientCleaningTank, CleaningTank> {
    @Override
    public CleaningTank apply(ClientCleaningTank clientCleaningTank) {
       CleaningTank response = new CleaningTank();
       response.setId(clientCleaningTank.getId());
       response.setCleaningDate(new Date(clientCleaningTank.getTankcleaningdate().toEpochMilli()));
       response.setComments(clientCleaningTank.getComments());
       return response;
    }
}
