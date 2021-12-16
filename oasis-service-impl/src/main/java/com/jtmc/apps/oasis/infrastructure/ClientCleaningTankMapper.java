package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.ClientCleaningTankDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.ClientCleaningTank;
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
public interface ClientCleaningTankMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.58205-08:00", comments="Source Table: ClientCleaningTankRecord")
    BasicColumn[] selectList = BasicColumn.columnList(id, clientid, tankcleaningdate, comments, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.572065-08:00", comments="Source Table: ClientCleaningTankRecord")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.573479-08:00", comments="Source Table: ClientCleaningTankRecord")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.573877-08:00", comments="Source Table: ClientCleaningTankRecord")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ClientCleaningTank> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.574453-08:00", comments="Source Table: ClientCleaningTankRecord")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ClientCleaningTank> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.574872-08:00", comments="Source Table: ClientCleaningTankRecord")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClientCleaningTankResult")
    Optional<ClientCleaningTank> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.575278-08:00", comments="Source Table: ClientCleaningTankRecord")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClientCleaningTankResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clientId", property="clientid", jdbcType=JdbcType.INTEGER),
        @Result(column="tankCleaningDate", property="tankcleaningdate", jdbcType=JdbcType.DATE),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<ClientCleaningTank> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.576931-08:00", comments="Source Table: ClientCleaningTankRecord")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.577253-08:00", comments="Source Table: ClientCleaningTankRecord")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.577593-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.577948-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.578451-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int insert(ClientCleaningTank record) {
        return MyBatis3Utils.insert(this::insert, record, clientCleaningTank, c ->
            c.map(id).toProperty("id")
            .map(clientid).toProperty("clientid")
            .map(tankcleaningdate).toProperty("tankcleaningdate")
            .map(comments).toProperty("comments")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.579935-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int insertMultiple(Collection<ClientCleaningTank> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, clientCleaningTank, c ->
            c.map(id).toProperty("id")
            .map(clientid).toProperty("clientid")
            .map(tankcleaningdate).toProperty("tankcleaningdate")
            .map(comments).toProperty("comments")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.580387-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int insertSelective(ClientCleaningTank record) {
        return MyBatis3Utils.insert(this::insert, record, clientCleaningTank, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(clientid).toPropertyWhenPresent("clientid", record::getClientid)
            .map(tankcleaningdate).toPropertyWhenPresent("tankcleaningdate", record::getTankcleaningdate)
            .map(comments).toPropertyWhenPresent("comments", record::getComments)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.583007-08:00", comments="Source Table: ClientCleaningTankRecord")
    default Optional<ClientCleaningTank> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.583497-08:00", comments="Source Table: ClientCleaningTankRecord")
    default List<ClientCleaningTank> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.583964-08:00", comments="Source Table: ClientCleaningTankRecord")
    default List<ClientCleaningTank> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.584377-08:00", comments="Source Table: ClientCleaningTankRecord")
    default Optional<ClientCleaningTank> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.584693-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.585029-08:00", comments="Source Table: ClientCleaningTankRecord")
    static UpdateDSL<UpdateModel> updateAllColumns(ClientCleaningTank record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(clientid).equalTo(record::getClientid)
                .set(tankcleaningdate).equalTo(record::getTankcleaningdate)
                .set(comments).equalTo(record::getComments)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.585495-08:00", comments="Source Table: ClientCleaningTankRecord")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ClientCleaningTank record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(clientid).equalToWhenPresent(record::getClientid)
                .set(tankcleaningdate).equalToWhenPresent(record::getTankcleaningdate)
                .set(comments).equalToWhenPresent(record::getComments)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.586214-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int updateByPrimaryKey(ClientCleaningTank record) {
        return update(c ->
            c.set(clientid).equalTo(record::getClientid)
            .set(tankcleaningdate).equalTo(record::getTankcleaningdate)
            .set(comments).equalTo(record::getComments)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.586728-08:00", comments="Source Table: ClientCleaningTankRecord")
    default int updateByPrimaryKeySelective(ClientCleaningTank record) {
        return update(c ->
            c.set(clientid).equalToWhenPresent(record::getClientid)
            .set(tankcleaningdate).equalToWhenPresent(record::getTankcleaningdate)
            .set(comments).equalToWhenPresent(record::getComments)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}