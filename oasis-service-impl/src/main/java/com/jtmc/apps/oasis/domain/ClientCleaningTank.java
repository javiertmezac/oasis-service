package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class ClientCleaningTank {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.561798-08:00", comments="Source field: ClientCleaningTankRecord.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566057-08:00", comments="Source field: ClientCleaningTankRecord.clientId")
    private Integer clientid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566207-08:00", comments="Source field: ClientCleaningTankRecord.tankCleaningDate")
    private Instant tankcleaningdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566388-08:00", comments="Source field: ClientCleaningTankRecord.comments")
    private String comments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566596-08:00", comments="Source field: ClientCleaningTankRecord.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.565641-08:00", comments="Source field: ClientCleaningTankRecord.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.565976-08:00", comments="Source field: ClientCleaningTankRecord.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.56611-08:00", comments="Source field: ClientCleaningTankRecord.clientId")
    public Integer getClientid() {
        return clientid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566162-08:00", comments="Source field: ClientCleaningTankRecord.clientId")
    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566281-08:00", comments="Source field: ClientCleaningTankRecord.tankCleaningDate")
    public Instant getTankcleaningdate() {
        return tankcleaningdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566332-08:00", comments="Source field: ClientCleaningTankRecord.tankCleaningDate")
    public void setTankcleaningdate(Instant tankcleaningdate) {
        this.tankcleaningdate = tankcleaningdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566468-08:00", comments="Source field: ClientCleaningTankRecord.comments")
    public String getComments() {
        return comments;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566549-08:00", comments="Source field: ClientCleaningTankRecord.comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566643-08:00", comments="Source field: ClientCleaningTankRecord.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.566691-08:00", comments="Source field: ClientCleaningTankRecord.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}