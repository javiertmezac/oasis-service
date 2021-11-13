package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BloqueDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.934926-08:00", comments="Source Table: Bloque")
    public static final Bloque bloque = new Bloque();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.935351-08:00", comments="Source field: Bloque.letra")
    public static final SqlColumn<String> letra = bloque.letra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.935712-08:00", comments="Source field: Bloque.numInicial")
    public static final SqlColumn<Integer> numinicial = bloque.numinicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.935819-08:00", comments="Source field: Bloque.numFinal")
    public static final SqlColumn<Integer> numfinal = bloque.numfinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93591-08:00", comments="Source field: Bloque.id")
    public static final SqlColumn<Integer> id = bloque.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.936001-08:00", comments="Source field: Bloque.idChofer")
    public static final SqlColumn<Integer> idchofer = bloque.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.936103-08:00", comments="Source field: Bloque.secuencia")
    public static final SqlColumn<Integer> secuencia = bloque.secuencia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.936236-08:00", comments="Source field: Bloque.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = bloque.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.936368-08:00", comments="Source field: Bloque.status")
    public static final SqlColumn<Boolean> status = bloque.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.935188-08:00", comments="Source Table: Bloque")
    public static final class Bloque extends SqlTable {
        public final SqlColumn<String> letra = column("letra", JDBCType.NCHAR);

        public final SqlColumn<Integer> numinicial = column("numInicial", JDBCType.INTEGER);

        public final SqlColumn<Integer> numfinal = column("numFinal", JDBCType.INTEGER);

        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> idchofer = column("idChofer", JDBCType.INTEGER);

        public final SqlColumn<Integer> secuencia = column("secuencia", JDBCType.INTEGER);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.DATE);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Bloque() {
            super("Bloque");
        }
    }
}