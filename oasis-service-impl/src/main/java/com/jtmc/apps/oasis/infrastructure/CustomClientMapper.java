package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomClientMapper extends EmpresaMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomEmpresaResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="noCliente", property="nocliente", jdbcType=JdbcType.VARCHAR),
            @Result(column="noFactura", property="nofactura", jdbcType=JdbcType.NVARCHAR),
            @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfc", property="rfc", jdbcType=JdbcType.VARCHAR),
            @Result(column="telefono", property="telefono", jdbcType=JdbcType.VARCHAR),
            @Result(column="colonia", property="colonia", jdbcType=JdbcType.VARCHAR),
            @Result(column="calle", property="calle", jdbcType=JdbcType.VARCHAR),
            @Result(column="noInt", property="noint", jdbcType=JdbcType.INTEGER),
            @Result(column="noExt", property="noext", jdbcType=JdbcType.INTEGER),
            @Result(column="cPostal", property="cpostal", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.BIT),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="idPrecio", property="idprecio", jdbcType=JdbcType.TINYINT),
            @Result(column="precio", property="precio", jdbcType=JdbcType.DECIMAL),
            @Result(column="sigLavado", property="siglavado", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CustomClient> selectManyCustomClient(SelectStatementProvider selectStatement);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @ResultMap("CustomEmpresaResult")
    Optional<CustomClient> selectOneCustomClient(SelectStatementProvider selectStatement);


}
