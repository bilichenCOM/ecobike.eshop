package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.EBikeFileDao;
import com.ecobike.eshop.dao.impl.EBikeInMemoryDao;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.BikeService;

public class EBikeService extends BikeService<EBike> {

    public EBikeService() {
        super(new EBikeFileDao(), new EBikeInMemoryDao());
    }
}
