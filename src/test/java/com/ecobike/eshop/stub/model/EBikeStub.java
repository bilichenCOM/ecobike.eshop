package com.ecobike.eshop.stub.model;

import com.ecobike.eshop.model.EBike;

public class EBikeStub implements BikeStub<EBike> {

    @Override
    public EBike stub(String brand) {
        EBike stub = new EBike();
        stub.setBrand("Peugeot");
        stub.setMaximumSpeed(40);
        stub.setWeight(15000);
        stub.setLightsAvailable(true);
        stub.setBatteryCapacity(16000);
        stub.setColor("white");
        stub.setPrice(142);
        return stub;
    }
}
