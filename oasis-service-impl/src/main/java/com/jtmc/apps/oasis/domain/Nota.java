package com.jtmc.apps.oasis.domain;

import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Generated;

public class Nota {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.146927-07:00", comments="Source field: Nota.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150322-07:00", comments="Source field: Nota.noNota")
    private String nonota;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150504-07:00", comments="Source field: Nota.idPedido")
    private Integer idpedido;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150688-07:00", comments="Source field: Nota.idChofer")
    private Integer idchofer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150908-07:00", comments="Source field: Nota.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151112-07:00", comments="Source field: Nota.litros")
    private Integer litros;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151248-07:00", comments="Source field: Nota.creditoContado")
    private Boolean creditocontado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151438-07:00", comments="Source field: Nota.total")
    private BigDecimal total;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151645-07:00", comments="Source field: Nota.lecturaInicial")
    private Long lecturainicial;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151805-07:00", comments="Source field: Nota.lecturaFinal")
    private Long lecturafinal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151946-07:00", comments="Source field: Nota.llegada")
    private String llegada;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15214-07:00", comments="Source field: Nota.descarga")
    private String descarga;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152371-07:00", comments="Source field: Nota.salida")
    private String salida;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152582-07:00", comments="Source field: Nota.precio")
    private BigDecimal precio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15282-07:00", comments="Source field: Nota.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.153029-07:00", comments="Source field: Nota.litrosDescontados")
    private Integer litrosdescontados;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.153192-07:00", comments="Source field: Nota.razonDescuento")
    private String razondescuento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.14992-07:00", comments="Source field: Nota.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150255-07:00", comments="Source field: Nota.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150378-07:00", comments="Source field: Nota.noNota")
    public String getNonota() {
        return nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150455-07:00", comments="Source field: Nota.noNota")
    public void setNonota(String nonota) {
        this.nonota = nonota;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150574-07:00", comments="Source field: Nota.idPedido")
    public Integer getIdpedido() {
        return idpedido;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150641-07:00", comments="Source field: Nota.idPedido")
    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150762-07:00", comments="Source field: Nota.idChofer")
    public Integer getIdchofer() {
        return idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.150842-07:00", comments="Source field: Nota.idChofer")
    public void setIdchofer(Integer idchofer) {
        this.idchofer = idchofer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15101-07:00", comments="Source field: Nota.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151066-07:00", comments="Source field: Nota.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15116-07:00", comments="Source field: Nota.litros")
    public Integer getLitros() {
        return litros;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151206-07:00", comments="Source field: Nota.litros")
    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151321-07:00", comments="Source field: Nota.creditoContado")
    public Boolean getCreditocontado() {
        return creditocontado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151388-07:00", comments="Source field: Nota.creditoContado")
    public void setCreditocontado(Boolean creditocontado) {
        this.creditocontado = creditocontado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151525-07:00", comments="Source field: Nota.total")
    public BigDecimal getTotal() {
        return total;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15159-07:00", comments="Source field: Nota.total")
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151695-07:00", comments="Source field: Nota.lecturaInicial")
    public Long getLecturainicial() {
        return lecturainicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15175-07:00", comments="Source field: Nota.lecturaInicial")
    public void setLecturainicial(Long lecturainicial) {
        this.lecturainicial = lecturainicial;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151857-07:00", comments="Source field: Nota.lecturaFinal")
    public Long getLecturafinal() {
        return lecturafinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151903-07:00", comments="Source field: Nota.lecturaFinal")
    public void setLecturafinal(Long lecturafinal) {
        this.lecturafinal = lecturafinal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.151994-07:00", comments="Source field: Nota.llegada")
    public String getLlegada() {
        return llegada;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152063-07:00", comments="Source field: Nota.llegada")
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152211-07:00", comments="Source field: Nota.descarga")
    public String getDescarga() {
        return descarga;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152281-07:00", comments="Source field: Nota.descarga")
    public void setDescarga(String descarga) {
        this.descarga = descarga;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152448-07:00", comments="Source field: Nota.salida")
    public String getSalida() {
        return salida;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152521-07:00", comments="Source field: Nota.salida")
    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152654-07:00", comments="Source field: Nota.precio")
    public BigDecimal getPrecio() {
        return precio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152749-07:00", comments="Source field: Nota.precio")
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152902-07:00", comments="Source field: Nota.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.152975-07:00", comments="Source field: Nota.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.153085-07:00", comments="Source field: Nota.litrosDescontados")
    public Integer getLitrosdescontados() {
        return litrosdescontados;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.153151-07:00", comments="Source field: Nota.litrosDescontados")
    public void setLitrosdescontados(Integer litrosdescontados) {
        this.litrosdescontados = litrosdescontados;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.153235-07:00", comments="Source field: Nota.razonDescuento")
    public String getRazondescuento() {
        return razondescuento;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-02T00:25:56.15328-07:00", comments="Source field: Nota.razonDescuento")
    public void setRazondescuento(String razondescuento) {
        this.razondescuento = razondescuento;
    }
}