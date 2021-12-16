package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Empresa {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.058007-08:00", comments="Source field: Empresa.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062136-08:00", comments="Source field: Empresa.noCliente")
    private String nocliente;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062338-08:00", comments="Source field: Empresa.noFactura")
    private String nofactura;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062488-08:00", comments="Source field: Empresa.nombre")
    private String nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062673-08:00", comments="Source field: Empresa.rfc")
    private String rfc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062837-08:00", comments="Source field: Empresa.telefono")
    private String telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063005-08:00", comments="Source field: Empresa.colonia")
    private String colonia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063174-08:00", comments="Source field: Empresa.calle")
    private String calle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063345-08:00", comments="Source field: Empresa.noInt")
    private String noint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063492-08:00", comments="Source field: Empresa.noExt")
    private String noext;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063626-08:00", comments="Source field: Empresa.cPostal")
    private String cpostal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06387-08:00", comments="Source field: Empresa.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064049-08:00", comments="Source field: Empresa.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064266-08:00", comments="Source field: Empresa.idPrecio")
    private Byte idprecio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064428-08:00", comments="Source field: Empresa.sigLavado")
    private Instant siglavado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064598-08:00", comments="Source field: Empresa.nextCleaningComments")
    private String nextcleaningcomments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.061704-08:00", comments="Source field: Empresa.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062065-08:00", comments="Source field: Empresa.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062196-08:00", comments="Source field: Empresa.noCliente")
    public String getNocliente() {
        return nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062289-08:00", comments="Source field: Empresa.noCliente")
    public void setNocliente(String nocliente) {
        this.nocliente = nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062393-08:00", comments="Source field: Empresa.noFactura")
    public String getNofactura() {
        return nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062443-08:00", comments="Source field: Empresa.noFactura")
    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062546-08:00", comments="Source field: Empresa.nombre")
    public String getNombre() {
        return nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06261-08:00", comments="Source field: Empresa.nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062734-08:00", comments="Source field: Empresa.rfc")
    public String getRfc() {
        return rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062785-08:00", comments="Source field: Empresa.rfc")
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062885-08:00", comments="Source field: Empresa.telefono")
    public String getTelefono() {
        return telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.062948-08:00", comments="Source field: Empresa.telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063077-08:00", comments="Source field: Empresa.colonia")
    public String getColonia() {
        return colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063131-08:00", comments="Source field: Empresa.colonia")
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063243-08:00", comments="Source field: Empresa.calle")
    public String getCalle() {
        return calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063292-08:00", comments="Source field: Empresa.calle")
    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063394-08:00", comments="Source field: Empresa.noInt")
    public String getNoint() {
        return noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063449-08:00", comments="Source field: Empresa.noInt")
    public void setNoint(String noint) {
        this.noint = noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063537-08:00", comments="Source field: Empresa.noExt")
    public String getNoext() {
        return noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063584-08:00", comments="Source field: Empresa.noExt")
    public void setNoext(String noext) {
        this.noext = noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063697-08:00", comments="Source field: Empresa.cPostal")
    public String getCpostal() {
        return cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063787-08:00", comments="Source field: Empresa.cPostal")
    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063945-08:00", comments="Source field: Empresa.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.063996-08:00", comments="Source field: Empresa.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064167-08:00", comments="Source field: Empresa.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064218-08:00", comments="Source field: Empresa.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064315-08:00", comments="Source field: Empresa.idPrecio")
    public Byte getIdprecio() {
        return idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064383-08:00", comments="Source field: Empresa.idPrecio")
    public void setIdprecio(Byte idprecio) {
        this.idprecio = idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.06451-08:00", comments="Source field: Empresa.sigLavado")
    public Instant getSiglavado() {
        return siglavado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064557-08:00", comments="Source field: Empresa.sigLavado")
    public void setSiglavado(Instant siglavado) {
        this.siglavado = siglavado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064658-08:00", comments="Source field: Empresa.nextCleaningComments")
    public String getNextcleaningcomments() {
        return nextcleaningcomments;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T23:49:28.064723-08:00", comments="Source field: Empresa.nextCleaningComments")
    public void setNextcleaningcomments(String nextcleaningcomments) {
        this.nextcleaningcomments = nextcleaningcomments;
    }
}