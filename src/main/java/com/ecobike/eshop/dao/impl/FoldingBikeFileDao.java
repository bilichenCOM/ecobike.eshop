package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.FoldingBike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoldingBikeFileDao extends BikeFileDao<FoldingBike> implements FoldingBikeDao {

    @Override
    public List<FoldingBike> findAll() {
        try {
            return fileDeserializer.readList("FOLDING BIKE", new FoldingBikeRowMapper());
        } catch (IOException e) {
            System.err.println("some problems by reading file...");
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<FoldingBike> findByBrand(String brand) {
        return Optional.empty();
    }

    @Override
    public void saveAll(List<FoldingBike> bikes) {
        fileSerializer.writeLines(bikes, new FoldingBikeSerializer());
    }

    public static class FoldingBikeRowMapper implements FileDeserializer.RowMapper<FoldingBike> {

        @Override
        public FoldingBike mapRow(String row) {
            String[] properties = row.split(DEFAULT_DELIMITER);
            FoldingBike foldingBike = new FoldingBike();
            foldingBike.setBrand(properties[0]);
            foldingBike.setWheelsSize(Integer.parseInt(properties[1]));
            foldingBike.setGearsNumber(Integer.parseInt(properties[2]));
            foldingBike.setWeight(Integer.parseInt(properties[3]));
            foldingBike.setLightsAvailable(Boolean.parseBoolean(properties[4]));
            foldingBike.setColor(properties[5]);
            foldingBike.setPrice(Integer.parseInt(properties[6]));
            return foldingBike;
        }
    }

    public static class FoldingBikeSerializer implements FileSerializer.Serializer<FoldingBike> {
        @Override
        public String serializeToString(FoldingBike foldingBike) {
            return String.join(DEFAULT_DELIMITER, foldingBike.getBrand(), foldingBike.getWheelsSize().toString(),
                    foldingBike.getGearsNumber().toString(), foldingBike.getWeight().toString(),
                    foldingBike.getLightsAvailable().toString(), foldingBike.getColor(),
                    foldingBike.getPrice().toString());
        }
    }
}
