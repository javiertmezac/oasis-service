package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomNote;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.jtmc.apps.oasis.infrastructure.NotaDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface CustomNoteMapper extends NotaMapper {

    @Select(value = "{ call NotesList }")
    @Options(statementType = StatementType.CALLABLE)
    @Results(id="CustomNotaResult", value = {
            @Result(column="noteId", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="note", property="nonota", jdbcType=JdbcType.VARCHAR),
            @Result(column="orderId", property="idpedido", jdbcType=JdbcType.INTEGER),
            @Result(column="employeeName", property="employeeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="clientName", property="clientName", jdbcType=JdbcType.VARCHAR),
            @Result(column="registration", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="liters", property="litros", jdbcType=JdbcType.INTEGER),
            @Result(column="credit", property="creditocontado", jdbcType=JdbcType.BIT),
            @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
            @Result(column="debt", property="debt", jdbcType=JdbcType.DECIMAL),
    })
    List<CustomNote> selectManyCustomNotes();

    @Select(value = "{ call PaidNotesList }")
    @Options(statementType = StatementType.CALLABLE)
    @ResultMap("CustomNotaResult")
    List<CustomNote> selectPaidNotesSP();

    @Select("{ call PaidNotesListV2(#{offset_rows, mode=IN, jdbcType=INTEGER}, #{select_rows, mode=IN, jdbcType=INTEGER}, #{search, mode=IN, jdbcType=VARCHAR}) }")
    @Options(statementType = StatementType.CALLABLE)
    @ResultMap("CustomNotaResult")
    List<CustomNote> selectPaidNotesSPV2(@Param("offset_rows") Integer offsetRows,
                                         @Param("select_rows") Integer selectRows,
                                         @Param("search") String search);

    @Select("{ call CountAllPaidNotesWithSearch(#{search, mode=IN, jdbcType=VARCHAR}) }")
    @Options(statementType = StatementType.CALLABLE)
    long countAllPaidNotes(@Param("search") String search);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomOneNotaResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="noNota", property="nonota", jdbcType=JdbcType.VARCHAR),
            @Result(column="idPedido", property="idpedido", jdbcType=JdbcType.INTEGER),
            @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
            @Result(column="employeeName", property="employeeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="litros", property="litros", jdbcType=JdbcType.INTEGER),
            @Result(column="creditoContado", property="creditocontado", jdbcType=JdbcType.BIT),
            @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
            @Result(column="lecturaInicial", property="lecturainicial", jdbcType=JdbcType.BIGINT),
            @Result(column="lecturaFinal", property="lecturafinal", jdbcType=JdbcType.BIGINT),
            @Result(column="llegada", property="llegada", jdbcType=JdbcType.NCHAR),
            @Result(column="descarga", property="descarga", jdbcType=JdbcType.NCHAR),
            @Result(column="salida", property="salida", jdbcType=JdbcType.NCHAR),
            @Result(column="precio", property="precio", jdbcType=JdbcType.DECIMAL),
            @Result(column="status", property="status", jdbcType=JdbcType.BIT),
            @Result(column="litrosDescontados", property="litrosdescontados", jdbcType=JdbcType.INTEGER),
            @Result(column="razonDescuento", property="razondescuento", jdbcType=JdbcType.VARCHAR)
    })
    Optional<CustomNote> selectOneCustomNote(SelectStatementProvider selectStatementProvider);

    default Optional<CustomNote> selectByPrimaryKeyCustomNote(int noteId) {
        ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(selectList));
        list.add(TrabajadorDynamicSqlSupport.nombre.as("employeeName"));

       return MyBatis3Utils.selectOne(this::selectOneCustomNote,
               BasicColumn.columnList(list.toArray(new BasicColumn[0])),
               nota,
               c -> c.join(TrabajadorDynamicSqlSupport.trabajador)
                       .on(TrabajadorDynamicSqlSupport.id, equalTo(idchofer))
                       .where(id, isEqualTo(noteId))
                       .and(status, isTrue())
       );
    }
}
