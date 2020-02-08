package com.ecobike.eshop.model;

public abstract class Bike {

    private String brand;
    private Integer weight;
    private Boolean lightsAvailable;
    private String color;
    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getLightsAvailable() {
        return lightsAvailable;
    }

    public void setLightsAvailable(Boolean lightsAvailable) {
        this.lightsAvailable = lightsAvailable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
