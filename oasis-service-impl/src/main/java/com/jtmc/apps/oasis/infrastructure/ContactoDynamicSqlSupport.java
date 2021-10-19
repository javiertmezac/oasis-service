package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ContactoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.136456-07:00", comments="Source Table: Contacto")
    public static final Contacto contacto = new Contacto();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.137106-07:00", comments="Source field: Contacto.id")
    public static final SqlColumn<Integer> id = contacto.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.137793-07:00", comments="Source field: Contacto.nombre")
    public static final SqlColumn<String> nombre = contacto.nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.137936-07:00", comments="Source field: Contacto.apellidoP")
    public static final SqlColumn<String> apellidop = contacto.apellidop;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.138049-07:00", comments="Source field: Contacto.apellidoM")
    public static final SqlColumn<String> apellidom = contacto.apellidom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.138183-07:00", comments="Source field: Contacto.celular")
    public static final SqlColumn<String> celular = contacto.celular;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.138293-07:00", comments="Source field: Contacto.casa")
    public static final SqlColumn<String> casa = contacto.casa;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.138406-07:00", comments="Source field: Contacto.email")
    public static final SqlColumn<String> email = contacto.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.138596-07:00", comments="Source field: Contacto.status")
    public static final SqlColumn<Boolean> status = contacto.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-17T21:55:53.136831-07:00", comments="Source Table: Contacto")
    public static final class Contacto extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nombre = column("nombre", JDBCType.VARCHAR);

        public final SqlColumn<String> apellidop = column("apellidoP", JDBCType.VARCHAR);

        public final SqlColumn<String> apellidom = column("apellidoM", JDBCType.VARCHAR);

        public final SqlColumn<String> celular = column("celular", JDBCType.VARCHAR);

        public final SqlColumn<String> casa = column("casa", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Contacto() {
            super("Contacto");
        }
    }
}