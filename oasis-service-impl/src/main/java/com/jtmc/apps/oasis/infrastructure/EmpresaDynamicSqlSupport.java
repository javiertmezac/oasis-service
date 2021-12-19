package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EmpresaDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.068323-08:00", comments="Source Table: Empresa")
    public static final Empresa empresa = new Empresa();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.068711-08:00", comments="Source field: Empresa.id")
    public static final SqlColumn<Integer> id = empresa.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06917-08:00", comments="Source field: Empresa.noCliente")
    public static final SqlColumn<String> nocliente = empresa.nocliente;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.069306-08:00", comments="Source field: Empresa.noFactura")
    public static final SqlColumn<String> nofactura = empresa.nofactura;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.069398-08:00", comments="Source field: Empresa.nombre")
    public static final SqlColumn<String> nombre = empresa.nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.069504-08:00", comments="Source field: Empresa.rfc")
    public static final SqlColumn<String> rfc = empresa.rfc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.069627-08:00", comments="Source field: Empresa.telefono")
    public static final SqlColumn<String> telefono = empresa.telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.069718-08:00", comments="Source field: Empresa.colonia")
    public static final SqlColumn<String> colonia = empresa.colonia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06982-08:00", comments="Source field: Empresa.calle")
    public static final SqlColumn<String> calle = empresa.calle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06992-08:00", comments="Source field: Empresa.noInt")
    public static final SqlColumn<String> noint = empresa.noint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070003-08:00", comments="Source field: Empresa.noExt")
    public static final SqlColumn<String> noext = empresa.noext;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070084-08:00", comments="Source field: Empresa.cPostal")
    public static final SqlColumn<String> cpostal = empresa.cpostal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070173-08:00", comments="Source field: Empresa.status")
    public static final SqlColumn<Boolean> status = empresa.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070295-08:00", comments="Source field: Empresa.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = empresa.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070431-08:00", comments="Source field: Empresa.idPrecio")
    public static final SqlColumn<Byte> idprecio = empresa.idprecio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070587-08:00", comments="Source field: Empresa.sigLavado")
    public static final SqlColumn<Instant> siglavado = empresa.siglavado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.070708-08:00", comments="Source field: Empresa.nextCleaningComments")
    public static final SqlColumn<String> nextcleaningcomments = empresa.nextcleaningcomments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.068557-08:00", comments="Source Table: Empresa")
    public static final class Empresa extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nocliente = column("noCliente", JDBCType.VARCHAR);

        public final SqlColumn<String> nofactura = column("noFactura", JDBCType.NVARCHAR);

        public final SqlColumn<String> nombre = column("nombre", JDBCType.VARCHAR);

        public final SqlColumn<String> rfc = column("rfc", JDBCType.VARCHAR);

        public final SqlColumn<String> telefono = column("telefono", JDBCType.VARCHAR);

        public final SqlColumn<String> colonia = column("colonia", JDBCType.VARCHAR);

        public final SqlColumn<String> calle = column("calle", JDBCType.VARCHAR);

        public final SqlColumn<String> noint = column("noInt", JDBCType.VARCHAR);

        public final SqlColumn<String> noext = column("noExt", JDBCType.VARCHAR);

        public final SqlColumn<String> cpostal = column("cPostal", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> idprecio = column("idPrecio", JDBCType.TINYINT);

        public final SqlColumn<Instant> siglavado = column("sigLavado", JDBCType.DATE);

        public final SqlColumn<String> nextcleaningcomments = column("nextCleaningComments", JDBCType.VARCHAR);

        public Empresa() {
            super("Empresa");
        }
    }
}