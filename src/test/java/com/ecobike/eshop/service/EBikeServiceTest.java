package com.ecobike.eshop.service;

import com.ecobike.eshop.dao.impl.EBikeInMemoryDao;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.impl.EBikeService;
import com.ecobike.eshop.stub.model.EBikeStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EBikeServiceTest {

    private EBikeService eBikeService;
    private EBikeInMemoryDao eBikeDao;
    private EBikeStub ebikeStub;

    public EBikeServiceTest() {
        eBikeDao = new EBikeInMemoryDao();
        eBikeService = new EBikeService();
        ebikeStub = new EBikeStub();
    }

    @BeforeEach
    void cleanInMemoryDb() {
        eBikeDao.deleteAll();
    }

    @Test
    void getAll() {
        EBike eBike1 = ebikeStub.stub("Peugeot");
        EBike eBike2 = ebikeStub.stub("Brompton");

        eBikeDao.save(eBike1);
        eBikeDao.save(eBike2);

        Assertions.assertEquals(Arrays.asList(eBike1, eBike2), eBikeService.getAll());
    }
}