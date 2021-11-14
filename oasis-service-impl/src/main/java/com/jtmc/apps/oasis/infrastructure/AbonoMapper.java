package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.AbonoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Abono;
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
public interface AbonoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.772594-07:00", comments="Source Table: Abono")
    BasicColumn[] selectList = BasicColumn.columnList(id, cantidad, idnota, fecharegistro, status, idchofer);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.762186-07:00", comments="Source Table: Abono")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.763298-07:00", comments="Source Table: Abono")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.763676-07:00", comments="Source Table: Abono")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Abono> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.764296-07:00", comments="Source Table: Abono")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Abono> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.764774-07:00", comments="Source Table: Abono")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AbonoResult")
    Optional<Abono> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.765396-07:00", comments="Source Table: Abono")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AbonoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.DECIMAL),
        @Result(column="idNota", property="idnota", jdbcType=JdbcType.INTEGER),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="idChofer", property="idchofer", jdbcType=JdbcType.INTEGER)
    })
    List<Abono> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.767109-07:00", comments="Source Table: Abono")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.767555-07:00", comments="Source Table: Abono")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.768003-07:00", comments="Source Table: Abono")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.76842-07:00", comments="Source Table: Abono")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.768903-07:00", comments="Source Table: Abono")
    default int insert(Abono record) {
        return MyBatis3Utils.insert(this::insert, record, abono, c ->
            c.map(id).toProperty("id")
            .map(cantidad).toProperty("cantidad")
            .map(idnota).toProperty("idnota")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
            .map(idchofer).toProperty("idchofer")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.770076-07:00", comments="Source Table: Abono")
    default int insertMultiple(Collection<Abono> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, abono, c ->
            c.map(id).toProperty("id")
            .map(cantidad).toProperty("cantidad")
            .map(idnota).toProperty("idnota")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(status).toProperty("status")
            .map(idchofer).toProperty("idchofer")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.770619-07:00", comments="Source Table: Abono")
    default int insertSelective(Abono record) {
        return MyBatis3Utils.insert(this::insert, record, abono, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(cantidad).toPropertyWhenPresent("cantidad", record::getCantidad)
            .map(idnota).toPropertyWhenPresent("idnota", record::getIdnota)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(idchofer).toPropertyWhenPresent("idchofer", record::getIdchofer)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.773614-07:00", comments="Source Table: Abono")
    default Optional<Abono> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.773993-07:00", comments="Source Table: Abono")
    default List<Abono> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.774359-07:00", comments="Source Table: Abono")
    default List<Abono> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.774762-07:00", comments="Source Table: Abono")
    default Optional<Abono> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.775096-07:00", comments="Source Table: Abono")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, abono, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.775477-07:00", comments="Source Table: Abono")
    static UpdateDSL<UpdateModel> updateAllColumns(Abono record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(cantidad).equalTo(record::getCantidad)
                .set(idnota).equalTo(record::getIdnota)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(status).equalTo(record::getStatus)
                .set(idchofer).equalTo(record::getIdchofer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.775998-07:00", comments="Source Table: Abono")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Abono record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(cantidad).equalToWhenPresent(record::getCantidad)
                .set(idnota).equalToWhenPresent(record::getIdnota)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(idchofer).equalToWhenPresent(record::getIdchofer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.776707-07:00", comments="Source Table: Abono")
    default int updateByPrimaryKey(Abono record) {
        return update(c ->
            c.set(cantidad).equalTo(record::getCantidad)
            .set(idnota).equalTo(record::getIdnota)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(status).equalTo(record::getStatus)
            .set(idchofer).equalTo(record::getIdchofer)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.77717-07:00", comments="Source Table: Abono")
    default int updateByPrimaryKeySelective(Abono record) {
        return update(c ->
            c.set(cantidad).equalToWhenPresent(record::getCantidad)
            .set(idnota).equalToWhenPresent(record::getIdnota)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(idchofer).equalToWhenPresent(record::getIdchofer)
            .where(id, isEqualTo(record::getId))
        );
    }
}