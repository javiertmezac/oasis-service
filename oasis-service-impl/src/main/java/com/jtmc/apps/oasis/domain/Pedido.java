package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Pedido {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.631405-07:00", comments="Source field: Pedido.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.636733-07:00", comments="Source field: Pedido.idEmpresa")
    private Integer idempresa;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.636956-07:00", comments="Source field: Pedido.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637158-07:00", comments="Source field: Pedido.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.63741-07:00", comments="Source field: Pedido.fechaEntregar")
    private Instant fechaentregar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637621-07:00", comments="Source field: Pedido.observaciones")
    private String observaciones;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637851-07:00", comments="Source field: Pedido.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638068-07:00", comments="Source field: Pedido.idNotificacion")
    private Integer idnotificacion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638274-07:00", comments="Source field: Pedido.idPrioridad")
    private Integer idprioridad;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.63605-07:00", comments="Source field: Pedido.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.636633-07:00", comments="Source field: Pedido.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.636813-07:00", comments="Source field: Pedido.idEmpresa")
    public Integer getIdempresa() {
        return idempresa;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.636889-07:00", comments="Source field: Pedido.idEmpresa")
    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637024-07:00", comments="Source field: Pedido.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637094-07:00", comments="Source field: Pedido.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637271-07:00", comments="Source field: Pedido.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637346-07:00", comments="Source field: Pedido.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637481-07:00", comments="Source field: Pedido.fechaEntregar")
    public Instant getFechaentregar() {
        return fechaentregar;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637551-07:00", comments="Source field: Pedido.fechaEntregar")
    public void setFechaentregar(Instant fechaentregar) {
        this.fechaentregar = fechaentregar;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637689-07:00", comments="Source field: Pedido.observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637788-07:00", comments="Source field: Pedido.observaciones")
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.637929-07:00", comments="Source field: Pedido.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638006-07:00", comments="Source field: Pedido.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638149-07:00", comments="Source field: Pedido.idNotificacion")
    public Integer getIdnotificacion() {
        return idnotificacion;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638215-07:00", comments="Source field: Pedido.idNotificacion")
    public void setIdnotificacion(Integer idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638337-07:00", comments="Source field: Pedido.idPrioridad")
    public Integer getIdprioridad() {
        return idprioridad;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T02:35:37.638404-07:00", comments="Source field: Pedido.idPrioridad")
    public void setIdprioridad(Integer idprioridad) {
        this.idprioridad = idprioridad;
    }
}