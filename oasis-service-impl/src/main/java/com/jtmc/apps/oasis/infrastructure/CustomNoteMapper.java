package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomNote;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
}
