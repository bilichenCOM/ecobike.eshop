package com.ecobike.eshop.model;

public class FoldingBike extends Bike {

    private Double wheelsSize;
    private Integer gearsNumber;

    public Double getWheelsSize() {
        return wheelsSize;
    }

    public void setWheelsSize(Double wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public Integer getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(Integer gearsNumber) {
        this.gearsNumber = gearsNumber;
    }
}
