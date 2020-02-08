package com.ecobike.eshop.dao;

import com.ecobike.eshop.model.EBike;

import java.util.ArrayList;
import java.util.List;

public class EBikeDaoInMemory extends EBikeDao {

    private List<EBike> bikes = new ArrayList<>();

    @Override
    public List<EBike> findAll() {
        return bikes;
    }

    @Override
    public EBike save(EBike bike) {
        bikes.add(bike);
        return bike;
    }

    public void deleteAll() {
        bikes.clear();
    }
}
