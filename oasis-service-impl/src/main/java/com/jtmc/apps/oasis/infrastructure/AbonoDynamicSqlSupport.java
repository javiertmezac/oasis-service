package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AbonoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.760419-07:00", comments="Source Table: Abono")
    public static final Abono abono = new Abono();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.760838-07:00", comments="Source field: Abono.id")
    public static final SqlColumn<Integer> id = abono.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.761191-07:00", comments="Source field: Abono.cantidad")
    public static final SqlColumn<Double> cantidad = abono.cantidad;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.761317-07:00", comments="Source field: Abono.idNota")
    public static final SqlColumn<Integer> idnota = abono.idnota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.761416-07:00", comments="Source field: Abono.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = abono.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.761504-07:00", comments="Source field: Abono.status")
    public static final SqlColumn<Boolean> status = abono.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.76159-07:00", comments="Source field: Abono.idChofer")
    public static final SqlColumn<Integer> idchofer = abono.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.760693-07:00", comments="Source Table: Abono")
    public static final class Abono extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Double> cantidad = column("cantidad", JDBCType.DECIMAL);

        public final SqlColumn<Integer> idnota = column("idNota", JDBCType.INTEGER);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Integer> idchofer = column("idChofer", JDBCType.INTEGER);

        public Abono() {
            super("Abono");
        }
    }
}