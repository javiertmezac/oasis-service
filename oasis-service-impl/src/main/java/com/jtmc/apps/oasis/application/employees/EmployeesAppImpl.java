package com.jtmc.apps.oasis.application.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomEmployee;
import com.jtmc.apps.oasis.domain.Trabajador;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.join.JoinCriterion;
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

    public List<CustomEmployee> selectAllRecords() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomEmployeeMapper mapper = session.getMapper(CustomEmployeeMapper.class);

            ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(TrabajadorMapper.selectList));
            list.add(BloqueDynamicSqlSupport.letra.as("letter"));
            list.add(BloqueDynamicSqlSupport.secuencia.as("nextBlockNumber"));
            list.add(BloqueDynamicSqlSupport.numinicial.as("blockStartNumber"));
            list.add(BloqueDynamicSqlSupport.numfinal.as("blockEndNumber"));
            list.add(BloqueDynamicSqlSupport.id.as("blockId"));

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(BasicColumn.columnList(list.toArray(new BasicColumn[0])),
                            TrabajadorDynamicSqlSupport.trabajador,
                            c -> c.leftJoin(BloqueDynamicSqlSupport.bloque)
                                    .on(TrabajadorDynamicSqlSupport.id,
                                            SqlBuilder.equalTo(BloqueDynamicSqlSupport.idchofer),
                                            SqlBuilder.and(
                                                    BloqueDynamicSqlSupport.status,
                                                    SqlBuilder.equalTo(TrabajadorDynamicSqlSupport.status)
                                            )
                                    )
                                    .where(TrabajadorDynamicSqlSupport.status, SqlBuilder.isTrue())
                    );

            return mapper.selectManyCustomEmployees(statementProvider);
        }
    }

    public int deleteMark(Trabajador employee){
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            employee.setStatus(false);
            return mapper.updateByPrimaryKeySelective(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int insertEmployee(Trabajador e) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            e.setStatus(true);
            return mapper.insertSelective(e);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public int updateEmployee(Trabajador employee){
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TrabajadorMapper mapper = session.getMapper(TrabajadorMapper.class);
            return mapper.updateByPrimaryKeySelective(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
