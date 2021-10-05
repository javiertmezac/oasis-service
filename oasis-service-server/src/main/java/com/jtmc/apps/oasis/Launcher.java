package com.jtmc.apps.oasis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import com.jtmc.apps.oasis.infrastructure.guice.OasisMyBatisModule;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;

public class Launcher {

    public static void main(String[] args) {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.host", "localhost");
        myBatisProperties.setProperty("JDBC.port", "1433");
        myBatisProperties.setProperty("JDBC.schema", "DB_9B1BAC_dbOasis");
        myBatisProperties.setProperty("JDBC.username", "sa");
        myBatisProperties.setProperty("JDBC.password", "Password123!");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
//        myBatisProperties.setProperty("derby.create", "true");

        Injector injector = Guice.createInjector(
                JdbcHelper.SQL_Server_2005_MS_Driver,
                new OasisMyBatisModule(),
                binder -> Names.bindProperties(binder, myBatisProperties)
        );

        SqlSessionFactory sessionFactory = injector.getInstance(SqlSessionFactory.class);
        SqlSessionManager sessionManager = injector.getInstance(SqlSessionManager.class);
        EmpresaMapper clientApp = injector.getInstance(EmpresaMapper.class);
        clientApp.selectByPrimaryKey(1);
//        clientApp.something();
    }
}
