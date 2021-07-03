package com.codingwithrufat.rabitebanktask.models;

public class MessagesModel {

    private String type;
    private String username;
    private String last_message;
    private String time;
    private int image1;
    private int image2;

    public MessagesModel(String type, String username, String last_message, String time, int image1, int image2) {
        this.type = type;
        this.username = username;
        this.last_message = last_message;
        this.time = time;
        this.image1 = image1;
        this.image2 = image2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_message() {
        return last_message;
    }

    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
}
