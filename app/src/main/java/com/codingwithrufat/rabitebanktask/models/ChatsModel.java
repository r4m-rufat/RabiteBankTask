package com.codingwithrufat.rabitebanktask.models;

public class ChatsModel {

    private String type_person;
    private String type_message;
    private String message;
    private int image_message;
    private int image_profile;

    public ChatsModel(String type_person, String type_message, String message, int image_message, int image_profile) {
        this.type_person = type_person;
        this.type_message = type_message;
        this.message = message;
        this.image_message = image_message;
        this.image_profile = image_profile;
    }

    public String getType_person() {
        return type_person;
    }

    public void setType_person(String type_person) {
        this.type_person = type_person;
    }

    public String getType_message() {
        return type_message;
    }

    public void setType_message(String type_message) {
        this.type_message = type_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImage_message() {
        return image_message;
    }

    public void setImage_message(int image_message) {
        this.image_message = image_message;
    }

    public int getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(int image_profile) {
        this.image_profile = image_profile;
    }
}
