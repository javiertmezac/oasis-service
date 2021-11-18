package com.jtmc.apps.oasis.infrastructure;

import static com.jtmc.apps.oasis.infrastructure.EmpresaDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.oasis.domain.Empresa;
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
public interface EmpresaMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.568564-08:00", comments="Source Table: Empresa")
    BasicColumn[] selectList = BasicColumn.columnList(id, nocliente, nofactura, nombre, rfc, telefono, colonia, calle, noint, noext, cpostal, status, fecharegistro, idprecio, siglavado);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.559047-08:00", comments="Source Table: Empresa")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.55993-08:00", comments="Source Table: Empresa")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.56047-08:00", comments="Source Table: Empresa")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Empresa> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.561075-08:00", comments="Source Table: Empresa")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Empresa> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.561578-08:00", comments="Source Table: Empresa")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmpresaResult")
    Optional<Empresa> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.562314-08:00", comments="Source Table: Empresa")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmpresaResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="noCliente", property="nocliente", jdbcType=JdbcType.VARCHAR),
        @Result(column="noFactura", property="nofactura", jdbcType=JdbcType.NVARCHAR),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfc", property="rfc", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono", property="telefono", jdbcType=JdbcType.VARCHAR),
        @Result(column="colonia", property="colonia", jdbcType=JdbcType.VARCHAR),
        @Result(column="calle", property="calle", jdbcType=JdbcType.VARCHAR),
        @Result(column="noInt", property="noint", jdbcType=JdbcType.INTEGER),
        @Result(column="noExt", property="noext", jdbcType=JdbcType.INTEGER),
        @Result(column="cPostal", property="cpostal", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="fechaRegistro", property="fecharegistro", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idPrecio", property="idprecio", jdbcType=JdbcType.TINYINT),
        @Result(column="sigLavado", property="siglavado", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Empresa> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.563756-08:00", comments="Source Table: Empresa")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.564094-08:00", comments="Source Table: Empresa")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.564416-08:00", comments="Source Table: Empresa")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.564774-08:00", comments="Source Table: Empresa")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.565175-08:00", comments="Source Table: Empresa")
    default int insert(Empresa record) {
        return MyBatis3Utils.insert(this::insert, record, empresa, c ->
            c.map(id).toProperty("id")
            .map(nocliente).toProperty("nocliente")
            .map(nofactura).toProperty("nofactura")
            .map(nombre).toProperty("nombre")
            .map(rfc).toProperty("rfc")
            .map(telefono).toProperty("telefono")
            .map(colonia).toProperty("colonia")
            .map(calle).toProperty("calle")
            .map(noint).toProperty("noint")
            .map(noext).toProperty("noext")
            .map(cpostal).toProperty("cpostal")
            .map(status).toProperty("status")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(idprecio).toProperty("idprecio")
            .map(siglavado).toProperty("siglavado")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.56626-08:00", comments="Source Table: Empresa")
    default int insertMultiple(Collection<Empresa> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, empresa, c ->
            c.map(id).toProperty("id")
            .map(nocliente).toProperty("nocliente")
            .map(nofactura).toProperty("nofactura")
            .map(nombre).toProperty("nombre")
            .map(rfc).toProperty("rfc")
            .map(telefono).toProperty("telefono")
            .map(colonia).toProperty("colonia")
            .map(calle).toProperty("calle")
            .map(noint).toProperty("noint")
            .map(noext).toProperty("noext")
            .map(cpostal).toProperty("cpostal")
            .map(status).toProperty("status")
            .map(fecharegistro).toProperty("fecharegistro")
            .map(idprecio).toProperty("idprecio")
            .map(siglavado).toProperty("siglavado")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.566729-08:00", comments="Source Table: Empresa")
    default int insertSelective(Empresa record) {
        return MyBatis3Utils.insert(this::insert, record, empresa, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(nocliente).toPropertyWhenPresent("nocliente", record::getNocliente)
            .map(nofactura).toPropertyWhenPresent("nofactura", record::getNofactura)
            .map(nombre).toPropertyWhenPresent("nombre", record::getNombre)
            .map(rfc).toPropertyWhenPresent("rfc", record::getRfc)
            .map(telefono).toPropertyWhenPresent("telefono", record::getTelefono)
            .map(colonia).toPropertyWhenPresent("colonia", record::getColonia)
            .map(calle).toPropertyWhenPresent("calle", record::getCalle)
            .map(noint).toPropertyWhenPresent("noint", record::getNoint)
            .map(noext).toPropertyWhenPresent("noext", record::getNoext)
            .map(cpostal).toPropertyWhenPresent("cpostal", record::getCpostal)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(fecharegistro).toPropertyWhenPresent("fecharegistro", record::getFecharegistro)
            .map(idprecio).toPropertyWhenPresent("idprecio", record::getIdprecio)
            .map(siglavado).toPropertyWhenPresent("siglavado", record::getSiglavado)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.569724-08:00", comments="Source Table: Empresa")
    default Optional<Empresa> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.570208-08:00", comments="Source Table: Empresa")
    default List<Empresa> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.5706-08:00", comments="Source Table: Empresa")
    default List<Empresa> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.57098-08:00", comments="Source Table: Empresa")
    default Optional<Empresa> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.571324-08:00", comments="Source Table: Empresa")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, empresa, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.571753-08:00", comments="Source Table: Empresa")
    static UpdateDSL<UpdateModel> updateAllColumns(Empresa record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(nocliente).equalTo(record::getNocliente)
                .set(nofactura).equalTo(record::getNofactura)
                .set(nombre).equalTo(record::getNombre)
                .set(rfc).equalTo(record::getRfc)
                .set(telefono).equalTo(record::getTelefono)
                .set(colonia).equalTo(record::getColonia)
                .set(calle).equalTo(record::getCalle)
                .set(noint).equalTo(record::getNoint)
                .set(noext).equalTo(record::getNoext)
                .set(cpostal).equalTo(record::getCpostal)
                .set(status).equalTo(record::getStatus)
                .set(fecharegistro).equalTo(record::getFecharegistro)
                .set(idprecio).equalTo(record::getIdprecio)
                .set(siglavado).equalTo(record::getSiglavado);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.572229-08:00", comments="Source Table: Empresa")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Empresa record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(nocliente).equalToWhenPresent(record::getNocliente)
                .set(nofactura).equalToWhenPresent(record::getNofactura)
                .set(nombre).equalToWhenPresent(record::getNombre)
                .set(rfc).equalToWhenPresent(record::getRfc)
                .set(telefono).equalToWhenPresent(record::getTelefono)
                .set(colonia).equalToWhenPresent(record::getColonia)
                .set(calle).equalToWhenPresent(record::getCalle)
                .set(noint).equalToWhenPresent(record::getNoint)
                .set(noext).equalToWhenPresent(record::getNoext)
                .set(cpostal).equalToWhenPresent(record::getCpostal)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
                .set(idprecio).equalToWhenPresent(record::getIdprecio)
                .set(siglavado).equalToWhenPresent(record::getSiglavado);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.572959-08:00", comments="Source Table: Empresa")
    default int updateByPrimaryKey(Empresa record) {
        return update(c ->
            c.set(nocliente).equalTo(record::getNocliente)
            .set(nofactura).equalTo(record::getNofactura)
            .set(nombre).equalTo(record::getNombre)
            .set(rfc).equalTo(record::getRfc)
            .set(telefono).equalTo(record::getTelefono)
            .set(colonia).equalTo(record::getColonia)
            .set(calle).equalTo(record::getCalle)
            .set(noint).equalTo(record::getNoint)
            .set(noext).equalTo(record::getNoext)
            .set(cpostal).equalTo(record::getCpostal)
            .set(status).equalTo(record::getStatus)
            .set(fecharegistro).equalTo(record::getFecharegistro)
            .set(idprecio).equalTo(record::getIdprecio)
            .set(siglavado).equalTo(record::getSiglavado)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.573445-08:00", comments="Source Table: Empresa")
    default int updateByPrimaryKeySelective(Empresa record) {
        return update(c ->
            c.set(nocliente).equalToWhenPresent(record::getNocliente)
            .set(nofactura).equalToWhenPresent(record::getNofactura)
            .set(nombre).equalToWhenPresent(record::getNombre)
            .set(rfc).equalToWhenPresent(record::getRfc)
            .set(telefono).equalToWhenPresent(record::getTelefono)
            .set(colonia).equalToWhenPresent(record::getColonia)
            .set(calle).equalToWhenPresent(record::getCalle)
            .set(noint).equalToWhenPresent(record::getNoint)
            .set(noext).equalToWhenPresent(record::getNoext)
            .set(cpostal).equalToWhenPresent(record::getCpostal)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(fecharegistro).equalToWhenPresent(record::getFecharegistro)
            .set(idprecio).equalToWhenPresent(record::getIdprecio)
            .set(siglavado).equalToWhenPresent(record::getSiglavado)
            .where(id, isEqualTo(record::getId))
        );
    }
}