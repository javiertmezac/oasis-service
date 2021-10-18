package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.ContactoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Contacto;
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
public interface ContactoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.154859-07:00", comments="Source Table: Contacto")
    BasicColumn[] selectList = BasicColumn.columnList(id, nombre, apellidop, apellidom, celular, casa, email, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.139716-07:00", comments="Source Table: Contacto")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.141146-07:00", comments="Source Table: Contacto")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.141993-07:00", comments="Source Table: Contacto")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Contacto> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.143135-07:00", comments="Source Table: Contacto")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Contacto> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.144124-07:00", comments="Source Table: Contacto")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContactoResult")
    Optional<Contacto> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.144851-07:00", comments="Source Table: Contacto")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContactoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellidoP", property="apellidop", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellidoM", property="apellidom", jdbcType=JdbcType.VARCHAR),
        @Result(column="celular", property="celular", jdbcType=JdbcType.VARCHAR),
        @Result(column="casa", property="casa", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Contacto> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.146824-07:00", comments="Source Table: Contacto")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.147411-07:00", comments="Source Table: Contacto")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.147952-07:00", comments="Source Table: Contacto")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.148616-07:00", comments="Source Table: Contacto")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.14934-07:00", comments="Source Table: Contacto")
    default int insert(Contacto record) {
        return MyBatis3Utils.insert(this::insert, record, contacto, c ->
            c.map(id).toProperty("id")
            .map(nombre).toProperty("nombre")
            .map(apellidop).toProperty("apellidop")
            .map(apellidom).toProperty("apellidom")
            .map(celular).toProperty("celular")
            .map(casa).toProperty("casa")
            .map(email).toProperty("email")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.151229-07:00", comments="Source Table: Contacto")
    default int insertMultiple(Collection<Contacto> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, contacto, c ->
            c.map(id).toProperty("id")
            .map(nombre).toProperty("nombre")
            .map(apellidop).toProperty("apellidop")
            .map(apellidom).toProperty("apellidom")
            .map(celular).toProperty("celular")
            .map(casa).toProperty("casa")
            .map(email).toProperty("email")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.152107-07:00", comments="Source Table: Contacto")
    default int insertSelective(Contacto record) {
        return MyBatis3Utils.insert(this::insert, record, contacto, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(nombre).toPropertyWhenPresent("nombre", record::getNombre)
            .map(apellidop).toPropertyWhenPresent("apellidop", record::getApellidop)
            .map(apellidom).toPropertyWhenPresent("apellidom", record::getApellidom)
            .map(celular).toPropertyWhenPresent("celular", record::getCelular)
            .map(casa).toPropertyWhenPresent("casa", record::getCasa)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.156018-07:00", comments="Source Table: Contacto")
    default Optional<Contacto> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.156582-07:00", comments="Source Table: Contacto")
    default List<Contacto> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.157137-07:00", comments="Source Table: Contacto")
    default List<Contacto> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.15792-07:00", comments="Source Table: Contacto")
    default Optional<Contacto> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.158485-07:00", comments="Source Table: Contacto")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contacto, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.158981-07:00", comments="Source Table: Contacto")
    static UpdateDSL<UpdateModel> updateAllColumns(Contacto record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(nombre).equalTo(record::getNombre)
                .set(apellidop).equalTo(record::getApellidop)
                .set(apellidom).equalTo(record::getApellidom)
                .set(celular).equalTo(record::getCelular)
                .set(casa).equalTo(record::getCasa)
                .set(email).equalTo(record::getEmail)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.159571-07:00", comments="Source Table: Contacto")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Contacto record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(nombre).equalToWhenPresent(record::getNombre)
                .set(apellidop).equalToWhenPresent(record::getApellidop)
                .set(apellidom).equalToWhenPresent(record::getApellidom)
                .set(celular).equalToWhenPresent(record::getCelular)
                .set(casa).equalToWhenPresent(record::getCasa)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.160449-07:00", comments="Source Table: Contacto")
    default int updateByPrimaryKey(Contacto record) {
        return update(c ->
            c.set(nombre).equalTo(record::getNombre)
            .set(apellidop).equalTo(record::getApellidop)
            .set(apellidom).equalTo(record::getApellidom)
            .set(celular).equalTo(record::getCelular)
            .set(casa).equalTo(record::getCasa)
            .set(email).equalTo(record::getEmail)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.161033-07:00", comments="Source Table: Contacto")
    default int updateByPrimaryKeySelective(Contacto record) {
        return update(c ->
            c.set(nombre).equalToWhenPresent(record::getNombre)
            .set(apellidop).equalToWhenPresent(record::getApellidop)
            .set(apellidom).equalToWhenPresent(record::getApellidom)
            .set(celular).equalToWhenPresent(record::getCelular)
            .set(casa).equalToWhenPresent(record::getCasa)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}