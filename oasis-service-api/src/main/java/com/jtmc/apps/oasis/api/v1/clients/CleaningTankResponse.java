package com.jtmc.apps.oasis.api.v1.clients;

import java.util.List;

public class CleaningTankResponse {

    private List<CleaningTank> cleaningTank;

    public List<CleaningTank> getCleaningTank() {
        return cleaningTank;
    }

    public void setCleaningTank(List<CleaningTank> cleaningTank) {
        this.cleaningTank = cleaningTank;
    }
}
