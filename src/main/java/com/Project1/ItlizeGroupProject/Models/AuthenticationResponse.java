package com.Project1.ItlizeGroupProject.Models;

import com.Project1.ItlizeGroupProject.TO.UserTO;

import java.io.Serializable;
import java.util.Date;

public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private int userID;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String memberSince;
    public AuthenticationResponse(String jwttoken, UserTO user) {
        this.jwttoken = jwttoken;
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.memberSince = user.getMemberSince();
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public String getToken() {
        return this.jwttoken;
    }
}