package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomEmployee;
import com.jtmc.apps.oasis.domain.Trabajador;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.List;

import static com.jtmc.apps.oasis.infrastructure.TrabajadorDynamicSqlSupport.trabajador;

@Mapper
public interface CustomEmployeeMapper extends TrabajadorMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomEmployeeResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="codigo", property="codigo", jdbcType=JdbcType.NVARCHAR),
            @Result(column="nombre", property="nombre", jdbcType=JdbcType.NVARCHAR),
            @Result(column="telefono", property="telefono", jdbcType=JdbcType.NVARCHAR),
            @Result(column="direccion", property="direccion", jdbcType=JdbcType.NVARCHAR),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.DATE),
            @Result(column="status", property="status", jdbcType=JdbcType.BIT),
            @Result(column="nextBlockNumber", property="nextBlockNumber", jdbcType=JdbcType.INTEGER),
            @Result(column="blockStartNumber", property="blockStartNumber", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="blockEndNumber", property="blockEndNumber", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="letter", property="letter", jdbcType=JdbcType.NCHAR, id=true)
    })
    List<CustomEmployee> selectManyCustomEmployees(SelectStatementProvider selectStatement);

    @ResultMap("TrabajadorResult")
    default List<CustomEmployee> selectCustomEmployee(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectManyCustomEmployees, selectList, trabajador, completer);
    }
}
