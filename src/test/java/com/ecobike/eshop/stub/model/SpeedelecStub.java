package com.ecobike.eshop.stub.model;

import com.ecobike.eshop.model.Speedelec;

public class SpeedelecStub implements BikeStub<Speedelec> {

    @Override
    public Speedelec stub(String brand) {
        Speedelec stub = new Speedelec();
        stub.setBrand(brand);
        stub.setMaximumSpeed(40);
        stub.setWeight(15000);
        stub.setLightsAvailable(true);
        stub.setBatteryCapacity(16000);
        stub.setColor("white");
        stub.setPrice(142);
        return stub;
    }
}
