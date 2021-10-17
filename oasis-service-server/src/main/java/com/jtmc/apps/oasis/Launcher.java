package com.jtmc.apps.oasis;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.jtmc.apps.oasis.api.filter.CorsFilter;
import com.jtmc.apps.oasis.api.filter.JWTRequiredFilter;
import com.jtmc.apps.oasis.api.v1.clients.ClientsApiImpl;
import com.jtmc.apps.oasis.api.v1.healthcheck.HealthcheckApi;
import com.jtmc.apps.oasis.api.v1.healthcheck.HealthcheckApiImpl;
import com.jtmc.apps.oasis.api.v1.login.LoginApi;
import com.jtmc.apps.oasis.api.v1.login.LoginApiImpl;
import com.jtmc.apps.oasis.infrastructure.guice.OasisMyBatisModule;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {
        startJettyServer();
    }

    private static class JettyLauncherModule extends AbstractModule {

        @Override
        protected void configure() {
            install(new OasisMyBatisModule());
            install(JdbcHelper.SQL_Server_2005_MS_Driver);

            bind(ClientsApiImpl.class);
            bind(HealthcheckApi.class).to(HealthcheckApiImpl.class);
            bind(LoginApi.class).to(LoginApiImpl.class);


            Properties myProperties = new Properties();
            myProperties.setProperty("key", System.getenv("key"));
            Names.bindProperties(binder(), myProperties);
        }
    }

    private static class OasisApplication extends GuiceApplication {
        @Override
        protected Set<Module> modules() {
            return Sets.newHashSet(new JettyLauncherModule());
        }

        @Override
        protected Set<Object> serviceInstances(Injector injector) {
            return Sets.newHashSet(
                    injector.getInstance(CorsFilter.class),
                    injector.getInstance(JWTRequiredFilter.class),
                    injector.getInstance(JacksonJsonProvider.class),
                    injector.getInstance(ClientsApiImpl.class),
                    injector.getInstance(HealthcheckApiImpl.class),
                    injector.getInstance(LoginApiImpl.class)
            );
        }
    }

    private static void startJettyServer() {

        HandlerCollection handlers = new HandlerCollection();

        //servletContextHandler
        ServletHolder servletHolder = new ServletHolder(
                new CXFNonSpringJaxrsServlet(new OasisApplication()));
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/oasis-service/api/*");

        handlers.addHandler(servletContextHandler);


        Server jettyServer = new Server();
        ServerConnector serverConnector = new ServerConnector(jettyServer);
        serverConnector.setPort(8080);
        jettyServer.addConnector(serverConnector);

        jettyServer.setHandler(handlers);


        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception ex) {
            //todo: implement logger
//            LOGGER.error(ex.getMessage());
            System.out.println(ex.getMessage());
        } finally {
            jettyServer.destroy();
        }
    }
}
