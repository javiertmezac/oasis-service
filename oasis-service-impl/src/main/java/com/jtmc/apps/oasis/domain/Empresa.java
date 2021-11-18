package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Empresa {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.548445-08:00", comments="Source field: Empresa.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551571-08:00", comments="Source field: Empresa.noCliente")
    private String nocliente;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551753-08:00", comments="Source field: Empresa.noFactura")
    private String nofactura;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551898-08:00", comments="Source field: Empresa.nombre")
    private String nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552056-08:00", comments="Source field: Empresa.rfc")
    private String rfc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552207-08:00", comments="Source field: Empresa.telefono")
    private String telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552345-08:00", comments="Source field: Empresa.colonia")
    private String colonia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552492-08:00", comments="Source field: Empresa.calle")
    private String calle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.55264-08:00", comments="Source field: Empresa.noInt")
    private Integer noint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552776-08:00", comments="Source field: Empresa.noExt")
    private Integer noext;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552908-08:00", comments="Source field: Empresa.cPostal")
    private Integer cpostal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553056-08:00", comments="Source field: Empresa.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553192-08:00", comments="Source field: Empresa.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553397-08:00", comments="Source field: Empresa.idPrecio")
    private Byte idprecio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553549-08:00", comments="Source field: Empresa.sigLavado")
    private Instant siglavado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551175-08:00", comments="Source field: Empresa.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551505-08:00", comments="Source field: Empresa.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551625-08:00", comments="Source field: Empresa.noCliente")
    public String getNocliente() {
        return nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551705-08:00", comments="Source field: Empresa.noCliente")
    public void setNocliente(String nocliente) {
        this.nocliente = nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551802-08:00", comments="Source field: Empresa.noFactura")
    public String getNofactura() {
        return nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551853-08:00", comments="Source field: Empresa.noFactura")
    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.551957-08:00", comments="Source field: Empresa.nombre")
    public String getNombre() {
        return nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.55201-08:00", comments="Source field: Empresa.nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552104-08:00", comments="Source field: Empresa.rfc")
    public String getRfc() {
        return rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552161-08:00", comments="Source field: Empresa.rfc")
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552255-08:00", comments="Source field: Empresa.telefono")
    public String getTelefono() {
        return telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552303-08:00", comments="Source field: Empresa.telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.5524-08:00", comments="Source field: Empresa.colonia")
    public String getColonia() {
        return colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552449-08:00", comments="Source field: Empresa.colonia")
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552549-08:00", comments="Source field: Empresa.calle")
    public String getCalle() {
        return calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552597-08:00", comments="Source field: Empresa.calle")
    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552685-08:00", comments="Source field: Empresa.noInt")
    public Integer getNoint() {
        return noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552734-08:00", comments="Source field: Empresa.noInt")
    public void setNoint(Integer noint) {
        this.noint = noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552821-08:00", comments="Source field: Empresa.noExt")
    public Integer getNoext() {
        return noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552866-08:00", comments="Source field: Empresa.noExt")
    public void setNoext(Integer noext) {
        this.noext = noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.552954-08:00", comments="Source field: Empresa.cPostal")
    public Integer getCpostal() {
        return cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553012-08:00", comments="Source field: Empresa.cPostal")
    public void setCpostal(Integer cpostal) {
        this.cpostal = cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553102-08:00", comments="Source field: Empresa.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553149-08:00", comments="Source field: Empresa.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553281-08:00", comments="Source field: Empresa.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553346-08:00", comments="Source field: Empresa.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553443-08:00", comments="Source field: Empresa.idPrecio")
    public Byte getIdprecio() {
        return idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553491-08:00", comments="Source field: Empresa.idPrecio")
    public void setIdprecio(Byte idprecio) {
        this.idprecio = idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553611-08:00", comments="Source field: Empresa.sigLavado")
    public Instant getSiglavado() {
        return siglavado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-17T12:30:44.553658-08:00", comments="Source field: Empresa.sigLavado")
    public void setSiglavado(Instant siglavado) {
        this.siglavado = siglavado;
    }
}