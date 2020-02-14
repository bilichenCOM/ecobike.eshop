package com.ecobike.eshop.model;

import java.util.Objects;

public class FoldingBike extends Bike {

    private Integer wheelsSize;
    private Integer gearsNumber;

    public Integer getWheelsSize() {
        return wheelsSize;
    }

    public void setWheelsSize(Integer wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public Integer getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(Integer gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    @Override
    public String toString() {
        return String.format("FOLDING BIKE %s with %d gear(s) and %shead/tail light.%sPrice: %d euros.",
                getBrand(), gearsNumber, getLightsAvailable() ? "" : "no ", System.lineSeparator(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoldingBike that = (FoldingBike) o;
        return Objects.equals(wheelsSize, that.wheelsSize) &&
                Objects.equals(gearsNumber, that.gearsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wheelsSize, gearsNumber);
    }
}
