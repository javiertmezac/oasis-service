package com.jtmc.apps.oasis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.jtmc.apps.oasis.api.filter.CorsFilter;
import com.jtmc.apps.oasis.api.filter.JWTRequiredFilter;
import com.jtmc.apps.oasis.api.v1.blocks.BlockApi;
import com.jtmc.apps.oasis.api.v1.blocks.BlockApiImpl;
import com.jtmc.apps.oasis.api.v1.clients.ClientsApiImpl;
import com.jtmc.apps.oasis.api.v1.contacts.ContactsApi;
import com.jtmc.apps.oasis.api.v1.contacts.ContactsApiImpl;
import com.jtmc.apps.oasis.api.v1.employees.EmployeeApi;
import com.jtmc.apps.oasis.api.v1.employees.EmployeeApiImpl;
import com.jtmc.apps.oasis.api.v1.exceptions.GenericRuntimeException;
import com.jtmc.apps.oasis.api.v1.exceptions.GenericWebApplicationExceptionMapper;
import com.jtmc.apps.oasis.api.v1.healthcheck.HealthcheckApi;
import com.jtmc.apps.oasis.api.v1.healthcheck.HealthcheckApiImpl;
import com.jtmc.apps.oasis.api.v1.login.LoginApi;
import com.jtmc.apps.oasis.api.v1.login.LoginApiImpl;
import com.jtmc.apps.oasis.api.v1.notes.NotesApi;
import com.jtmc.apps.oasis.api.v1.notes.NotesApiImpl;
import com.jtmc.apps.oasis.api.v1.orders.OrdersApi;
import com.jtmc.apps.oasis.api.v1.orders.OrdersApiImpl;
import com.jtmc.apps.oasis.api.v1.payments.PaymentApi;
import com.jtmc.apps.oasis.api.v1.payments.PaymentApiImpl;
import com.jtmc.apps.oasis.api.v1.prices.PriceApi;
import com.jtmc.apps.oasis.api.v1.prices.PriceApiImpl;
import com.jtmc.apps.oasis.api.v1.annotations.JwtUserClaim;
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
            bind(ContactsApi.class).to(ContactsApiImpl.class);
            bind(OrdersApi.class).to(OrdersApiImpl.class);
            bind(EmployeeApi.class).to(EmployeeApiImpl.class);
            bind(NotesApi.class).to(NotesApiImpl.class);
            bind(BlockApi.class).to(BlockApiImpl.class);
            bind(PaymentApi.class).to(PaymentApiImpl.class);
            bind(PriceApi.class).to(PriceApiImpl.class);
            bind(JwtUserClaim.class).asEagerSingleton();


            Properties myProperties = new Properties();
            myProperties.setProperty("key", System.getenv("key"));
            Names.bindProperties(binder(), myProperties);


            ObjectMapper objectMapper = new ObjectMapper()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .registerModules(new JavaTimeModule());
            JacksonJsonProvider jsonProvider = new JacksonJsonProvider(objectMapper);
            bind(ObjectMapper.class).toInstance(objectMapper);
            bind(JacksonJsonProvider.class).toInstance(jsonProvider);
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
                    injector.getInstance(GenericRuntimeException.class),
                    injector.getInstance(GenericWebApplicationExceptionMapper.class),
                    injector.getInstance(ClientsApiImpl.class),
                    injector.getInstance(HealthcheckApiImpl.class),
                    injector.getInstance(LoginApiImpl.class),
                    injector.getInstance(ContactsApiImpl.class),
                    injector.getInstance(OrdersApiImpl.class),
                    injector.getInstance(EmployeeApiImpl.class),
                    injector.getInstance(NotesApiImpl.class),
                    injector.getInstance(BlockApiImpl.class),
                    injector.getInstance(PaymentApiImpl.class),
                    injector.getInstance(PriceApiImpl.class)
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
