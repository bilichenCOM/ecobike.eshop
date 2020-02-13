package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.FoldingBikeFileDao;
import com.ecobike.eshop.dao.impl.FoldingBikeInMemoryDao;
import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.service.BikeService;

public class FoldingBikeService extends BikeService<FoldingBike> {

    public FoldingBikeService() {
        super(new FoldingBikeFileDao(), new FoldingBikeInMemoryDao());
    }
}
