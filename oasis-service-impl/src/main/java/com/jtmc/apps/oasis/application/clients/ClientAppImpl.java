package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Optional;

public class ClientAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public void manyObjects() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
           EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
           Optional<Empresa> empresa = mapper.selectByPrimaryKey(200);
           empresa.ifPresent(c -> System.out.println(c.getNombre()));

        }
    }

    public void something() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            Optional<Empresa> empresa = mapper.selectByPrimaryKey(1);
            empresa.ifPresent(value ->  {
                System.out.println(value.getNombre());
                System.out.println(value.getFecharegistro());
            });
        }
    }
}
