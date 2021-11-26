package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.Abono;
import com.jtmc.apps.oasis.domain.CustomPayment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface CustomPaymentMapper extends AbonoMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CustomAbonoResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.DECIMAL),
            @Result(column="idNota", property="idnota", jdbcType=JdbcType.INTEGER),
            @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.BIT),
            @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
            @Result(column="employeeName", property="employeeName", jdbcType=JdbcType.NVARCHAR)
    })
    List<CustomPayment> selectManyCustomPayments(SelectStatementProvider selectStatement);
}
