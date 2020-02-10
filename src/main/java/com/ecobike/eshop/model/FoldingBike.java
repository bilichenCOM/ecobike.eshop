package com.ecobike.eshop.model;

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
}
