package com.ecobike.eshop.dao;

import com.ecobike.eshop.model.Bike;

import java.util.List;
import java.util.Optional;

public interface BikeDao<T extends Bike> {

    List<T> findAll();

    Optional<T> findByBrand(String brand);

    void saveAll(List<T> bikes);
}
