package com.jtmc.apps.oasis.application.blocks;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Bloque;
import com.jtmc.apps.oasis.infrastructure.BloqueDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.BloqueMapper;
import com.jtmc.apps.oasis.infrastructure.CustomBlockMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;

import java.util.Optional;

public class BlockAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Bloque> getBlockForActiveEmployee(int employeeId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            return mapper.selectOne(c -> c.where(BloqueDynamicSqlSupport.status, SqlBuilder.isTrue())
                    .and(BloqueDynamicSqlSupport.idchofer, SqlBuilder.isEqualTo(employeeId)));
        }
    }

    public int updateNextNumber(Bloque b) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            return mapper.updateByPrimaryKeySelective(b);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /*
      Block table has PK (id, letter, startNumber, endNumber)
      the requirement is to update any of these values, so if block already present
      we are only using table's id value as constraint
     */
    public int customUpdateBlock(Bloque bloque) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            CustomBlockMapper mapper = session.getMapper(CustomBlockMapper.class);
            return mapper.updateByIdSelective(bloque);
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

    public Optional<Bloque> selectOne(int blockId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            return mapper.selectOne(c -> c.where(BloqueDynamicSqlSupport.id, SqlBuilder.isEqualTo(blockId))
                    .and(BloqueDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }

    public int deleteMarkBlock(Bloque b) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BloqueMapper mapper = session.getMapper(BloqueMapper.class);
            b.setStatus(false);
            return mapper.updateByPrimaryKeySelective(b);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
