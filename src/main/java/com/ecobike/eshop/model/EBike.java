package com.ecobike.eshop.model;

public class EBike extends Bike {

    private Integer batteryCapacity;
    private Integer maximumSpeed;

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    @Override
    public String toString() {
        return String.format("E-BIKE %s with %d mAh battery and %shead/tail light.%sPrice %d euros.",
                getBrand(), batteryCapacity, getLightsAvailable() ? "" : "no ", System.lineSeparator(), getPrice());
    }
}
