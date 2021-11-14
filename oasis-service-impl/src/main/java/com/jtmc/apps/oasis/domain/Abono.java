package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Abono {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.753413-07:00", comments="Source field: Abono.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756378-07:00", comments="Source field: Abono.cantidad")
    private Double cantidad;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756608-07:00", comments="Source field: Abono.idNota")
    private Integer idnota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756753-07:00", comments="Source field: Abono.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756936-07:00", comments="Source field: Abono.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.757082-07:00", comments="Source field: Abono.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.755872-07:00", comments="Source field: Abono.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756267-07:00", comments="Source field: Abono.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756441-07:00", comments="Source field: Abono.cantidad")
    public Double getCantidad() {
        return cantidad;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756557-07:00", comments="Source field: Abono.cantidad")
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756658-07:00", comments="Source field: Abono.idNota")
    public Integer getIdnota() {
        return idnota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756708-07:00", comments="Source field: Abono.idNota")
    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756837-07:00", comments="Source field: Abono.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756891-07:00", comments="Source field: Abono.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.756984-07:00", comments="Source field: Abono.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.757037-07:00", comments="Source field: Abono.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.75713-07:00", comments="Source field: Abono.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:57:08.757177-07:00", comments="Source field: Abono.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }
}