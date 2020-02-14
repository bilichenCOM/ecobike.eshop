package com.ecobike.eshop.dao;

import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.Bike;

public abstract class BikeFileDao<T extends Bike> implements BikeDao<T> {

    protected static FileDeserializer fileDeserializer = new FileDeserializer();
    protected static FileSerializer fileSerializer = new FileSerializer();

    public void setFileDeserializer(FileDeserializer fileDeserializer) {
        BikeFileDao.fileDeserializer = fileDeserializer;
    }

    public void setFileSerializer(FileSerializer fileSerializer) {
        BikeFileDao.fileSerializer = fileSerializer;
    }
}
