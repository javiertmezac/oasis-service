package com.jtmc.apps.oasis.infrastructure.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.util.Properties;

public class OasisMyBatisModule extends MyBatisModule {

    @Override
    protected void initialize() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.host", System.getenv("JDBC_HOST"));
        myBatisProperties.setProperty("JDBC.port", "1433");
        myBatisProperties.setProperty("JDBC.schema", System.getenv("JDBC_SCHEMA"));
        myBatisProperties.setProperty("JDBC.username", "sa");
        myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));
        myBatisProperties.setProperty("JDBC.autoCommit", "false");

        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        Names.bindProperties(binder(), myBatisProperties);
        addMapperClass(EmpresaMapper.class);
    }
}
