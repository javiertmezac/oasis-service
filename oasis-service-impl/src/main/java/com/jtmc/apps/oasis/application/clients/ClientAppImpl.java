package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;

public class ClientAppImpl {

    @Inject
    private EmpresaMapper mapper;

    public void something() {
        mapper.selectByPrimaryKey(1);
        System.out.println("FETCH FROM DB");
    }
}
