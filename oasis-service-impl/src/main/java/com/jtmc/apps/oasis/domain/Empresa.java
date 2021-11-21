package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Empresa {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.90306-08:00", comments="Source field: Empresa.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907065-08:00", comments="Source field: Empresa.noCliente")
    private String nocliente;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907241-08:00", comments="Source field: Empresa.noFactura")
    private String nofactura;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907381-08:00", comments="Source field: Empresa.nombre")
    private String nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907539-08:00", comments="Source field: Empresa.rfc")
    private String rfc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907686-08:00", comments="Source field: Empresa.telefono")
    private String telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907822-08:00", comments="Source field: Empresa.colonia")
    private String colonia;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907971-08:00", comments="Source field: Empresa.calle")
    private String calle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908119-08:00", comments="Source field: Empresa.noInt")
    private String noint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908269-08:00", comments="Source field: Empresa.noExt")
    private String noext;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908414-08:00", comments="Source field: Empresa.cPostal")
    private String cpostal;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908593-08:00", comments="Source field: Empresa.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908817-08:00", comments="Source field: Empresa.fechaRegistro")
    private Instant fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909072-08:00", comments="Source field: Empresa.idPrecio")
    private Byte idprecio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909258-08:00", comments="Source field: Empresa.sigLavado")
    private Instant siglavado;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.906692-08:00", comments="Source field: Empresa.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907004-08:00", comments="Source field: Empresa.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907117-08:00", comments="Source field: Empresa.noCliente")
    public String getNocliente() {
        return nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907194-08:00", comments="Source field: Empresa.noCliente")
    public void setNocliente(String nocliente) {
        this.nocliente = nocliente;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907288-08:00", comments="Source field: Empresa.noFactura")
    public String getNofactura() {
        return nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907337-08:00", comments="Source field: Empresa.noFactura")
    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907439-08:00", comments="Source field: Empresa.nombre")
    public String getNombre() {
        return nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907495-08:00", comments="Source field: Empresa.nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907586-08:00", comments="Source field: Empresa.rfc")
    public String getRfc() {
        return rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907634-08:00", comments="Source field: Empresa.rfc")
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907733-08:00", comments="Source field: Empresa.telefono")
    public String getTelefono() {
        return telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.90778-08:00", comments="Source field: Empresa.telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907879-08:00", comments="Source field: Empresa.colonia")
    public String getColonia() {
        return colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.907929-08:00", comments="Source field: Empresa.colonia")
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908029-08:00", comments="Source field: Empresa.calle")
    public String getCalle() {
        return calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908077-08:00", comments="Source field: Empresa.calle")
    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908173-08:00", comments="Source field: Empresa.noInt")
    public String getNoint() {
        return noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908227-08:00", comments="Source field: Empresa.noInt")
    public void setNoint(String noint) {
        this.noint = noint;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908313-08:00", comments="Source field: Empresa.noExt")
    public String getNoext() {
        return noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908369-08:00", comments="Source field: Empresa.noExt")
    public void setNoext(String noext) {
        this.noext = noext;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908459-08:00", comments="Source field: Empresa.cPostal")
    public String getCpostal() {
        return cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908528-08:00", comments="Source field: Empresa.cPostal")
    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908663-08:00", comments="Source field: Empresa.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.90873-08:00", comments="Source field: Empresa.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.908938-08:00", comments="Source field: Empresa.fechaRegistro")
    public Instant getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909009-08:00", comments="Source field: Empresa.fechaRegistro")
    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909133-08:00", comments="Source field: Empresa.idPrecio")
    public Byte getIdprecio() {
        return idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909213-08:00", comments="Source field: Empresa.idPrecio")
    public void setIdprecio(Byte idprecio) {
        this.idprecio = idprecio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.90931-08:00", comments="Source field: Empresa.sigLavado")
    public Instant getSiglavado() {
        return siglavado;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-20T15:10:50.909354-08:00", comments="Source field: Empresa.sigLavado")
    public void setSiglavado(Instant siglavado) {
        this.siglavado = siglavado;
    }
}