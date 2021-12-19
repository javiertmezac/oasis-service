package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.ClientCleaningTank;
import com.jtmc.apps.oasis.infrastructure.ClientCleaningTankMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static com.jtmc.apps.oasis.infrastructure.ClientCleaningTankDynamicSqlSupport.*;

public class ClientCleaningTankAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public int insertClientCleaningTank(ClientCleaningTank cleaningTank) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ClientCleaningTankMapper mapper = session.getMapper(ClientCleaningTankMapper.class);
            cleaningTank.setStatus(true);
            return mapper.insertSelective(cleaningTank);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<ClientCleaningTank> selectAllRecordsForGivenClient(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession(false)) {
            ClientCleaningTankMapper mapper = session.getMapper(ClientCleaningTankMapper.class);
            return mapper.select(c ->
                    c.where(status, SqlBuilder.isTrue())
                            .and(clientid, SqlBuilder.isEqualTo(clientId))
                            .orderBy(clientCleaningTank.tankcleaningdate.descending())
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public int deleteMarkCleaningTank(ClientCleaningTank cleaningTank) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ClientCleaningTankMapper mapper = session.getMapper(ClientCleaningTankMapper.class);
            cleaningTank.setStatus(false);
            return mapper.updateByPrimaryKeySelective(cleaningTank);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public ClientCleaningTank validateCleaningTankExist(int cleaningTankId) {
       Optional<ClientCleaningTank> cleaningTank = this.selectOne(cleaningTankId);
       if(!cleaningTank.isPresent()) {
           System.out.printf("CleaningTank #%d Not Found", cleaningTankId);
           throw new WebApplicationException("NOT FOUND", Response.Status.NOT_FOUND);
       }

       return cleaningTank.get();
    }

    public Optional<ClientCleaningTank> selectOne(int cleaningId) {
        try (SqlSession session = sqlSessionFactory.openSession(false)) {
            ClientCleaningTankMapper mapper = session.getMapper(ClientCleaningTankMapper.class);
            return mapper.selectOne(c ->
                    c.where(status, SqlBuilder.isTrue())
                            .and(id, SqlBuilder.isEqualTo(cleaningId))
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
