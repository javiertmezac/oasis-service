package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.PedidoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Pedido;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PedidoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.659561-07:00", comments="Source Table: Pedido")
    BasicColumn[] selectList = BasicColumn.columnList(id, idempresa, idchofer, fecharegistro, fechaentregar, observaciones, status, idnotificacion, idprioridad);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.64537-07:00", comments="Source Table: Pedido")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.646565-07:00", comments="Source Table: Pedido")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.647083-07:00", comments="Source Table: Pedido")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Pedido> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.647922-07:00", comments="Source Table: Pedido")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Pedido> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.648859-07:00", comments="Source Table: Pedido")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PedidoResult")
    Optional<Pedido> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.649823-07:00", comments="Source Table: Pedido")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PedidoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="idEmpresa", property="idempresa", jdbcType=JdbcType.INTEGER),
        @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fechaEntregar", property="fechaentregar", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="observaciones", property="observaciones", jdbcType=JdbcType.NVARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="idNotificacion", property="idnotificacion", jdbcType=JdbcType.INTEGER),
        @Result(column="idPrioridad", property="idprioridad", jdbcType=JdbcType.INTEGER)
    })
    List<Pedido> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.65173-07:00", comments="Source Table: Pedido")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.65243-07:00", comments="Source Table: Pedido")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.653062-07:00", comments="Source Table: Pedido")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.653615-07:00", comments="Source Table: Pedido")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.654393-07:00", comments="Source Table: Pedido")
    default int insert(Pedido record) {
        return MyBatis3Utils.insert(this::insert, record, pedido, c ->
            c.map(id).toProperty("id")
            .map(idempresa).toProperty("idempresa")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(fechaentregar).toProperty("fechaentregar")
            .map(observaciones).toProperty("observaciones")
            .map(status).toProperty("status")
            .map(idnotificacion).toProperty("idnotificacion")
            .map(idprioridad).toProperty("idprioridad")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.655898-07:00", comments="Source Table: Pedido")
    default int insertMultiple(Collection<Pedido> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, pedido, c ->
            c.map(id).toProperty("id")
            .map(idempresa).toProperty("idempresa")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(fechaentregar).toProperty("fechaentregar")
            .map(observaciones).toProperty("observaciones")
            .map(status).toProperty("status")
            .map(idnotificacion).toProperty("idnotificacion")
            .map(idprioridad).toProperty("idprioridad")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.656554-07:00", comments="Source Table: Pedido")
    default int insertSelective(Pedido record) {
        return MyBatis3Utils.insert(this::insert, record, pedido, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(idempresa).toPropertyWhenPresent("idempresa", record::getIdempresa)
            .map(idchofer).toPropertyWhenPresent("idchofer", record::getIdchofer)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(fechaentregar).toPropertyWhenPresent("fechaentregar", record::getFechaentregar)
            .map(observaciones).toPropertyWhenPresent("observaciones", record::getObservaciones)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(idnotificacion).toPropertyWhenPresent("idnotificacion", record::getIdnotificacion)
            .map(idprioridad).toPropertyWhenPresent("idprioridad", record::getIdprioridad)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.660887-07:00", comments="Source Table: Pedido")
    default Optional<Pedido> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.661416-07:00", comments="Source Table: Pedido")
    default List<Pedido> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.661908-07:00", comments="Source Table: Pedido")
    default List<Pedido> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.662643-07:00", comments="Source Table: Pedido")
    default Optional<Pedido> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.66324-07:00", comments="Source Table: Pedido")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, pedido, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.66378-07:00", comments="Source Table: Pedido")
    static UpdateDSL<UpdateModel> updateAllColumns(Pedido record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(idempresa).equalTo(record::getIdempresa)
                .set(idchofer).equalTo(record::getIdchofer)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(fechaentregar).equalTo(record::getFechaentregar)
                .set(observaciones).equalTo(record::getObservaciones)
                .set(status).equalTo(record::getStatus)
                .set(idnotificacion).equalTo(record::getIdnotificacion)
                .set(idprioridad).equalTo(record::getIdprioridad);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.664671-07:00", comments="Source Table: Pedido")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Pedido record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(idempresa).equalToWhenPresent(record::getIdempresa)
                .set(idchofer).equalToWhenPresent(record::getIdchofer)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(fechaentregar).equalToWhenPresent(record::getFechaentregar)
                .set(observaciones).equalToWhenPresent(record::getObservaciones)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(idnotificacion).equalToWhenPresent(record::getIdnotificacion)
                .set(idprioridad).equalToWhenPresent(record::getIdprioridad);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.665782-07:00", comments="Source Table: Pedido")
    default int updateByPrimaryKey(Pedido record) {
        return update(c ->
            c.set(idempresa).equalTo(record::getIdempresa)
            .set(idchofer).equalTo(record::getIdchofer)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(fechaentregar).equalTo(record::getFechaentregar)
            .set(observaciones).equalTo(record::getObservaciones)
            .set(status).equalTo(record::getStatus)
            .set(idnotificacion).equalTo(record::getIdnotificacion)
            .set(idprioridad).equalTo(record::getIdprioridad)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.666647-07:00", comments="Source Table: Pedido")
    default int updateByPrimaryKeySelective(Pedido record) {
        return update(c ->
            c.set(idempresa).equalToWhenPresent(record::getIdempresa)
            .set(idchofer).equalToWhenPresent(record::getIdchofer)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(fechaentregar).equalToWhenPresent(record::getFechaentregar)
            .set(observaciones).equalToWhenPresent(record::getObservaciones)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(idnotificacion).equalToWhenPresent(record::getIdnotificacion)
            .set(idprioridad).equalToWhenPresent(record::getIdprioridad)
            .where(id, isEqualTo(record::getId))
        );
    }
}