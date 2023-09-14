package com.example.retro_care.user.model;

import java.io.Serializable;
import java.util.List;

/*
This is class is required for creating a response containing the JWT to be returned to the user.
 */
public class JwtResponse implements Serializable {

    private String jwtToken;
    private String userName;
    private List<String> grantList;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, String userName, List<String> grantList) {
        this.jwtToken = jwtToken;
        this.userName = userName;
        this.grantList = grantList;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getGrantList() {
        return grantList;
    }
}