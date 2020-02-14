package com.ecobike.eshop.model;

import java.util.Objects;

public class EBike extends Bike {

    private Integer batteryCapacity;
    private Integer maximumSpeed;

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getBatteryCapacity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EBike eBike = (EBike) o;
        return Objects.equals(batteryCapacity, eBike.batteryCapacity) &&
                Objects.equals(maximumSpeed, eBike.maximumSpeed) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, maximumSpeed);
    }
}
