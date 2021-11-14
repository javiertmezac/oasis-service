package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.CustomOrder;
import com.jtmc.apps.oasis.domain.Pedido;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

import static com.jtmc.apps.oasis.infrastructure.PedidoDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CustomOrderMapper extends PedidoMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomOrderResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="idEmpresa", property="idempresa", jdbcType=JdbcType.INTEGER),
            @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="fechaEntregar", property="fechaentregar", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="observaciones", property="observaciones", jdbcType=JdbcType.NVARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.BIT),
            @Result(column="idNotificacion", property="idnotificacion", jdbcType=JdbcType.INTEGER),
            @Result(column="idPrioridad", property="idprioridad", jdbcType=JdbcType.INTEGER),
            @Result(column="clientName", property="clientName", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
    })
    List<CustomOrder> selectManyCustomOrders(SelectStatementProvider selectStatement);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @ResultMap("CustomOrderResult")
    Optional<CustomOrder> selectOneCustomOrder(SelectStatementProvider selectStatementProvider);
}
