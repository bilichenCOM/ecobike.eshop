package com.ecobike.eshop.model;

public class Speedelec extends EBike {

    @Override
    public String toString() {
        return super.toString().replace("E-BIKE", "SPEEDELEC");
    }
}
