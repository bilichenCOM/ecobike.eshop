package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.BikeDao;
import com.ecobike.eshop.dao.BikeInMemoryDao;
import com.ecobike.eshop.model.Bike;

import java.util.List;
import java.util.Optional;

public abstract class BikeService<T extends Bike> {

    protected BikeDao<T> bikeDao;
    protected BikeInMemoryDao<T> bikeInMemoryDao;

    public List<T> getAll() {
        return bikeDao.findAll();
    };

    public T saveInMemory(T bike) {
        return bikeInMemoryDao.save(bike);
    }

    public Optional<T> findByBrand(String brand) {
        return bikeDao.findByBrand(brand);
    }

    public void saveAllFromMemory() {
        List<T> inMemory = bikeInMemoryDao.findAll();
        bikeDao.saveAll(inMemory);
    }
}
