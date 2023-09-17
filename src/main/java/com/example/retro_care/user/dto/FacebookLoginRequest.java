package com.example.retro_care.user.dto;

public class FacebookLoginRequest {
    private String accessTokenFacebook;

    public FacebookLoginRequest() {
    }

    public FacebookLoginRequest(String accessTokenFacebook) {
        this.accessTokenFacebook = accessTokenFacebook;
    }

    public String getAccessTokenFacebook() {
        return accessTokenFacebook;
    }

    public void setAccessTokenFacebook(String accessTokenFacebook) {
        this.accessTokenFacebook = accessTokenFacebook;
    }
}
