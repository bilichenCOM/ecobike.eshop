package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeInMemoryDao;
import com.ecobike.eshop.model.EBike;

import java.util.List;

public class EBikeInMemoryDao extends BikeInMemoryDao<EBike> implements EBikeDao {

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
