package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PedidoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.64215-07:00", comments="Source Table: Pedido")
    public static final Pedido pedido = new Pedido();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.64264-07:00", comments="Source field: Pedido.id")
    public static final SqlColumn<Integer> id = pedido.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.643255-07:00", comments="Source field: Pedido.idEmpresa")
    public static final SqlColumn<Integer> idempresa = pedido.idempresa;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.643417-07:00", comments="Source field: Pedido.idChofer")
    public static final SqlColumn<Integer> idchofer = pedido.idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.643588-07:00", comments="Source field: Pedido.fechaRegistro")
    public static final SqlColumn<Instant> fecharegistro = pedido.fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.64372-07:00", comments="Source field: Pedido.fechaEntregar")
    public static final SqlColumn<Instant> fechaentregar = pedido.fechaentregar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.643891-07:00", comments="Source field: Pedido.observaciones")
    public static final SqlColumn<String> observaciones = pedido.observaciones;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.64403-07:00", comments="Source field: Pedido.status")
    public static final SqlColumn<Boolean> status = pedido.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.644167-07:00", comments="Source field: Pedido.idNotificacion")
    public static final SqlColumn<Integer> idnotificacion = pedido.idnotificacion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.644321-07:00", comments="Source field: Pedido.idPrioridad")
    public static final SqlColumn<Integer> idprioridad = pedido.idprioridad;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.642428-07:00", comments="Source Table: Pedido")
    public static final class Pedido extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> idempresa = column("idEmpresa", JDBCType.INTEGER);

        public final SqlColumn<Integer> idchofer = column("idChofer", JDBCType.INTEGER);

        public final SqlColumn<Instant> fecharegistro = column("fechaRegistro", JDBCType.TIMESTAMP);

        public final SqlColumn<Instant> fechaentregar = column("fechaEntregar", JDBCType.TIMESTAMP);

        public final SqlColumn<String> observaciones = column("observaciones", JDBCType.NVARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Integer> idnotificacion = column("idNotificacion", JDBCType.INTEGER);

        public final SqlColumn<Integer> idprioridad = column("idPrioridad", JDBCType.INTEGER);

        public Pedido() {
            super("Pedido");
        }
    }
}