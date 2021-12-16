package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.ClientCleaningTank;
import com.jtmc.apps.oasis.infrastructure.ClientCleaningTankMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
}
