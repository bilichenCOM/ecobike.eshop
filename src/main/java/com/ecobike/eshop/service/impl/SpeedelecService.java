package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.SpeedelecFileDao;
import com.ecobike.eshop.dao.impl.SpeedelecInMemoryDao;
import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.BikeService;

public class SpeedelecService extends BikeService<Speedelec> {

    public SpeedelecService() {
        super(new SpeedelecFileDao(), new SpeedelecInMemoryDao());
    }
}
