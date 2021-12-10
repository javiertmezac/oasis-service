package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Bloque {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.723455-08:00", comments="Source field: Bloque.letra")
    private String letra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726635-08:00", comments="Source field: Bloque.numInicial")
    private Integer numinicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726794-08:00", comments="Source field: Bloque.numFinal")
    private Integer numfinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726956-08:00", comments="Source field: Bloque.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727105-08:00", comments="Source field: Bloque.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727258-08:00", comments="Source field: Bloque.secuencia")
    private Integer secuencia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727399-08:00", comments="Source field: Bloque.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727572-08:00", comments="Source field: Bloque.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726198-08:00", comments="Source field: Bloque.letra")
    public String getLetra() {
        return letra;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726564-08:00", comments="Source field: Bloque.letra")
    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726692-08:00", comments="Source field: Bloque.numInicial")
    public Integer getNuminicial() {
        return numinicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726746-08:00", comments="Source field: Bloque.numInicial")
    public void setNuminicial(Integer numinicial) {
        this.numinicial = numinicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726844-08:00", comments="Source field: Bloque.numFinal")
    public Integer getNumfinal() {
        return numfinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.726895-08:00", comments="Source field: Bloque.numFinal")
    public void setNumfinal(Integer numfinal) {
        this.numfinal = numfinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727006-08:00", comments="Source field: Bloque.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727059-08:00", comments="Source field: Bloque.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727154-08:00", comments="Source field: Bloque.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727211-08:00", comments="Source field: Bloque.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727307-08:00", comments="Source field: Bloque.secuencia")
    public Integer getSecuencia() {
        return secuencia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727355-08:00", comments="Source field: Bloque.secuencia")
    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727478-08:00", comments="Source field: Bloque.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727528-08:00", comments="Source field: Bloque.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727635-08:00", comments="Source field: Bloque.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-09T22:22:40.727684-08:00", comments="Source field: Bloque.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}