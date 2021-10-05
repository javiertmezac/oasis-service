package com.jtmc.apps.oasis.infrastructure.guice;

import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

public class OasisMyBatisModule extends MyBatisModule {

    @Override
    protected void initialize() {

        bindDataSourceProvider(UnpooledDataSource::new);
//        bindDataSourceProvider(PooledDataSource::new);
        bindTransactionFactory(JdbcTransactionFactory::new);

        addMapperClass(EmpresaMapper.class);
    }

//            new MyBatisModule() {
//                public void configure(Binder binder) {
//                    setDataSourceProviderType(PooledDataSourceProvider.class);
//                    addSimpleAliases(Contact.class);
//                    addMapperClasses(ContactMapper.class);
//                }
//            }
}
