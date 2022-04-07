package com.example.Restaurant.Management;

import javax.persistence.*;

@Entity
@Table

public class Restaurant {

    private String restaurantname;
    private String address;
    private String details;

    protected Restaurant(){
    }

    public Restaurant(String restaurantname, String address, String details) {
        this.restaurantname = restaurantname;
        this.address = address;
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

