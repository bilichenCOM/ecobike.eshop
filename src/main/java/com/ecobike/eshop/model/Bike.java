package com.ecobike.eshop.model;

import java.util.Objects;

public abstract class Bike {

    private String brand;
    private Integer weight;
    private Boolean lightsAvailable;
    private String color;
    private Integer price;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(brand, bike.brand) &&
                Objects.equals(weight, bike.weight) &&
                Objects.equals(lightsAvailable, bike.lightsAvailable) &&
                Objects.equals(color, bike.color) &&
                Objects.equals(price, bike.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, weight, lightsAvailable, color, price);
    }
}
