package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TrabajadorDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.718686-07:00", comments="Source Table: Trabajador")
    public static final Trabajador trabajador = new Trabajador();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.719187-07:00", comments="Source field: Trabajador.id")
    public static final SqlColumn<Integer> id = trabajador.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.71973-07:00", comments="Source field: Trabajador.codigo")
    public static final SqlColumn<String> codigo = trabajador.codigo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.71993-07:00", comments="Source field: Trabajador.nombre")
    public static final SqlColumn<String> nombre = trabajador.nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.720085-07:00", comments="Source field: Trabajador.telefono")
    public static final SqlColumn<String> telefono = trabajador.telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.720233-07:00", comments="Source field: Trabajador.direccion")
    public static final SqlColumn<String> direccion = trabajador.direccion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.720357-07:00", comments="Source field: Trabajador.fechaRegistro")
    public static final SqlColumn<Date> fecharegistro = trabajador.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.720496-07:00", comments="Source field: Trabajador.status")
    public static final SqlColumn<Boolean> status = trabajador.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.719001-07:00", comments="Source Table: Trabajador")
    public static final class Trabajador extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> codigo = column("codigo", JDBCType.NVARCHAR);

        public final SqlColumn<String> nombre = column("nombre", JDBCType.NVARCHAR);

        public final SqlColumn<String> telefono = column("telefono", JDBCType.NVARCHAR);

        public final SqlColumn<String> direccion = column("direccion", JDBCType.NVARCHAR);

        public final SqlColumn<Date> fecharegistro = column("fechaRegistro", JDBCType.DATE);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Trabajador() {
            super("Trabajador");
        }
    }
}