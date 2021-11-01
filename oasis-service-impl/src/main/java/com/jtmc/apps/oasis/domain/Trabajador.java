package com.jtmc.apps.oasis.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Trabajador {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.708395-07:00", comments="Source field: Trabajador.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713227-07:00", comments="Source field: Trabajador.codigo")
    private String codigo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713443-07:00", comments="Source field: Trabajador.nombre")
    private String nombre;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.71367-07:00", comments="Source field: Trabajador.telefono")
    private String telefono;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713902-07:00", comments="Source field: Trabajador.direccion")
    private String direccion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714087-07:00", comments="Source field: Trabajador.fechaRegistro")
    private Date fecharegistro;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714367-07:00", comments="Source field: Trabajador.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.712767-07:00", comments="Source field: Trabajador.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713154-07:00", comments="Source field: Trabajador.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713287-07:00", comments="Source field: Trabajador.codigo")
    public String getCodigo() {
        return codigo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713372-07:00", comments="Source field: Trabajador.codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.71352-07:00", comments="Source field: Trabajador.nombre")
    public String getNombre() {
        return nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713583-07:00", comments="Source field: Trabajador.nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713757-07:00", comments="Source field: Trabajador.telefono")
    public String getTelefono() {
        return telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713829-07:00", comments="Source field: Trabajador.telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.713976-07:00", comments="Source field: Trabajador.direccion")
    public String getDireccion() {
        return direccion;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714034-07:00", comments="Source field: Trabajador.direccion")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714209-07:00", comments="Source field: Trabajador.fechaRegistro")
    public Date getFecharegistro() {
        return fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714298-07:00", comments="Source field: Trabajador.fechaRegistro")
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714495-07:00", comments="Source field: Trabajador.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-23T01:58:07.714583-07:00", comments="Source field: Trabajador.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}