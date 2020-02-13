package com.ecobike.eshop.service;

import com.ecobike.eshop.EcoBikeApplicationTest;
import com.ecobike.eshop.dao.impl.EBikeInMemoryDao;
import com.ecobike.eshop.service.impl.EBikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EBikeServiceTest extends EcoBikeApplicationTest {

    private EBikeService eBikeService;
    private EBikeInMemoryDao eBikeDao;

    public EBikeServiceTest() {
        eBikeDao = new EBikeInMemoryDao();
        eBikeService = new EBikeService();
    }

    @BeforeEach
    void cleanInMemoryDb() {
        eBikeDao.deleteAll();
    }

    @Test
    void getAll() {

    }
}