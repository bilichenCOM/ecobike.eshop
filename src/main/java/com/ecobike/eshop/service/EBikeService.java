package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.impl.EBikeDao;
import com.ecobike.eshop.dao.impl.EBikeFileDao;
import com.ecobike.eshop.model.EBike;

import java.util.List;

public class EBikeService implements BikeService<EBike> {

    private EBikeDao eBikeDao;

    public EBikeService() {
        this.eBikeDao = new EBikeFileDao();
    }

    @Override
    public List<EBike> getAll() {
        return eBikeDao.findAll();
    }

    @Override
    public EBike save(EBike bike) {
        return eBikeDao.save(bike);
    }


}
