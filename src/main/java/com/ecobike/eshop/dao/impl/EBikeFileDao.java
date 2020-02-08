package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.model.EBike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EBikeFileDao extends BikeFileDao<EBike> implements EBikeDao {

    @Override
    public List<EBike> findAll() {
        try {
            return fileDeserializer.readList("E-BIKE", new EbikeRowMapper());
        } catch (IOException e) {
            System.err.println("sorry, some problems reading file with data");
        }
        return new ArrayList<>();
    }

    @Override
    public EBike save(EBike bike) {
        return null;
    }

    private class EbikeRowMapper implements FileDeserializer.RowMapper<EBike> {

        @Override
        public EBike mapRow(String row) {
            return null;
        }
    }
}
