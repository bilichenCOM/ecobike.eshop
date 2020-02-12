package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.FoldingBikeDao;
import com.ecobike.eshop.dao.impl.FoldingBikeFileDao;
import com.ecobike.eshop.dao.impl.FoldingBikeInMemoryDao;
import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.service.BikeService;

import java.util.List;
import java.util.Optional;

// TODO: remove redundant logic from service;
public class FoldingBikeService extends BikeService<FoldingBike> {

    private FoldingBikeDao foldingBikeDao;
    private FoldingBikeInMemoryDao foldingBikeInMemory;

    public FoldingBikeService() {
        foldingBikeDao = new FoldingBikeFileDao();
        foldingBikeInMemory = new FoldingBikeInMemoryDao();
    }

    @Override
    public List<FoldingBike> getAll() {
        return foldingBikeDao.findAll();
    }

    @Override
    public FoldingBike saveInMemory(FoldingBike bike) {
        return foldingBikeInMemory.save(bike);
    }

    @Override
    public Optional<FoldingBike> findByBrand(String brand) {
        return foldingBikeDao.findByBrand(brand);
    }

    @Override
    public void saveAllFromMemory() {
        List<FoldingBike> inMemory = foldingBikeInMemory.findAll();
        foldingBikeDao.saveAll(inMemory);
    }
}
