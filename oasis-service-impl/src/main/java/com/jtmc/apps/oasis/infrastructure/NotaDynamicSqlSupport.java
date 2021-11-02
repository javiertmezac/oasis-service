package com.jtmc.apps.oasis.infrastructure;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class NotaDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.156042-07:00", comments="Source Table: Nota")
    public static final Nota nota = new Nota();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.156559-07:00", comments="Source field: Nota.id")
    public static final SqlColumn<Integer> id = nota.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.156944-07:00", comments="Source field: Nota.noNota")
    public static final SqlColumn<String> nonota = nota.nonota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157044-07:00", comments="Source field: Nota.idPedido")
    public static final SqlColumn<Integer> idpedido = nota.idpedido;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157131-07:00", comments="Source field: Nota.idChofer")
    public static final SqlColumn<Integer> idchofer = nota.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157243-07:00", comments="Source field: Nota.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = nota.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157328-07:00", comments="Source field: Nota.litros")
    public static final SqlColumn<Integer> litros = nota.litros;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157414-07:00", comments="Source field: Nota.creditoContado")
    public static final SqlColumn<Boolean> creditocontado = nota.creditocontado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15751-07:00", comments="Source field: Nota.total")
    public static final SqlColumn<BigDecimal> total = nota.total;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157594-07:00", comments="Source field: Nota.lecturaInicial")
    public static final SqlColumn<Long> lecturainicial = nota.lecturainicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15768-07:00", comments="Source field: Nota.lecturaFinal")
    public static final SqlColumn<Long> lecturafinal = nota.lecturafinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157822-07:00", comments="Source field: Nota.llegada")
    public static final SqlColumn<String> llegada = nota.llegada;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.157973-07:00", comments="Source field: Nota.descarga")
    public static final SqlColumn<String> descarga = nota.descarga;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.158098-07:00", comments="Source field: Nota.salida")
    public static final SqlColumn<String> salida = nota.salida;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.158223-07:00", comments="Source field: Nota.precio")
    public static final SqlColumn<BigDecimal> precio = nota.precio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15834-07:00", comments="Source field: Nota.status")
    public static final SqlColumn<Boolean> status = nota.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.158455-07:00", comments="Source field: Nota.litrosDescontados")
    public static final SqlColumn<Integer> litrosdescontados = nota.litrosdescontados;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.158567-07:00", comments="Source field: Nota.razonDescuento")
    public static final SqlColumn<String> razondescuento = nota.razondescuento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.156364-07:00", comments="Source Table: Nota")
    public static final class Nota extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nonota = column("noNota", JDBCType.VARCHAR);

        public final SqlColumn<Integer> idpedido = column("idPedido", JDBCType.INTEGER);

        public final SqlColumn<Integer> idchofer = column("idChofer", JDBCType.INTEGER);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> litros = column("litros", JDBCType.INTEGER);

        public final SqlColumn<Boolean> creditocontado = column("creditoContado", JDBCType.BIT);

        public final SqlColumn<BigDecimal> total = column("total", JDBCType.DECIMAL);

        public final SqlColumn<Long> lecturainicial = column("lecturaInicial", JDBCType.BIGINT);

        public final SqlColumn<Long> lecturafinal = column("lecturaFinal", JDBCType.BIGINT);

        public final SqlColumn<String> llegada = column("llegada", JDBCType.NCHAR);

        public final SqlColumn<String> descarga = column("descarga", JDBCType.NCHAR);

        public final SqlColumn<String> salida = column("salida", JDBCType.NCHAR);

        public final SqlColumn<BigDecimal> precio = column("precio", JDBCType.DECIMAL);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Integer> litrosdescontados = column("litrosDescontados", JDBCType.INTEGER);

        public final SqlColumn<String> razondescuento = column("razonDescuento", JDBCType.VARCHAR);

        public Nota() {
            super("Nota");
        }
    }
}