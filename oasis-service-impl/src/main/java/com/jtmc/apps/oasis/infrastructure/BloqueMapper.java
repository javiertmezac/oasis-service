package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.BloqueDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Bloque;
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
public interface BloqueMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.740773-08:00", comments="Source Table: Bloque")
    BasicColumn[] selectList = BasicColumn.columnList(letra, numinicial, numfinal, id, idchofer, secuencia, fecharegistro, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.732458-08:00", comments="Source Table: Bloque")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.733197-08:00", comments="Source Table: Bloque")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.733568-08:00", comments="Source Table: Bloque")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Bloque> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.734159-08:00", comments="Source Table: Bloque")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Bloque> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.734606-08:00", comments="Source Table: Bloque")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BloqueResult")
    Optional<Bloque> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.735-08:00", comments="Source Table: Bloque")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BloqueResult", value = {
        @Result(column="letra", property="letra", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="numInicial", property="numinicial", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="numFinal", property="numfinal", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER),
        @Result(column="secuencia", property="secuencia", jdbcType=JdbcType.INTEGER),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Bloque> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.736099-08:00", comments="Source Table: Bloque")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.736423-08:00", comments="Source Table: Bloque")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.736747-08:00", comments="Source Table: Bloque")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.737114-08:00", comments="Source Table: Bloque")
    default int deleteByPrimaryKey(String letra_, Integer numinicial_, Integer numfinal_, Integer id_) {
        return delete(c -> 
            c.where(letra, isEqualTo(letra_))
            .and(numinicial, isEqualTo(numinicial_))
            .and(numfinal, isEqualTo(numfinal_))
            .and(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.737521-08:00", comments="Source Table: Bloque")
    default int insert(Bloque record) {
        return MyBatis3Utils.insert(this::insert, record, bloque, c ->
            c.map(letra).toProperty("letra")
            .map(numinicial).toProperty("numinicial")
            .map(numfinal).toProperty("numfinal")
            .map(id).toProperty("id")
            .map(idchofer).toProperty("idchofer")
            .map(secuencia).toProperty("secuencia")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.738536-08:00", comments="Source Table: Bloque")
    default int insertMultiple(Collection<Bloque> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, bloque, c ->
            c.map(letra).toProperty("letra")
            .map(numinicial).toProperty("numinicial")
            .map(numfinal).toProperty("numfinal")
            .map(id).toProperty("id")
            .map(idchofer).toProperty("idchofer")
            .map(secuencia).toProperty("secuencia")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.738978-08:00", comments="Source Table: Bloque")
    default int insertSelective(Bloque record) {
        return MyBatis3Utils.insert(this::insert, record, bloque, c ->
            c.map(letra).toPropertyWhenPresent("letra", record::getLetra)
            .map(numinicial).toPropertyWhenPresent("numinicial", record::getNuminicial)
            .map(numfinal).toPropertyWhenPresent("numfinal", record::getNumfinal)
            .map(id).toPropertyWhenPresent("id", record::getId)
            .map(idchofer).toPropertyWhenPresent("idchofer", record::getIdchofer)
            .map(secuencia).toPropertyWhenPresent("secuencia", record::getSecuencia)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.741541-08:00", comments="Source Table: Bloque")
    default Optional<Bloque> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.741895-08:00", comments="Source Table: Bloque")
    default List<Bloque> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.742249-08:00", comments="Source Table: Bloque")
    default List<Bloque> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.742714-08:00", comments="Source Table: Bloque")
    default Optional<Bloque> selectByPrimaryKey(String letra_, Integer numinicial_, Integer numfinal_, Integer id_) {
        return selectOne(c ->
            c.where(letra, isEqualTo(letra_))
            .and(numinicial, isEqualTo(numinicial_))
            .and(numfinal, isEqualTo(numfinal_))
            .and(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.743058-08:00", comments="Source Table: Bloque")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, bloque, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.74343-08:00", comments="Source Table: Bloque")
    static UpdateDSL<UpdateModel> updateAllColumns(Bloque record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(letra).equalTo(record::getLetra)
                .set(numinicial).equalTo(record::getNuminicial)
                .set(numfinal).equalTo(record::getNumfinal)
                .set(id).equalTo(record::getId)
                .set(idchofer).equalTo(record::getIdchofer)
                .set(secuencia).equalTo(record::getSecuencia)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.743887-08:00", comments="Source Table: Bloque")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Bloque record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(letra).equalToWhenPresent(record::getLetra)
                .set(numinicial).equalToWhenPresent(record::getNuminicial)
                .set(numfinal).equalToWhenPresent(record::getNumfinal)
                .set(id).equalToWhenPresent(record::getId)
                .set(idchofer).equalToWhenPresent(record::getIdchofer)
                .set(secuencia).equalToWhenPresent(record::getSecuencia)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.744627-08:00", comments="Source Table: Bloque")
    default int updateByPrimaryKey(Bloque record) {
        return update(c ->
            c.set(idchofer).equalTo(record::getIdchofer)
            .set(secuencia).equalTo(record::getSecuencia)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(status).equalTo(record::getStatus)
            .where(letra, isEqualTo(record::getLetra))
            .and(numinicial, isEqualTo(record::getNuminicial))
            .and(numfinal, isEqualTo(record::getNumfinal))
            .and(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.745123-08:00", comments="Source Table: Bloque")
    default int updateByPrimaryKeySelective(Bloque record) {
        return update(c ->
            c.set(idchofer).equalToWhenPresent(record::getIdchofer)
            .set(secuencia).equalToWhenPresent(record::getSecuencia)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(letra, isEqualTo(record::getLetra))
            .and(numinicial, isEqualTo(record::getNuminicial))
            .and(numfinal, isEqualTo(record::getNumfinal))
            .and(id, isEqualTo(record::getId))
        );
    }
}