package com.ecobike.eshop.dao;

import com.ecobike.eshop.model.Bike;

import java.util.List;

public interface BikeDao<T extends Bike> {

    List<T> findAll();

    T save(T bike);
}
