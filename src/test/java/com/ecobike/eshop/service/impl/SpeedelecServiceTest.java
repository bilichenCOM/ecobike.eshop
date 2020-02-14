package com.ecobike.eshop.service.impl;

import com.ecobike.eshop.dao.impl.SpeedelecFileDao;
import com.ecobike.eshop.dao.impl.SpeedelecInMemoryDao;
import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.stub.model.SpeedelecStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpeedelecServiceTest {

    private static SpeedelecService service;
    private static SpeedelecFileDao fileDao;
    private static SpeedelecInMemoryDao inMemoryDao;
    private static SpeedelecStub stub;

    @BeforeAll
    static void initMocks() {
        fileDao = mock(SpeedelecFileDao.class);
        inMemoryDao = mock(SpeedelecInMemoryDao.class);
        service = new SpeedelecService(fileDao, inMemoryDao);
        stub = new SpeedelecStub();
    }

    @Test
    void getAll() {
        Speedelec speedelec1 = stub.stub("Elektron");
        Speedelec speedelec2 = stub.stub("AccumBike");
        Speedelec speedelec3 = stub.stub("Thunder");

        List<Speedelec> speedelecs = Arrays.asList(speedelec1, speedelec2, speedelec3);
        when(fileDao.findAll()).thenReturn(speedelecs);

        assertEquals(speedelecs, service.getAll());
    }

    @Test
    void saveInMemory() {
        Speedelec speedelec = stub.stub("Elektron");

        when(inMemoryDao.save(speedelec)).thenReturn(speedelec);

        assertEquals(speedelec, service.saveInMemory(speedelec));
    }

    @Test
    void findByBrand() {
        String brand = "under";
        Speedelec speedelec = stub.stub("Thunder");

        when(fileDao.findByBrand(brand)).thenReturn(Optional.of(speedelec));

        assertEquals(Optional.of(speedelec), service.findByBrand(brand));
    }

    @Test
    void saveAllFromMemory() {
        Speedelec speedelec1 = stub.stub("Elektron");
        Speedelec speedelec2 = stub.stub("AccumBike");
        Speedelec speedelec3 = stub.stub("Thunder");
        List<Speedelec> speedelecs = Arrays.asList(speedelec1, speedelec2, speedelec3);
        when(inMemoryDao.findAll()).thenReturn(speedelecs);

        service.saveAllFromMemory();

        verify(fileDao).saveAll(speedelecs);
    }
}