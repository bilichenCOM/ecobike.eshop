package com.ecobike.eshop.dao;

import com.ecobike.eshop.model.Bike;

import java.util.ArrayList;
import java.util.List;

public abstract class BikeInMemoryDao<T extends Bike> implements BikeDao<T> {

    protected final List<T> bikes = new ArrayList<>();
}
