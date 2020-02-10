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
            return fileDeserializer.readList("E-BIKE", new EBikeRowMapper());
        } catch (IOException e) {
            System.err.println("sorry, some problems reading file with data " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public EBike save(EBike bike) {
        return null;
    }

    public static class EBikeRowMapper implements FileDeserializer.RowMapper<EBike> {

        @Override
        public EBike mapRow(String row) {
            String[] properties = row.split(DEFAULT_DELIMITER);
            EBike eBike = new EBike();
            eBike.setBrand(properties[0]);
            eBike.setMaximumSpeed(Integer.parseInt(properties[1]));
            eBike.setWeight(Integer.parseInt(properties[2]));
            eBike.setLightsAvailable(Boolean.parseBoolean(properties[3]));
            eBike.setBatteryCapacity(Integer.parseInt(properties[4]));
            eBike.setColor(properties[5]);
            eBike.setPrice(Integer.parseInt(properties[6]));
            return eBike;
        }
    }
}
