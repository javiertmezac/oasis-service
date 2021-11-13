package com.jtmc.apps.oasis.application.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomEmployee;
import com.jtmc.apps.oasis.domain.Trabajador;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<CustomEmployee> selectAllRecords(boolean listBlockNumber) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomEmployeeMapper mapper = session.getMapper(CustomEmployeeMapper.class);

            if (listBlockNumber) {
                ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(TrabajadorMapper.selectList));
                list.add(BloqueDynamicSqlSupport.letra.as("letter"));
                list.add(BloqueDynamicSqlSupport.secuencia.as("nextBlockNumber"));

                SelectStatementProvider statementProvider = MyBatis3Utils
                        .select(BasicColumn.columnList(list.toArray(new BasicColumn[0])),
                                TrabajadorDynamicSqlSupport.trabajador,
                                c -> c.join(BloqueDynamicSqlSupport.bloque)
                                        .on(TrabajadorDynamicSqlSupport.id, SqlBuilder.equalTo(BloqueDynamicSqlSupport.idchofer))
                                        .where(BloqueDynamicSqlSupport.status, SqlBuilder.isTrue())
                                        .and(TrabajadorDynamicSqlSupport.status, SqlBuilder.isTrue())
                        );

                return mapper.selectManyCustomEmployees(statementProvider);
            } else {
                return mapper.selectCustomEmployee(c -> c.where(TrabajadorDynamicSqlSupport.status, SqlBuilder.isTrue()));
            }
        }
    }
}
