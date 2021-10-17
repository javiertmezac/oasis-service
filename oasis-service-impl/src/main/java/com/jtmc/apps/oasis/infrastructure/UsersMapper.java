package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.UsersDynamicSqlSupport.*;

import com.jtmc.apps.oasis.domain.Users;
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
public interface UsersMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465959-07:00", comments="Source Table: Users")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, username, password, regdate, expdate, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464397-07:00", comments="Source Table: Users")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464526-07:00", comments="Source Table: Users")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464628-07:00", comments="Source Table: Users")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Users> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464775-07:00", comments="Source Table: Users")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Users> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464945-07:00", comments="Source Table: Users")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UsersResult")
    Optional<Users> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465066-07:00", comments="Source Table: Users")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UsersResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="regDate", property="regdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expDate", property="expdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Users> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465232-07:00", comments="Source Table: Users")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465303-07:00", comments="Source Table: Users")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.46537-07:00", comments="Source Table: Users")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465449-07:00", comments="Source Table: Users")
    default int insert(Users record) {
        return MyBatis3Utils.insert(this::insert, record, users, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(regdate).toProperty("regdate")
            .map(expdate).toProperty("expdate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465562-07:00", comments="Source Table: Users")
    default int insertMultiple(Collection<Users> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, users, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(regdate).toProperty("regdate")
            .map(expdate).toProperty("expdate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.465685-07:00", comments="Source Table: Users")
    default int insertSelective(Users record) {
        return MyBatis3Utils.insert(this::insert, record, users, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(regdate).toPropertyWhenPresent("regdate", record::getRegdate)
            .map(expdate).toPropertyWhenPresent("expdate", record::getExpdate)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466104-07:00", comments="Source Table: Users")
    default Optional<Users> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466211-07:00", comments="Source Table: Users")
    default List<Users> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466334-07:00", comments="Source Table: Users")
    default List<Users> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466412-07:00", comments="Source Table: Users")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, users, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466503-07:00", comments="Source Table: Users")
    static UpdateDSL<UpdateModel> updateAllColumns(Users record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(regdate).equalTo(record::getRegdate)
                .set(expdate).equalTo(record::getExpdate)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.466712-07:00", comments="Source Table: Users")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Users record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(regdate).equalToWhenPresent(record::getRegdate)
                .set(expdate).equalToWhenPresent(record::getExpdate)
                .set(status).equalToWhenPresent(record::getStatus);
    }
}