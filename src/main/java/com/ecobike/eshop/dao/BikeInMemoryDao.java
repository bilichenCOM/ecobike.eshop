package com.ecobike.eshop.dao;

import com.ecobike.eshop.model.Bike;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BikeInMemoryDao<T extends Bike> implements BikeDao<T> {

    protected final List<T> bikes = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return bikes;
    }

    public T save(T bike) {
        bikes.add(bike);
        return bike;
    }

    @Override
    public Optional<T> findByBrand(String brand) {
        return Optional.empty();
    }

    @Override
    public void saveAll(List<T> bikes) {
        this.bikes.addAll(bikes);
    }

    public void deleteAll() {
        bikes.clear();
    }
}
