package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.PreciogranelDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Preciogranel;
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
public interface PreciogranelMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.016587-08:00", comments="Source Table: PrecioGranel")
    BasicColumn[] selectList = BasicColumn.columnList(id, precio);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.007136-08:00", comments="Source Table: PrecioGranel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.008452-08:00", comments="Source Table: PrecioGranel")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.008858-08:00", comments="Source Table: PrecioGranel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Preciogranel> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.009448-08:00", comments="Source Table: PrecioGranel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Preciogranel> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.010016-08:00", comments="Source Table: PrecioGranel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PreciogranelResult")
    Optional<Preciogranel> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.010458-08:00", comments="Source Table: PrecioGranel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PreciogranelResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="precio", property="precio", jdbcType=JdbcType.DECIMAL)
    })
    List<Preciogranel> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.012195-08:00", comments="Source Table: PrecioGranel")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.012519-08:00", comments="Source Table: PrecioGranel")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.012828-08:00", comments="Source Table: PrecioGranel")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.013177-08:00", comments="Source Table: PrecioGranel")
    default int deleteByPrimaryKey(Byte id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.01356-08:00", comments="Source Table: PrecioGranel")
    default int insert(Preciogranel record) {
        return MyBatis3Utils.insert(this::insert, record, preciogranel, c ->
            c.map(id).toProperty("id")
            .map(precio).toProperty("precio")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.01456-08:00", comments="Source Table: PrecioGranel")
    default int insertMultiple(Collection<Preciogranel> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, preciogranel, c ->
            c.map(id).toProperty("id")
            .map(precio).toProperty("precio")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.014989-08:00", comments="Source Table: PrecioGranel")
    default int insertSelective(Preciogranel record) {
        return MyBatis3Utils.insert(this::insert, record, preciogranel, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(precio).toPropertyWhenPresent("precio", record::getPrecio)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.017669-08:00", comments="Source Table: PrecioGranel")
    default Optional<Preciogranel> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.018018-08:00", comments="Source Table: PrecioGranel")
    default List<Preciogranel> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.0184-08:00", comments="Source Table: PrecioGranel")
    default List<Preciogranel> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.018783-08:00", comments="Source Table: PrecioGranel")
    default Optional<Preciogranel> selectByPrimaryKey(Byte id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.019127-08:00", comments="Source Table: PrecioGranel")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, preciogranel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.019495-08:00", comments="Source Table: PrecioGranel")
    static UpdateDSL<UpdateModel> updateAllColumns(Preciogranel record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(precio).equalTo(record::getPrecio);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.019999-08:00", comments="Source Table: PrecioGranel")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Preciogranel record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(precio).equalToWhenPresent(record::getPrecio);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.020681-08:00", comments="Source Table: PrecioGranel")
    default int updateByPrimaryKey(Preciogranel record) {
        return update(c ->
            c.set(precio).equalTo(record::getPrecio)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.021215-08:00", comments="Source Table: PrecioGranel")
    default int updateByPrimaryKeySelective(Preciogranel record) {
        return update(c ->
            c.set(precio).equalToWhenPresent(record::getPrecio)
            .where(id, isEqualTo(record::getId))
        );
    }
}