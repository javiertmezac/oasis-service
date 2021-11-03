package com.jtmc.apps.oasis.domain;

import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Generated;

public class Nota {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.152512-07:00", comments="Source field: Nota.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156757-07:00", comments="Source field: Nota.noNota")
    private String nonota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156936-07:00", comments="Source field: Nota.idPedido")
    private Integer idpedido;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157078-07:00", comments="Source field: Nota.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157252-07:00", comments="Source field: Nota.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15744-07:00", comments="Source field: Nota.litros")
    private Integer litros;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157612-07:00", comments="Source field: Nota.creditoContado")
    private Boolean creditocontado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157761-07:00", comments="Source field: Nota.total")
    private Double total;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15791-07:00", comments="Source field: Nota.lecturaInicial")
    private Long lecturainicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158056-07:00", comments="Source field: Nota.lecturaFinal")
    private Long lecturafinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158187-07:00", comments="Source field: Nota.llegada")
    private String llegada;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158337-07:00", comments="Source field: Nota.descarga")
    private String descarga;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158475-07:00", comments="Source field: Nota.salida")
    private String salida;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158647-07:00", comments="Source field: Nota.precio")
    private BigDecimal precio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158805-07:00", comments="Source field: Nota.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158953-07:00", comments="Source field: Nota.litrosDescontados")
    private Integer litrosdescontados;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.159105-07:00", comments="Source field: Nota.razonDescuento")
    private String razondescuento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156373-07:00", comments="Source field: Nota.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156688-07:00", comments="Source field: Nota.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15681-07:00", comments="Source field: Nota.noNota")
    public String getNonota() {
        return nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156888-07:00", comments="Source field: Nota.noNota")
    public void setNonota(String nonota) {
        this.nonota = nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.156984-07:00", comments="Source field: Nota.idPedido")
    public Integer getIdpedido() {
        return idpedido;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157033-07:00", comments="Source field: Nota.idPedido")
    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157139-07:00", comments="Source field: Nota.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157197-07:00", comments="Source field: Nota.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157327-07:00", comments="Source field: Nota.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157383-07:00", comments="Source field: Nota.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157495-07:00", comments="Source field: Nota.litros")
    public Integer getLitros() {
        return litros;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157556-07:00", comments="Source field: Nota.litros")
    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157671-07:00", comments="Source field: Nota.creditoContado")
    public Boolean getCreditocontado() {
        return creditocontado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157718-07:00", comments="Source field: Nota.creditoContado")
    public void setCreditocontado(Boolean creditocontado) {
        this.creditocontado = creditocontado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15782-07:00", comments="Source field: Nota.total")
    public Double getTotal() {
        return total;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.157867-07:00", comments="Source field: Nota.total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15796-07:00", comments="Source field: Nota.lecturaInicial")
    public Long getLecturainicial() {
        return lecturainicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158013-07:00", comments="Source field: Nota.lecturaInicial")
    public void setLecturainicial(Long lecturainicial) {
        this.lecturainicial = lecturainicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.1581-07:00", comments="Source field: Nota.lecturaFinal")
    public Long getLecturafinal() {
        return lecturafinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158146-07:00", comments="Source field: Nota.lecturaFinal")
    public void setLecturafinal(Long lecturafinal) {
        this.lecturafinal = lecturafinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158233-07:00", comments="Source field: Nota.llegada")
    public String getLlegada() {
        return llegada;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15829-07:00", comments="Source field: Nota.llegada")
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158385-07:00", comments="Source field: Nota.descarga")
    public String getDescarga() {
        return descarga;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158433-07:00", comments="Source field: Nota.descarga")
    public void setDescarga(String descarga) {
        this.descarga = descarga;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158555-07:00", comments="Source field: Nota.salida")
    public String getSalida() {
        return salida;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158604-07:00", comments="Source field: Nota.salida")
    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158698-07:00", comments="Source field: Nota.precio")
    public BigDecimal getPrecio() {
        return precio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.15876-07:00", comments="Source field: Nota.precio")
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158866-07:00", comments="Source field: Nota.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.158912-07:00", comments="Source field: Nota.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.159009-07:00", comments="Source field: Nota.litrosDescontados")
    public Integer getLitrosdescontados() {
        return litrosdescontados;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.159065-07:00", comments="Source field: Nota.litrosDescontados")
    public void setLitrosdescontados(Integer litrosdescontados) {
        this.litrosdescontados = litrosdescontados;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.159149-07:00", comments="Source field: Nota.razonDescuento")
    public String getRazondescuento() {
        return razondescuento;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T16:56:20.159193-07:00", comments="Source field: Nota.razonDescuento")
    public void setRazondescuento(String razondescuento) {
        this.razondescuento = razondescuento;
    }
}