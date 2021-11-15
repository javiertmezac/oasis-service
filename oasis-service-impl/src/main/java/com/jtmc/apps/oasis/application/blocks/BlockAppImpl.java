package com.jtmc.apps.oasis.application.blocks;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Bloque;
import com.jtmc.apps.oasis.infrastructure.BloqueDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.BloqueMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.Optional;

public class BlockAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Bloque> getNextNumberForActiveEmployee(int employeeId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            return mapper.selectOne(c -> c.where(BloqueDynamicSqlSupport.status, SqlBuilder.isTrue())
                    .and(BloqueDynamicSqlSupport.idchofer, SqlBuilder.isEqualTo(employeeId)));
        }
    }

    public int updateNextNumber(Bloque bloque) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            return mapper.updateByPrimaryKeySelective(bloque);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int insertBlock(Bloque b) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            b.setStatus(true);
            return mapper.insertSelective(b);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
