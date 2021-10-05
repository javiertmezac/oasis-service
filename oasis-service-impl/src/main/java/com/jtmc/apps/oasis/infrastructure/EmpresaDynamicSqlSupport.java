package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EmpresaDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.214-07:00", comments="Source Table: Empresa")
    public static final Empresa empresa = new Empresa();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.214-07:00", comments="Source field: Empresa.id")
    public static final SqlColumn<Integer> id = empresa.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.noCliente")
    public static final SqlColumn<String> nocliente = empresa.nocliente;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.noFactura")
    public static final SqlColumn<String> nofactura = empresa.nofactura;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.nombre")
    public static final SqlColumn<String> nombre = empresa.nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.rfc")
    public static final SqlColumn<String> rfc = empresa.rfc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.telefono")
    public static final SqlColumn<String> telefono = empresa.telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.215-07:00", comments="Source field: Empresa.colonia")
    public static final SqlColumn<String> colonia = empresa.colonia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.calle")
    public static final SqlColumn<String> calle = empresa.calle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.noInt")
    public static final SqlColumn<Integer> noint = empresa.noint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.noExt")
    public static final SqlColumn<Integer> noext = empresa.noext;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.cPostal")
    public static final SqlColumn<Integer> cpostal = empresa.cpostal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.status")
    public static final SqlColumn<Boolean> status = empresa.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.216-07:00", comments="Source field: Empresa.fechaRegistro")
    public static final SqlColumn<Date> fecharegistro = empresa.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.217-07:00", comments="Source field: Empresa.idPrecio")
    public static final SqlColumn<Byte> idprecio = empresa.idprecio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.217-07:00", comments="Source field: Empresa.sigLavado")
    public static final SqlColumn<Date> siglavado = empresa.siglavado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-05T01:47:11.214-07:00", comments="Source Table: Empresa")
    public static final class Empresa extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nocliente = column("noCliente", JDBCType.VARCHAR);

        public final SqlColumn<String> nofactura = column("noFactura", JDBCType.NVARCHAR);

        public final SqlColumn<String> nombre = column("nombre", JDBCType.VARCHAR);

        public final SqlColumn<String> rfc = column("rfc", JDBCType.VARCHAR);

        public final SqlColumn<String> telefono = column("telefono", JDBCType.VARCHAR);

        public final SqlColumn<String> colonia = column("colonia", JDBCType.VARCHAR);

        public final SqlColumn<String> calle = column("calle", JDBCType.VARCHAR);

        public final SqlColumn<Integer> noint = column("noInt", JDBCType.INTEGER);

        public final SqlColumn<Integer> noext = column("noExt", JDBCType.INTEGER);

        public final SqlColumn<Integer> cpostal = column("cPostal", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Date> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> idprecio = column("idPrecio", JDBCType.TINYINT);

        public final SqlColumn<Date> siglavado = column("sigLavado", JDBCType.TIMESTAMP);

        public Empresa() {
            super("Empresa");
        }
    }
}