package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Serieerror {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.23953-08:00", comments="Source field: SerieError.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245089-08:00", comments="Source field: SerieError.noNota")
    private String nonota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245426-08:00", comments="Source field: SerieError.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245671-08:00", comments="Source field: SerieError.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245981-08:00", comments="Source field: SerieError.observaciones")
    private String observaciones;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.246481-08:00", comments="Source field: SerieError.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.244449-08:00", comments="Source field: SerieError.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245009-08:00", comments="Source field: SerieError.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245179-08:00", comments="Source field: SerieError.noNota")
    public String getNonota() {
        return nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245328-08:00", comments="Source field: SerieError.noNota")
    public void setNonota(String nonota) {
        this.nonota = nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245514-08:00", comments="Source field: SerieError.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245598-08:00", comments="Source field: SerieError.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245811-08:00", comments="Source field: SerieError.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.245896-08:00", comments="Source field: SerieError.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.246187-08:00", comments="Source field: SerieError.observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.246336-08:00", comments="Source field: SerieError.observaciones")
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.246543-08:00", comments="Source field: SerieError.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-18T01:02:59.246641-08:00", comments="Source field: SerieError.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}