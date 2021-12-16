package com.jtmc.apps.oasis.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class ClientCleaningTank {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.08136-08:00", comments="Source field: ClientCleaningTank.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085531-08:00", comments="Source field: ClientCleaningTank.clientId")
    private Integer clientid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.08568-08:00", comments="Source field: ClientCleaningTank.tankCleaningDate")
    private Instant tankcleaningdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.08585-08:00", comments="Source field: ClientCleaningTank.comments")
    private String comments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.086039-08:00", comments="Source field: ClientCleaningTank.registrationDate")
    private Instant registrationdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.086188-08:00", comments="Source field: ClientCleaningTank.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085141-08:00", comments="Source field: ClientCleaningTank.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085466-08:00", comments="Source field: ClientCleaningTank.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085583-08:00", comments="Source field: ClientCleaningTank.clientId")
    public Integer getClientid() {
        return clientid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085634-08:00", comments="Source field: ClientCleaningTank.clientId")
    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085754-08:00", comments="Source field: ClientCleaningTank.tankCleaningDate")
    public Instant getTankcleaningdate() {
        return tankcleaningdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085805-08:00", comments="Source field: ClientCleaningTank.tankCleaningDate")
    public void setTankcleaningdate(Instant tankcleaningdate) {
        this.tankcleaningdate = tankcleaningdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085911-08:00", comments="Source field: ClientCleaningTank.comments")
    public String getComments() {
        return comments;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.085992-08:00", comments="Source field: ClientCleaningTank.comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.08609-08:00", comments="Source field: ClientCleaningTank.registrationDate")
    public Instant getRegistrationdate() {
        return registrationdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.086144-08:00", comments="Source field: ClientCleaningTank.registrationDate")
    public void setRegistrationdate(Instant registrationdate) {
        this.registrationdate = registrationdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.086235-08:00", comments="Source field: ClientCleaningTank.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.086282-08:00", comments="Source field: ClientCleaningTank.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}