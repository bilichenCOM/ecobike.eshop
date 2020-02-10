package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.model.FoldingBike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public FoldingBike save(FoldingBike bike) {
        // TODO: implement this method;
        return null;
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
}
