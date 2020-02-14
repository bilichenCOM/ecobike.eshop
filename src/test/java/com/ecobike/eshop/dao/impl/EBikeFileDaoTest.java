package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.stub.model.EBikeStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EBikeFileDaoTest {

    private static EBikeFileDao dao;
    private static FileDeserializer deserializer;
    private static FileSerializer serializer;
    private static EBikeStub stub;

    @BeforeAll
    static void initMocks() {
        deserializer = mock(FileDeserializer.class);
        serializer = mock(FileSerializer.class);
        dao = new EBikeFileDao();
        dao.setFileDeserializer(deserializer);
        dao.setFileSerializer(serializer);
        stub = new EBikeStub();
    }

    @Test
    void findAll() {
        EBike eBike1 = stub.stub("E-spider");
        EBike eBike2 = stub.stub("Elektron");
        EBike eBike3 = stub.stub("Prototype");
        List<EBike> bikes = Arrays.asList(eBike1, eBike2, eBike3);

        when(deserializer.readList("E-BIKE", new EBikeFileDao.EBikeRowMapper()))
                .thenReturn(bikes);

        assertEquals(bikes, dao.findAll());
    }

    @Test
    void findByBrand() {
        String brand = "MountainBike";
        EBike eBike = stub.stub("MountainBike Corp.");

        when(deserializer.readObject("E-BIKE", brand, new EBikeFileDao.EBikeRowMapper()))
                .thenReturn(Optional.of(eBike));

        assertEquals(Optional.of(eBike), dao.findByBrand(brand));
    }

    @Test
    void saveAll() {
        List<EBike> bikes = Arrays.asList(stub.stub("E-spider"), stub.stub("Elektron"), stub.stub("Prototype"));

        dao.saveAll(bikes);

        verify(serializer).writeLines(bikes, new EBikeFileDao.EBikeSerializer());
    }
}