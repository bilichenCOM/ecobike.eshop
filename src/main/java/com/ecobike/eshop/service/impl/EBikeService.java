package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.EBikeDao;
import com.ecobike.eshop.dao.impl.EBikeFileDao;
import com.ecobike.eshop.dao.impl.EBikeInMemoryDao;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.BikeService;

import java.util.List;
import java.util.Optional;

// TODO: remove redundant logic from service;
public class EBikeService extends BikeService<EBike> {

    private EBikeDao eBikeDao;
    private EBikeInMemoryDao eBikeInMemoryDao;

    public EBikeService() {
        eBikeDao = new EBikeFileDao();
        eBikeInMemoryDao = new EBikeInMemoryDao();
    }

    @Override
    public List<EBike> getAll() {
        return eBikeDao.findAll();
    }

    @Override
    public EBike saveInMemory(EBike bike) {
        return eBikeInMemoryDao.save(bike);
    }

    @Override
    public Optional<EBike> findByBrand(String brand) {
        return eBikeDao.findByBrand(brand);
    }

    @Override
    public void saveAllFromMemory() {
        List<EBike> inMemory = eBikeInMemoryDao.findAll();
        eBikeDao.saveAll(inMemory);
    }


}
