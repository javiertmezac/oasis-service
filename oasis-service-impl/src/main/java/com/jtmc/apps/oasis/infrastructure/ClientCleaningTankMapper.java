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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.101474-08:00", comments="Source Table: ClientCleaningTank")
    BasicColumn[] selectList = BasicColumn.columnList(id, clientid, tankcleaningdate, comments, registrationdate, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.091781-08:00", comments="Source Table: ClientCleaningTank")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.093101-08:00", comments="Source Table: ClientCleaningTank")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.093493-08:00", comments="Source Table: ClientCleaningTank")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ClientCleaningTank> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.0941-08:00", comments="Source Table: ClientCleaningTank")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ClientCleaningTank> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.094542-08:00", comments="Source Table: ClientCleaningTank")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClientCleaningTankResult")
    Optional<ClientCleaningTank> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.094944-08:00", comments="Source Table: ClientCleaningTank")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClientCleaningTankResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clientId", property="clientid", jdbcType=JdbcType.INTEGER),
        @Result(column="tankCleaningDate", property="tankcleaningdate", jdbcType=JdbcType.DATE),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="registrationDate", property="registrationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<ClientCleaningTank> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.096566-08:00", comments="Source Table: ClientCleaningTank")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.09692-08:00", comments="Source Table: ClientCleaningTank")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.097245-08:00", comments="Source Table: ClientCleaningTank")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.097693-08:00", comments="Source Table: ClientCleaningTank")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.098095-08:00", comments="Source Table: ClientCleaningTank")
    default int insert(ClientCleaningTank record) {
        return MyBatis3Utils.insert(this::insert, record, clientCleaningTank, c ->
            c.map(id).toProperty("id")
            .map(clientid).toProperty("clientid")
            .map(tankcleaningdate).toProperty("tankcleaningdate")
            .map(comments).toProperty("comments")
            .map(registrationdate).toProperty("registrationdate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.099286-08:00", comments="Source Table: ClientCleaningTank")
    default int insertMultiple(Collection<ClientCleaningTank> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, clientCleaningTank, c ->
            c.map(id).toProperty("id")
            .map(clientid).toProperty("clientid")
            .map(tankcleaningdate).toProperty("tankcleaningdate")
            .map(comments).toProperty("comments")
            .map(registrationdate).toProperty("registrationdate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.099765-08:00", comments="Source Table: ClientCleaningTank")
    default int insertSelective(ClientCleaningTank record) {
        return MyBatis3Utils.insert(this::insert, record, clientCleaningTank, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(clientid).toPropertyWhenPresent("clientid", record::getClientid)
            .map(tankcleaningdate).toPropertyWhenPresent("tankcleaningdate", record::getTankcleaningdate)
            .map(comments).toPropertyWhenPresent("comments", record::getComments)
            .map(registrationdate).toPropertyWhenPresent("registrationdate", record::getRegistrationdate)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.102544-08:00", comments="Source Table: ClientCleaningTank")
    default Optional<ClientCleaningTank> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.10295-08:00", comments="Source Table: ClientCleaningTank")
    default List<ClientCleaningTank> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.103341-08:00", comments="Source Table: ClientCleaningTank")
    default List<ClientCleaningTank> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.10372-08:00", comments="Source Table: ClientCleaningTank")
    default Optional<ClientCleaningTank> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.104036-08:00", comments="Source Table: ClientCleaningTank")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, clientCleaningTank, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.10442-08:00", comments="Source Table: ClientCleaningTank")
    static UpdateDSL<UpdateModel> updateAllColumns(ClientCleaningTank record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(clientid).equalTo(record::getClientid)
                .set(tankcleaningdate).equalTo(record::getTankcleaningdate)
                .set(comments).equalTo(record::getComments)
                .set(registrationdate).equalTo(record::getRegistrationdate)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.104857-08:00", comments="Source Table: ClientCleaningTank")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ClientCleaningTank record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(clientid).equalToWhenPresent(record::getClientid)
                .set(tankcleaningdate).equalToWhenPresent(record::getTankcleaningdate)
                .set(comments).equalToWhenPresent(record::getComments)
                .set(registrationdate).equalToWhenPresent(record::getRegistrationdate)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.105539-08:00", comments="Source Table: ClientCleaningTank")
    default int updateByPrimaryKey(ClientCleaningTank record) {
        return update(c ->
            c.set(clientid).equalTo(record::getClientid)
            .set(tankcleaningdate).equalTo(record::getTankcleaningdate)
            .set(comments).equalTo(record::getComments)
            .set(registrationdate).equalTo(record::getRegistrationdate)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.106031-08:00", comments="Source Table: ClientCleaningTank")
    default int updateByPrimaryKeySelective(ClientCleaningTank record) {
        return update(c ->
            c.set(clientid).equalToWhenPresent(record::getClientid)
            .set(tankcleaningdate).equalToWhenPresent(record::getTankcleaningdate)
            .set(comments).equalToWhenPresent(record::getComments)
            .set(registrationdate).equalToWhenPresent(record::getRegistrationdate)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}