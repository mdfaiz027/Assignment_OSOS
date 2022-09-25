package com.example.osos_assignment;

import com.google.gson.annotations.SerializedName;

public class ArrayMultipleObjectModel {

    private String name, username, email;

    @SerializedName("address")
    private addressObject addressObject;

    public ArrayMultipleObjectModel(String name, String username, String email, com.example.osos_assignment.addressObject addressObject) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.addressObject = addressObject;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public com.example.osos_assignment.addressObject getAddressObject() {
        return addressObject;
    }
}
