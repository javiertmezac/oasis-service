package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SerieerrorDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.250358-08:00", comments="Source Table: SerieError")
    public static final Serieerror serieerror = new Serieerror();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.250854-08:00", comments="Source field: SerieError.id")
    public static final SqlColumn<Integer> id = serieerror.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.251257-08:00", comments="Source field: SerieError.noNota")
    public static final SqlColumn<String> nonota = serieerror.nonota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.2514-08:00", comments="Source field: SerieError.idChofer")
    public static final SqlColumn<Integer> idchofer = serieerror.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.25151-08:00", comments="Source field: SerieError.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = serieerror.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.251626-08:00", comments="Source field: SerieError.observaciones")
    public static final SqlColumn<String> observaciones = serieerror.observaciones;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.25175-08:00", comments="Source field: SerieError.status")
    public static final SqlColumn<Boolean> status = serieerror.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.250689-08:00", comments="Source Table: SerieError")
    public static final class Serieerror extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nonota = column("noNota", JDBCType.NVARCHAR);

        public final SqlColumn<Integer> idchofer = column("idChofer", JDBCType.INTEGER);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<String> observaciones = column("observaciones", JDBCType.NVARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Serieerror() {
            super("SerieError");
        }
    }
}