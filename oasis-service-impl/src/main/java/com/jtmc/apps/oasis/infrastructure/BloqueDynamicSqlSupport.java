package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BloqueDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.730527-08:00", comments="Source Table: Bloque")
    public static final Bloque bloque = new Bloque();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.730932-08:00", comments="Source field: Bloque.letra")
    public static final SqlColumn<String> letra = bloque.letra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731281-08:00", comments="Source field: Bloque.numInicial")
    public static final SqlColumn<Integer> numinicial = bloque.numinicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731398-08:00", comments="Source field: Bloque.numFinal")
    public static final SqlColumn<Integer> numfinal = bloque.numfinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.7315-08:00", comments="Source field: Bloque.id")
    public static final SqlColumn<Integer> id = bloque.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731608-08:00", comments="Source field: Bloque.idChofer")
    public static final SqlColumn<Integer> idchofer = bloque.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731693-08:00", comments="Source field: Bloque.secuencia")
    public static final SqlColumn<Integer> secuencia = bloque.secuencia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731799-08:00", comments="Source field: Bloque.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = bloque.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.731895-08:00", comments="Source field: Bloque.status")
    public static final SqlColumn<Boolean> status = bloque.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.730775-08:00", comments="Source Table: Bloque")
    public static final class Bloque extends SqlTable {
        public final SqlColumn<String> letra = column("letra", JDBCType.VARCHAR);

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