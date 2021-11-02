package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.NotaDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Nota;
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
public interface NotaMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.167944-07:00", comments="Source Table: Nota")
    BasicColumn[] selectList = BasicColumn.columnList(id, nonota, idpedido, idchofer, fecharegistro, litros, creditocontado, total, lecturainicial, lecturafinal, llegada, descarga, salida, precio, status, litrosdescontados, razondescuento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.159479-07:00", comments="Source Table: Nota")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.160267-07:00", comments="Source Table: Nota")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.160647-07:00", comments="Source Table: Nota")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Nota> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.161234-07:00", comments="Source Table: Nota")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Nota> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.161689-07:00", comments="Source Table: Nota")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NotaResult")
    Optional<Nota> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.162105-07:00", comments="Source Table: Nota")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NotaResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="noNota", property="nonota", jdbcType=JdbcType.VARCHAR),
        @Result(column="idPedido", property="idpedido", jdbcType=JdbcType.INTEGER),
        @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
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
    List<Nota> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.163221-07:00", comments="Source Table: Nota")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.163574-07:00", comments="Source Table: Nota")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.163889-07:00", comments="Source Table: Nota")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.16423-07:00", comments="Source Table: Nota")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.164612-07:00", comments="Source Table: Nota")
    default int insert(Nota record) {
        return MyBatis3Utils.insert(this::insert, record, nota, c ->
            c.map(id).toProperty("id")
            .map(nonota).toProperty("nonota")
            .map(idpedido).toProperty("idpedido")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(litros).toProperty("litros")
            .map(creditocontado).toProperty("creditocontado")
            .map(total).toProperty("total")
            .map(lecturainicial).toProperty("lecturainicial")
            .map(lecturafinal).toProperty("lecturafinal")
            .map(llegada).toProperty("llegada")
            .map(descarga).toProperty("descarga")
            .map(salida).toProperty("salida")
            .map(precio).toProperty("precio")
            .map(status).toProperty("status")
            .map(litrosdescontados).toProperty("litrosdescontados")
            .map(razondescuento).toProperty("razondescuento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.165532-07:00", comments="Source Table: Nota")
    default int insertMultiple(Collection<Nota> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, nota, c ->
            c.map(id).toProperty("id")
            .map(nonota).toProperty("nonota")
            .map(idpedido).toProperty("idpedido")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(litros).toProperty("litros")
            .map(creditocontado).toProperty("creditocontado")
            .map(total).toProperty("total")
            .map(lecturainicial).toProperty("lecturainicial")
            .map(lecturafinal).toProperty("lecturafinal")
            .map(llegada).toProperty("llegada")
            .map(descarga).toProperty("descarga")
            .map(salida).toProperty("salida")
            .map(precio).toProperty("precio")
            .map(status).toProperty("status")
            .map(litrosdescontados).toProperty("litrosdescontados")
            .map(razondescuento).toProperty("razondescuento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.166035-07:00", comments="Source Table: Nota")
    default int insertSelective(Nota record) {
        return MyBatis3Utils.insert(this::insert, record, nota, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(nonota).toPropertyWhenPresent("nonota", record::getNonota)
            .map(idpedido).toPropertyWhenPresent("idpedido", record::getIdpedido)
            .map(idchofer).toPropertyWhenPresent("idchofer", record::getIdchofer)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(litros).toPropertyWhenPresent("litros", record::getLitros)
            .map(creditocontado).toPropertyWhenPresent("creditocontado", record::getCreditocontado)
            .map(total).toPropertyWhenPresent("total", record::getTotal)
            .map(lecturainicial).toPropertyWhenPresent("lecturainicial", record::getLecturainicial)
            .map(lecturafinal).toPropertyWhenPresent("lecturafinal", record::getLecturafinal)
            .map(llegada).toPropertyWhenPresent("llegada", record::getLlegada)
            .map(descarga).toPropertyWhenPresent("descarga", record::getDescarga)
            .map(salida).toPropertyWhenPresent("salida", record::getSalida)
            .map(precio).toPropertyWhenPresent("precio", record::getPrecio)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(litrosdescontados).toPropertyWhenPresent("litrosdescontados", record::getLitrosdescontados)
            .map(razondescuento).toPropertyWhenPresent("razondescuento", record::getRazondescuento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.168764-07:00", comments="Source Table: Nota")
    default Optional<Nota> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.169154-07:00", comments="Source Table: Nota")
    default List<Nota> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.169572-07:00", comments="Source Table: Nota")
    default List<Nota> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.169968-07:00", comments="Source Table: Nota")
    default Optional<Nota> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.170361-07:00", comments="Source Table: Nota")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, nota, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.170746-07:00", comments="Source Table: Nota")
    static UpdateDSL<UpdateModel> updateAllColumns(Nota record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(nonota).equalTo(record::getNonota)
                .set(idpedido).equalTo(record::getIdpedido)
                .set(idchofer).equalTo(record::getIdchofer)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(litros).equalTo(record::getLitros)
                .set(creditocontado).equalTo(record::getCreditocontado)
                .set(total).equalTo(record::getTotal)
                .set(lecturainicial).equalTo(record::getLecturainicial)
                .set(lecturafinal).equalTo(record::getLecturafinal)
                .set(llegada).equalTo(record::getLlegada)
                .set(descarga).equalTo(record::getDescarga)
                .set(salida).equalTo(record::getSalida)
                .set(precio).equalTo(record::getPrecio)
                .set(status).equalTo(record::getStatus)
                .set(litrosdescontados).equalTo(record::getLitrosdescontados)
                .set(razondescuento).equalTo(record::getRazondescuento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.171252-07:00", comments="Source Table: Nota")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Nota record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(nonota).equalToWhenPresent(record::getNonota)
                .set(idpedido).equalToWhenPresent(record::getIdpedido)
                .set(idchofer).equalToWhenPresent(record::getIdchofer)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(litros).equalToWhenPresent(record::getLitros)
                .set(creditocontado).equalToWhenPresent(record::getCreditocontado)
                .set(total).equalToWhenPresent(record::getTotal)
                .set(lecturainicial).equalToWhenPresent(record::getLecturainicial)
                .set(lecturafinal).equalToWhenPresent(record::getLecturafinal)
                .set(llegada).equalToWhenPresent(record::getLlegada)
                .set(descarga).equalToWhenPresent(record::getDescarga)
                .set(salida).equalToWhenPresent(record::getSalida)
                .set(precio).equalToWhenPresent(record::getPrecio)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(litrosdescontados).equalToWhenPresent(record::getLitrosdescontados)
                .set(razondescuento).equalToWhenPresent(record::getRazondescuento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.17199-07:00", comments="Source Table: Nota")
    default int updateByPrimaryKey(Nota record) {
        return update(c ->
            c.set(nonota).equalTo(record::getNonota)
            .set(idpedido).equalTo(record::getIdpedido)
            .set(idchofer).equalTo(record::getIdchofer)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(litros).equalTo(record::getLitros)
            .set(creditocontado).equalTo(record::getCreditocontado)
            .set(total).equalTo(record::getTotal)
            .set(lecturainicial).equalTo(record::getLecturainicial)
            .set(lecturafinal).equalTo(record::getLecturafinal)
            .set(llegada).equalTo(record::getLlegada)
            .set(descarga).equalTo(record::getDescarga)
            .set(salida).equalTo(record::getSalida)
            .set(precio).equalTo(record::getPrecio)
            .set(status).equalTo(record::getStatus)
            .set(litrosdescontados).equalTo(record::getLitrosdescontados)
            .set(razondescuento).equalTo(record::getRazondescuento)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.172574-07:00", comments="Source Table: Nota")
    default int updateByPrimaryKeySelective(Nota record) {
        return update(c ->
            c.set(nonota).equalToWhenPresent(record::getNonota)
            .set(idpedido).equalToWhenPresent(record::getIdpedido)
            .set(idchofer).equalToWhenPresent(record::getIdchofer)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(litros).equalToWhenPresent(record::getLitros)
            .set(creditocontado).equalToWhenPresent(record::getCreditocontado)
            .set(total).equalToWhenPresent(record::getTotal)
            .set(lecturainicial).equalToWhenPresent(record::getLecturainicial)
            .set(lecturafinal).equalToWhenPresent(record::getLecturafinal)
            .set(llegada).equalToWhenPresent(record::getLlegada)
            .set(descarga).equalToWhenPresent(record::getDescarga)
            .set(salida).equalToWhenPresent(record::getSalida)
            .set(precio).equalToWhenPresent(record::getPrecio)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(litrosdescontados).equalToWhenPresent(record::getLitrosdescontados)
            .set(razondescuento).equalToWhenPresent(record::getRazondescuento)
            .where(id, isEqualTo(record::getId))
        );
    }
}