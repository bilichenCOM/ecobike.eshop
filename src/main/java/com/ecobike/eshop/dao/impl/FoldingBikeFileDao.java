package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.dao.BikeFileDao;
import com.ecobike.eshop.model.FoldingBike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ecobike.eshop.helper.FileDeserializer.RowMapper.DEFAULT_DELIMITER;

public class FoldingBikeFileDao extends BikeFileDao<FoldingBike> implements FoldingBikeDao {

    @Override
    public List<FoldingBike> findAll() {
        try {
            return fileDeserializer.readList("FOLDING BIKE", row -> {
                String[] properties = row.split(DEFAULT_DELIMITER);
                FoldingBike foldingBike = new FoldingBike();
                foldingBike.setBrand(properties[0]);
                foldingBike.setWheelsSize(Double.parseDouble(properties[1]));
                foldingBike.setGearsNumber(Integer.parseInt(properties[2]));
                foldingBike.setWeight(Integer.parseInt(properties[3]));
                foldingBike.setLightsAvailable(Boolean.parseBoolean(properties[4]));
                foldingBike.setColor(properties[5]);
                foldingBike.setPrice(Double.parseDouble(properties[6]));
                return foldingBike;
            });
        } catch (IOException e) {
            System.err.println("some problems by reading file...");
        }
        return new ArrayList<>();
    }

    @Override
    public FoldingBike save(FoldingBike bike) {
        return null;
    }
}
