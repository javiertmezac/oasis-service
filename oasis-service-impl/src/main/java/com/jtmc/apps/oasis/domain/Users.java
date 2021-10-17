package com.jtmc.apps.oasis.domain;

import java.util.Date;
import javax.annotation.Generated;

public class Users {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.461708-07:00", comments="Source field: Users.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.461943-07:00", comments="Source field: Users.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462097-07:00", comments="Source field: Users.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462273-07:00", comments="Source field: Users.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462433-07:00", comments="Source field: Users.regDate")
    private Date regdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462669-07:00", comments="Source field: Users.expDate")
    private Date expdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462836-07:00", comments="Source field: Users.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.461803-07:00", comments="Source field: Users.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.461889-07:00", comments="Source field: Users.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.461995-07:00", comments="Source field: Users.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.46205-07:00", comments="Source field: Users.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462147-07:00", comments="Source field: Users.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462212-07:00", comments="Source field: Users.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462326-07:00", comments="Source field: Users.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462387-07:00", comments="Source field: Users.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462549-07:00", comments="Source field: Users.regDate")
    public Date getRegdate() {
        return regdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462603-07:00", comments="Source field: Users.regDate")
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462732-07:00", comments="Source field: Users.expDate")
    public Date getExpdate() {
        return expdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.46279-07:00", comments="Source field: Users.expDate")
    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462884-07:00", comments="Source field: Users.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.462933-07:00", comments="Source field: Users.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}