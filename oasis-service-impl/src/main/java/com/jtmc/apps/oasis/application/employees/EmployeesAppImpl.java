package com.jtmc.apps.oasis.application.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Trabajador;
import com.jtmc.apps.oasis.infrastructure.TrabajadorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Optional;

public class EmployeesAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Trabajador> selectOne(int employeeId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            return mapper.selectByPrimaryKey(employeeId);
        }
    }
}
