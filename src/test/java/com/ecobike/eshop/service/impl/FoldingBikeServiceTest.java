package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.FoldingBikeFileDao;
import com.ecobike.eshop.dao.impl.FoldingBikeInMemoryDao;
import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.stub.model.FoldingBikeStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FoldingBikeServiceTest {

    private static FoldingBikeService service;
    private static FoldingBikeFileDao fileDao;
    private static FoldingBikeInMemoryDao inMemoryDao;
    private static FoldingBikeStub stub;

    @BeforeAll
    static void initMocks() {
        fileDao = mock(FoldingBikeFileDao.class);
        inMemoryDao = mock(FoldingBikeInMemoryDao.class);
        service = new FoldingBikeService(fileDao, inMemoryDao);
        stub = new FoldingBikeStub();
    }

    @Test
    void getAll() {
        FoldingBike foldingBike1 = stub.stub("Elektron");
        FoldingBike foldingBike2 = stub.stub("AccumBike");
        FoldingBike foldingBike3 = stub.stub("Thunder");

        List<FoldingBike> foldingBikes = Arrays.asList(foldingBike1, foldingBike2, foldingBike3);
        when(fileDao.findAll()).thenReturn(foldingBikes);

        assertEquals(foldingBikes, service.getAll());
    }

    @Test
    void saveInMemory() {
        FoldingBike foldingBike = stub.stub("Elektron");

        when(inMemoryDao.save(foldingBike)).thenReturn(foldingBike);

        assertEquals(foldingBike, service.saveInMemory(foldingBike));
    }

    @Test
    void findByBrand() {
        String brand = "under";
        FoldingBike foldingBike = stub.stub("Thunder");

        when(fileDao.findByBrand(brand)).thenReturn(Optional.of(foldingBike));

        assertEquals(Optional.of(foldingBike), service.findByBrand(brand));
    }

    @Test
    void saveAllFromMemory() {
        FoldingBike foldingBike1 = stub.stub("Elektron");
        FoldingBike foldingBike2 = stub.stub("AccumBike");
        FoldingBike foldingBike3 = stub.stub("Thunder");
        List<FoldingBike> foldingBikes = Arrays.asList(foldingBike1, foldingBike2, foldingBike3);
        when(inMemoryDao.findAll()).thenReturn(foldingBikes);

        service.saveAllFromMemory();

        verify(fileDao).saveAll(foldingBikes);
    }
}