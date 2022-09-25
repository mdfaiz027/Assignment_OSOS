package com.example.osos_assignment;

public class MyModel {
    String name, username, email, street, city, zipcode, lat, lng;

    public MyModel(String name, String username, String email, String street, String city, String zipcode) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

/*    public MyModel(String name, String username, String email, String street, String city, String zipcode, String lat, String lng) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.lat = lat;
        this.lng = lng;
    }*/

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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

//    public String getLat() {
//        return lat;
//    }
//
//    public String getLng() {
//        return lng;
//    }
}
