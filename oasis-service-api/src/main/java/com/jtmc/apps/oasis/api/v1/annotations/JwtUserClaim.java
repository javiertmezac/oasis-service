package com.jtmc.apps.oasis.api.v1.annotations;

public class JwtUserClaim {

    private String subject;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}
