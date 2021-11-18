package com.jtmc.apps.oasis.application.blockerror;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Serieerror;
import com.jtmc.apps.oasis.infrastructure.SerieerrorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BlockErrorAppImpl {

    @Inject
    SqlSessionFactory sqlSessionFactory;

    public int insertBlockError(Serieerror error) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            SerieerrorMapper mapper = session.getMapper(SerieerrorMapper.class);
            error.setStatus(true);
            return mapper.insertSelective(error);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
