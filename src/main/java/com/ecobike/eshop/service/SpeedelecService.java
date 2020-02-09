package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.impl.SpeedelecDao;
import com.ecobike.eshop.dao.impl.SpeedelecFileDao;
import com.ecobike.eshop.model.Speedelec;

import java.util.List;

public class SpeedelecService implements BikeService<Speedelec> {

    private SpeedelecDao speedelecDao;

    public SpeedelecService() {
        speedelecDao = new SpeedelecFileDao();
    }

    @Override
    public List<Speedelec> getAll() {
        return speedelecDao.findAll();
    }

    @Override
    public Speedelec save(Speedelec bike) {
        return null;
    }
}
