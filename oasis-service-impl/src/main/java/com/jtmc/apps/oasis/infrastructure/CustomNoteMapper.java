package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomNote;
import com.jtmc.apps.oasis.domain.Nota;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface CustomNoteMapper extends NotaMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomNotaResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="noNota", property="nonota", jdbcType=JdbcType.VARCHAR),
            @Result(column="idPedido", property="idpedido", jdbcType=JdbcType.INTEGER),
            @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
            @Result(column="employeeName", property="employeeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="clientName", property="clientName", jdbcType=JdbcType.VARCHAR),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="litros", property="litros", jdbcType=JdbcType.INTEGER),
            @Result(column="creditoContado", property="creditocontado", jdbcType=JdbcType.BIT),
            @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
            @Result(column="debt", property="debt", jdbcType=JdbcType.DECIMAL),
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
    List<CustomNote> selectManyCustomNotes(SelectStatementProvider selectStatement);
}
