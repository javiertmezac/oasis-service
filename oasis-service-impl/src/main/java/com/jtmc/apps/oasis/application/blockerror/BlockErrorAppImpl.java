package com.jtmc.apps.oasis.application.blockerror;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Serieerror;
import com.jtmc.apps.oasis.infrastructure.SerieerrorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.Instant;

public class BlockErrorAppImpl {

    @Inject
    SqlSessionFactory sqlSessionFactory;

    private int insertBlockErrorSelective(Serieerror error) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            SerieerrorMapper mapper = session.getMapper(SerieerrorMapper.class);
            error.setStatus(true);
            return mapper.insertSelective(error);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void insertBlockError(String comments, String affectedNote, int employeeId) {

        System.out.println("About to create BlockError");

        Serieerror serieerror = new Serieerror();
        serieerror.setObservaciones(comments);
        serieerror.setNonota(affectedNote);
        serieerror.setIdchofer(employeeId);
        serieerror.setFecharegistro(Instant.now());
        serieerror.setId(null);

        if(this.insertBlockErrorSelective(serieerror) != 1) {
            System.out.println("Not able to insert BlockError");
            System.out.println(comments);
        }

        System.out.println("BlockError inserted successfully");
    }
}
