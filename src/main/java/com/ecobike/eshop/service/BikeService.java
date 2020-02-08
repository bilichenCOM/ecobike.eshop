package com.ecobike.eshop.service;

import com.ecobike.eshop.model.Bike;

import java.util.List;

public interface BikeService<T extends Bike> {

    List<T> getAll();
}
