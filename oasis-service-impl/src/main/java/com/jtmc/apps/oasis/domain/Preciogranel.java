package com.jtmc.apps.oasis.domain;

import javax.annotation.Generated;

public class Preciogranel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:03.997011-08:00", comments="Source field: PrecioGranel.id")
    private Byte id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.001285-08:00", comments="Source field: PrecioGranel.precio")
    private Double precio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.000784-08:00", comments="Source field: PrecioGranel.id")
    public Byte getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.001179-08:00", comments="Source field: PrecioGranel.id")
    public void setId(Byte id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.001341-08:00", comments="Source field: PrecioGranel.precio")
    public Double getPrecio() {
        return precio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.001394-08:00", comments="Source field: PrecioGranel.precio")
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}