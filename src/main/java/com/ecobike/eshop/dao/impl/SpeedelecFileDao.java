package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.model.Speedelec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpeedelecFileDao extends BikeFileDao<Speedelec> implements SpeedelecDao {

    @Override
    public List<Speedelec> findAll() {
        try {
            return fileDeserializer.readList("SPEEDELEC", new SpeedelecRowMapper());
        } catch (IOException e) {
            System.err.println("something went wrong by reading file..");
        }
        return new ArrayList<>();
    }

    @Override
    public Speedelec save(Speedelec bike) {
        // TODO: implement this method;
        return null;
    }

    public static class SpeedelecRowMapper implements FileDeserializer.RowMapper<Speedelec> {

        @Override
        public Speedelec mapRow(String row) {
            String[] properties = row.split(DEFAULT_DELIMITER);
            Speedelec speedelec = new Speedelec();
            speedelec.setBrand(properties[0]);
            speedelec.setMaximumSpeed(Integer.parseInt(properties[1]));
            speedelec.setWeight(Integer.parseInt(properties[2]));
            speedelec.setLightsAvailable(Boolean.parseBoolean(properties[3]));
            speedelec.setBatteryCapacity(Integer.parseInt(properties[4]));
            speedelec.setColor(properties[5]);
            speedelec.setPrice(Integer.parseInt(properties[6]));
            return speedelec;
        }
    }
}
