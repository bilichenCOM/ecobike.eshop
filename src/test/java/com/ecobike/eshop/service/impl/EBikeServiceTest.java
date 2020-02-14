package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.EBikeFileDao;
import com.ecobike.eshop.dao.impl.EBikeInMemoryDao;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.stub.model.EBikeStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EBikeServiceTest {

    private static EBikeService service;
    private static EBikeFileDao fileDao;
    private static EBikeInMemoryDao inMemoryDao;
    private static EBikeStub stub;

    @BeforeAll
    static void initMocks() {
        fileDao = mock(EBikeFileDao.class);
        inMemoryDao = mock(EBikeInMemoryDao.class);
        service = new EBikeService(fileDao, inMemoryDao);
        stub = new EBikeStub();
    }

    @Test
    void getAll() {
        EBike eBike1 = stub.stub("Elektron");
        EBike eBike2 = stub.stub("AccumBike");
        EBike eBike3 = stub.stub("Thunder");

        List<EBike> eBikes = Arrays.asList(eBike1, eBike2, eBike3);
        when(fileDao.findAll()).thenReturn(eBikes);

        assertEquals(eBikes, service.getAll());
    }

    @Test
    void saveInMemory() {
        EBike eBike = stub.stub("Elektron");

        when(inMemoryDao.save(eBike)).thenReturn(eBike);

        assertEquals(eBike, service.saveInMemory(eBike));
    }

    @Test
    void findByBrand() {
        String brand = "under";
        EBike eBike = stub.stub("Thunder");

        when(fileDao.findByBrand(brand)).thenReturn(Optional.of(eBike));

        assertEquals(Optional.of(eBike), service.findByBrand(brand));
    }

    @Test
    void saveAllFromMemory() {
        EBike eBike1 = stub.stub("Elektron");
        EBike eBike2 = stub.stub("AccumBike");
        EBike eBike3 = stub.stub("Thunder");
        List<EBike> eBikes = Arrays.asList(eBike1, eBike2, eBike3);
        when(inMemoryDao.findAll()).thenReturn(eBikes);

        service.saveAllFromMemory();

        verify(fileDao).saveAll(eBikes);
    }
}