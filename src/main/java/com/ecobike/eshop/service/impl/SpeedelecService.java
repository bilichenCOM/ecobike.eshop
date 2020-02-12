package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.SpeedelecDao;
import com.ecobike.eshop.dao.impl.SpeedelecFileDao;
import com.ecobike.eshop.dao.impl.SpeedelecInMemoryDao;
import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.BikeService;

import java.util.List;
import java.util.Optional;

// TODO: remove redundant logic from service;
public class SpeedelecService extends BikeService<Speedelec> {

    private SpeedelecDao speedelecDao;
    private SpeedelecInMemoryDao speedelecInMemoryDao;

    public SpeedelecService() {
        speedelecDao = new SpeedelecFileDao();
        speedelecInMemoryDao = new SpeedelecInMemoryDao();
    }

    @Override
    public List<Speedelec> getAll() {
        return speedelecDao.findAll();
    }

    @Override
    public Speedelec saveInMemory(Speedelec bike) {
        return speedelecInMemoryDao.save(bike);
    }

    @Override
    public Optional<Speedelec> findByBrand(String brand) {
        return speedelecDao.findByBrand(brand);
    }

    @Override
    public void saveAllFromMemory() {
        List<Speedelec> inMemory = speedelecInMemoryDao.findAll();
        speedelecDao.saveAll(inMemory);
    }
}
