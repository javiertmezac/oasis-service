package com.jtmc.apps.oasis.infrastructure.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.oasis.infrastructure.*;
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
        myBatisProperties.setProperty("JDBC.port", System.getenv("JDBC_PORT"));
        myBatisProperties.setProperty("JDBC.schema", System.getenv("JDBC_SCHEMA"));
        myBatisProperties.setProperty("JDBC.username", System.getenv("JDBC_USER"));
        myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));
        myBatisProperties.setProperty("JDBC.autoCommit", "false");

        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        Names.bindProperties(binder(), myBatisProperties);
        addMapperClass(EmpresaMapper.class);
        addMapperClass(UsersMapper.class);
        addMapperClass(ContactoMapper.class);
        addMapperClass(PedidoMapper.class);
        addMapperClass(TrabajadorMapper.class);
        addMapperClass(NotaMapper.class);
        addMapperClass(AbonoMapper.class);
        addMapperClass(PreciogranelMapper.class);
        addMapperClass(BloqueMapper.class);

        addMapperClass(CustomOrderMapper.class);
        addMapperClass(CustomNoteMapper.class);
        addMapperClass(CustomClientMapper.class);
    }
}
