package com.ecobike.eshop.dao;

import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.Bike;

public abstract class BikeFileDao<T extends Bike> implements BikeDao<T> {

    protected static final FileDeserializer fileDeserializer = new FileDeserializer();
    protected static final FileSerializer fileSerializer = new FileSerializer();
}
