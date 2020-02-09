package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.impl.FoldingBikeDao;
import com.ecobike.eshop.dao.impl.FoldingBikeFileDao;
import com.ecobike.eshop.model.FoldingBike;

import java.util.List;

public class FoldingBikeService implements BikeService<FoldingBike> {

    private FoldingBikeDao foldingBikeDao;

    public FoldingBikeService() {
        foldingBikeDao = new FoldingBikeFileDao();
    }

    @Override
    public List<FoldingBike> getAll() {
        return foldingBikeDao.findAll();
    }

    @Override
    public FoldingBike save(FoldingBike bike) {
        return foldingBikeDao.save(bike);
    }
}
