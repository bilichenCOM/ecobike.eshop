package com.ecobike.eshop.stub.model;

import com.ecobike.eshop.model.FoldingBike;

public class FoldingBikeStub implements BikeStub<FoldingBike> {

    @Override
    public FoldingBike stub(String brand) {
        FoldingBike stub = new FoldingBike();
        stub.setBrand(brand);
        stub.setWheelsSize(24);
        stub.setGearsNumber(7);
        stub.setWeight(15000);
        stub.setLightsAvailable(true);
        stub.setColor("white");
        stub.setPrice(142);
        return stub;
    }
}
