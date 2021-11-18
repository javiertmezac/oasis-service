package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.SerieerrorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Serieerror;
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
public interface SerieerrorMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.262154-08:00", comments="Source Table: SerieError")
    BasicColumn[] selectList = BasicColumn.columnList(id, nonota, idchofer, fecharegistro, observaciones, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.252397-08:00", comments="Source Table: SerieError")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.253182-08:00", comments="Source Table: SerieError")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.253703-08:00", comments="Source Table: SerieError")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Serieerror> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.254313-08:00", comments="Source Table: SerieError")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Serieerror> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.254764-08:00", comments="Source Table: SerieError")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SerieerrorResult")
    Optional<Serieerror> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.255198-08:00", comments="Source Table: SerieError")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SerieerrorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="noNota", property="nonota", jdbcType=JdbcType.NVARCHAR),
        @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="observaciones", property="observaciones", jdbcType=JdbcType.NVARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Serieerror> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.2567-08:00", comments="Source Table: SerieError")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.257084-08:00", comments="Source Table: SerieError")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.25752-08:00", comments="Source Table: SerieError")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.257888-08:00", comments="Source Table: SerieError")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.258365-08:00", comments="Source Table: SerieError")
    default int insert(Serieerror record) {
        return MyBatis3Utils.insert(this::insert, record, serieerror, c ->
            c.map(id).toProperty("id")
            .map(nonota).toProperty("nonota")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(observaciones).toProperty("observaciones")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.259856-08:00", comments="Source Table: SerieError")
    default int insertMultiple(Collection<Serieerror> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, serieerror, c ->
            c.map(id).toProperty("id")
            .map(nonota).toProperty("nonota")
            .map(idchofer).toProperty("idchofer")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(observaciones).toProperty("observaciones")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.260333-08:00", comments="Source Table: SerieError")
    default int insertSelective(Serieerror record) {
        return MyBatis3Utils.insert(this::insert, record, serieerror, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(nonota).toPropertyWhenPresent("nonota", record::getNonota)
            .map(idchofer).toPropertyWhenPresent("idchofer", record::getIdchofer)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(observaciones).toPropertyWhenPresent("observaciones", record::getObservaciones)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.262952-08:00", comments="Source Table: SerieError")
    default Optional<Serieerror> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.263443-08:00", comments="Source Table: SerieError")
    default List<Serieerror> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.263843-08:00", comments="Source Table: SerieError")
    default List<Serieerror> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.264318-08:00", comments="Source Table: SerieError")
    default Optional<Serieerror> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.265148-08:00", comments="Source Table: SerieError")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, serieerror, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.266298-08:00", comments="Source Table: SerieError")
    static UpdateDSL<UpdateModel> updateAllColumns(Serieerror record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(nonota).equalTo(record::getNonota)
                .set(idchofer).equalTo(record::getIdchofer)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(observaciones).equalTo(record::getObservaciones)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.267382-08:00", comments="Source Table: SerieError")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Serieerror record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(nonota).equalToWhenPresent(record::getNonota)
                .set(idchofer).equalToWhenPresent(record::getIdchofer)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(observaciones).equalToWhenPresent(record::getObservaciones)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.268303-08:00", comments="Source Table: SerieError")
    default int updateByPrimaryKey(Serieerror record) {
        return update(c ->
            c.set(nonota).equalTo(record::getNonota)
            .set(idchofer).equalTo(record::getIdchofer)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(observaciones).equalTo(record::getObservaciones)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.268979-08:00", comments="Source Table: SerieError")
    default int updateByPrimaryKeySelective(Serieerror record) {
        return update(c ->
            c.set(nonota).equalToWhenPresent(record::getNonota)
            .set(idchofer).equalToWhenPresent(record::getIdchofer)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(observaciones).equalToWhenPresent(record::getObservaciones)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}