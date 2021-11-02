package com.jtmc.apps.oasis.application.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomNote;
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

public class NotesAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<CustomNote> selectAllNonPaidNotes() {
       try(SqlSession session = sqlSessionFactory.openSession(true)) {
           CustomNoteMapper mapper = session.getMapper(CustomNoteMapper.class);


           ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(NotaMapper.selectList));
           list.add(EmpresaDynamicSqlSupport.nombre.as("clientName"));
           list.add(TrabajadorDynamicSqlSupport.nombre.as("employeeName"));

           BasicColumn[] basicColumns = BasicColumn.columnList(list.toArray(new BasicColumn[0]));

           SelectStatementProvider statementProvider = MyBatis3Utils
                   .select(basicColumns, NotaDynamicSqlSupport.nota,
                           c -> c.leftJoin(PedidoDynamicSqlSupport.pedido)
                                   .on(PedidoDynamicSqlSupport.id, SqlBuilder.equalTo(NotaDynamicSqlSupport.id))
                                   .leftJoin(EmpresaDynamicSqlSupport.empresa)
                                   .on(EmpresaDynamicSqlSupport.id, SqlBuilder.equalTo(PedidoDynamicSqlSupport.idchofer))
                                   .leftJoin(TrabajadorDynamicSqlSupport.trabajador)
                                   .on(TrabajadorDynamicSqlSupport.id, SqlBuilder.equalTo(NotaDynamicSqlSupport.idchofer))
                                   .where(NotaDynamicSqlSupport.status, SqlBuilder.isTrue())
                   );
           return mapper.selectManyCustomNotes(statementProvider);
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Something went wrong when trying to fetch Notes");
           throw new RuntimeException("Error while fetching Notes");
       }
    }
}
