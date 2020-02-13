package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.Speedelec;

import java.util.List;
import java.util.Optional;

public class SpeedelecFileDao extends BikeFileDao<Speedelec> implements SpeedelecDao {

    @Override
    public List<Speedelec> findAll() {
        return fileDeserializer.readList("SPEEDELEC", new SpeedelecRowMapper());
    }

    @Override
    public Optional<Speedelec> findByBrand(String brand) {
        return fileDeserializer.readObject("SPEEDELEC", brand, new SpeedelecRowMapper());
    }

    @Override
    public void saveAll(List<Speedelec> bikes) {
        fileSerializer.writeLines(bikes, new SpeedelecSerializer());

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

    private static class SpeedelecSerializer implements FileSerializer.Serializer<Speedelec> {
        @Override
        public String serializeToString(Speedelec speedelec) {
            return "SPEEDELEC " + String.join(DEFAULT_DELIMITER, speedelec.getBrand(),
                    speedelec.getMaximumSpeed().toString(),
                    speedelec.getWeight().toString(), speedelec.getLightsAvailable().toString(),
                    speedelec.getBatteryCapacity().toString(), speedelec.getColor(),
                    speedelec.getPrice().toString());
        }
    }
}
