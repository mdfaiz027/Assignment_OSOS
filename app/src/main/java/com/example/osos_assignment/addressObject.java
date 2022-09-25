package com.example.osos_assignment;

import com.google.gson.annotations.SerializedName;

public class addressObject {

    private String street, city, zipcode;

    @SerializedName("geo")
    private geoObject geoObject;

    public addressObject(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public addressObject(String street, String city, String zipcode, com.example.osos_assignment.geoObject geoObject) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.geoObject = geoObject;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public com.example.osos_assignment.geoObject getGeoObject() {
        return geoObject;
    }
}
