package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Bloque {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.926065-08:00", comments="Source field: Bloque.letra")
    private String letra;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930355-08:00", comments="Source field: Bloque.numInicial")
    private Integer numinicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930502-08:00", comments="Source field: Bloque.numFinal")
    private Integer numfinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930642-08:00", comments="Source field: Bloque.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930795-08:00", comments="Source field: Bloque.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931009-08:00", comments="Source field: Bloque.secuencia")
    private Integer secuencia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931152-08:00", comments="Source field: Bloque.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931327-08:00", comments="Source field: Bloque.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.929926-08:00", comments="Source field: Bloque.letra")
    public String getLetra() {
        return letra;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930287-08:00", comments="Source field: Bloque.letra")
    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930407-08:00", comments="Source field: Bloque.numInicial")
    public Integer getNuminicial() {
        return numinicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930458-08:00", comments="Source field: Bloque.numInicial")
    public void setNuminicial(Integer numinicial) {
        this.numinicial = numinicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93055-08:00", comments="Source field: Bloque.numFinal")
    public Integer getNumfinal() {
        return numfinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930599-08:00", comments="Source field: Bloque.numFinal")
    public void setNumfinal(Integer numfinal) {
        this.numfinal = numfinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.9307-08:00", comments="Source field: Bloque.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930751-08:00", comments="Source field: Bloque.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.930842-08:00", comments="Source field: Bloque.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93094-08:00", comments="Source field: Bloque.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93106-08:00", comments="Source field: Bloque.secuencia")
    public Integer getSecuencia() {
        return secuencia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931109-08:00", comments="Source field: Bloque.secuencia")
    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93123-08:00", comments="Source field: Bloque.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931279-08:00", comments="Source field: Bloque.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.93138-08:00", comments="Source field: Bloque.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T19:19:24.931427-08:00", comments="Source field: Bloque.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}