package com.jtmc.apps.oasis.application.prices;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Preciogranel;
import com.jtmc.apps.oasis.infrastructure.PreciogranelMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import java.util.List;

public class PriceAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<Preciogranel> selectAllRecords() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PreciogranelMapper mapper = session.getMapper(PreciogranelMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }
}
