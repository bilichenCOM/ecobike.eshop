package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.impl.EBikeDao;
import com.ecobike.eshop.model.EBike;

import java.util.List;

public class EBikeService implements BikeService {

    private EBikeDao eBikeDao;

    public EBikeService(EBikeDao eBikeDao) {
        this.eBikeDao = eBikeDao;
    }

    @Override
    public List<EBike> getAll() {
        return eBikeDao.findAll();
    }
}
