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
}
