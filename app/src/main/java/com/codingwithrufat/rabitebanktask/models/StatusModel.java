package com.codingwithrufat.rabitebanktask.models;

public class StatusModel {
    private int status_image;
    private String username;

    public StatusModel(int status_image, String username) {
        this.status_image = status_image;
        this.username = username;
    }

    public int getStatus_image() {
        return status_image;
    }

    public void setStatus_image(int status_image) {
        this.status_image = status_image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
