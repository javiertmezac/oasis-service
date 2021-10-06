package com.jtmc.apps.oasis;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.infrastructure.guice.OasisMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class Launcher {

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(
                JdbcHelper.SQL_Server_2005_MS_Driver,
                new OasisMyBatisModule(),
                new Module() {
                    @Override
                    public void configure(Binder binder) {
                    }
                }
        );

        ClientAppImpl client = injector.getInstance(ClientAppImpl.class);
        client.manyObjects();
    }
}
