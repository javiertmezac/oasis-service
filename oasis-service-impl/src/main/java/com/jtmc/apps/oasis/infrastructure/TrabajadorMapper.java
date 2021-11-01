package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.TrabajadorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Trabajador;
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
public interface TrabajadorMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.734064-07:00", comments="Source Table: Trabajador")
    BasicColumn[] selectList = BasicColumn.columnList(id, codigo, nombre, telefono, direccion, fecharegistro, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.721383-07:00", comments="Source Table: Trabajador")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.72269-07:00", comments="Source Table: Trabajador")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.723373-07:00", comments="Source Table: Trabajador")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Trabajador> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.724371-07:00", comments="Source Table: Trabajador")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Trabajador> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.725185-07:00", comments="Source Table: Trabajador")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TrabajadorResult")
    Optional<Trabajador> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.725952-07:00", comments="Source Table: Trabajador")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TrabajadorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="codigo", property="codigo", jdbcType=JdbcType.NVARCHAR),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.NVARCHAR),
        @Result(column="telefono", property="telefono", jdbcType=JdbcType.NVARCHAR),
        @Result(column="direccion", property="direccion", jdbcType=JdbcType.NVARCHAR),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Trabajador> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.727938-07:00", comments="Source Table: Trabajador")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.728425-07:00", comments="Source Table: Trabajador")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.728813-07:00", comments="Source Table: Trabajador")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.729322-07:00", comments="Source Table: Trabajador")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.729993-07:00", comments="Source Table: Trabajador")
    default int insert(Trabajador record) {
        return MyBatis3Utils.insert(this::insert, record, trabajador, c ->
            c.map(id).toProperty("id")
            .map(codigo).toProperty("codigo")
            .map(nombre).toProperty("nombre")
            .map(telefono).toProperty("telefono")
            .map(direccion).toProperty("direccion")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.731014-07:00", comments="Source Table: Trabajador")
    default int insertMultiple(Collection<Trabajador> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, trabajador, c ->
            c.map(id).toProperty("id")
            .map(codigo).toProperty("codigo")
            .map(nombre).toProperty("nombre")
            .map(telefono).toProperty("telefono")
            .map(direccion).toProperty("direccion")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.731569-07:00", comments="Source Table: Trabajador")
    default int insertSelective(Trabajador record) {
        return MyBatis3Utils.insert(this::insert, record, trabajador, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(codigo).toPropertyWhenPresent("codigo", record::getCodigo)
            .map(nombre).toPropertyWhenPresent("nombre", record::getNombre)
            .map(telefono).toPropertyWhenPresent("telefono", record::getTelefono)
            .map(direccion).toPropertyWhenPresent("direccion", record::getDireccion)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.735392-07:00", comments="Source Table: Trabajador")
    default Optional<Trabajador> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.736078-07:00", comments="Source Table: Trabajador")
    default List<Trabajador> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.736551-07:00", comments="Source Table: Trabajador")
    default List<Trabajador> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.736986-07:00", comments="Source Table: Trabajador")
    default Optional<Trabajador> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.737378-07:00", comments="Source Table: Trabajador")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, trabajador, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.737807-07:00", comments="Source Table: Trabajador")
    static UpdateDSL<UpdateModel> updateAllColumns(Trabajador record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(codigo).equalTo(record::getCodigo)
                .set(nombre).equalTo(record::getNombre)
                .set(telefono).equalTo(record::getTelefono)
                .set(direccion).equalTo(record::getDireccion)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.738492-07:00", comments="Source Table: Trabajador")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Trabajador record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(codigo).equalToWhenPresent(record::getCodigo)
                .set(nombre).equalToWhenPresent(record::getNombre)
                .set(telefono).equalToWhenPresent(record::getTelefono)
                .set(direccion).equalToWhenPresent(record::getDireccion)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.739388-07:00", comments="Source Table: Trabajador")
    default int updateByPrimaryKey(Trabajador record) {
        return update(c ->
            c.set(codigo).equalTo(record::getCodigo)
            .set(nombre).equalTo(record::getNombre)
            .set(telefono).equalTo(record::getTelefono)
            .set(direccion).equalTo(record::getDireccion)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.740074-07:00", comments="Source Table: Trabajador")
    default int updateByPrimaryKeySelective(Trabajador record) {
        return update(c ->
            c.set(codigo).equalToWhenPresent(record::getCodigo)
            .set(nombre).equalToWhenPresent(record::getNombre)
            .set(telefono).equalToWhenPresent(record::getTelefono)
            .set(direccion).equalToWhenPresent(record::getDireccion)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}