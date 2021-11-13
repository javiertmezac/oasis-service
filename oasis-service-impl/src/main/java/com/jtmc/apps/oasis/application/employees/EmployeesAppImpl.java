package com.jtmc.apps.oasis.application.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Trabajador;
import com.jtmc.apps.oasis.infrastructure.TrabajadorDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.TrabajadorMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import java.util.List;
import java.util.Optional;

public class EmployeesAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Trabajador> selectOne(int employeeId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            return mapper.selectOne(c -> c.where(TrabajadorDynamicSqlSupport.id, SqlBuilder.isEqualTo(employeeId))
                    .and(TrabajadorDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }

    public List<Trabajador> selectAllRecords() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            return mapper.select(c -> c.where(TrabajadorDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }
}
