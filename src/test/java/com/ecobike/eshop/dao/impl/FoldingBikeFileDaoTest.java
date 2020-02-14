package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.stub.model.FoldingBikeStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FoldingBikeFileDaoTest {

    private static FoldingBikeFileDao dao;
    private static FileDeserializer deserializer;
    private static FileSerializer serializer;
    private static FoldingBikeStub stub;

    @BeforeAll
    static void initMocks() {
        deserializer = mock(FileDeserializer.class);
        serializer = mock(FileSerializer.class);
        dao = new FoldingBikeFileDao();
        dao.setFileDeserializer(deserializer);
        dao.setFileSerializer(serializer);
        stub = new FoldingBikeStub();
    }

    @Test
    void findAll() {
        FoldingBike foldingBike1 = stub.stub("E-spider");
        FoldingBike foldingBike2 = stub.stub("Elektron");
        FoldingBike foldingBike3 = stub.stub("Prototype");
        List<FoldingBike> bikes = Arrays.asList(foldingBike1, foldingBike2, foldingBike3);

        when(deserializer.readList("E-BIKE", new FoldingBikeFileDao.FoldingBikeRowMapper()))
                .thenReturn(bikes);

        assertEquals(bikes, dao.findAll());
    }

    @Test
    void findByBrand() {
        String brand = "MountainBike";
        FoldingBike foldingBike = stub.stub("MountainBike Corp.");

        when(deserializer.readObject("E-BIKE", brand, new FoldingBikeFileDao.FoldingBikeRowMapper()))
                .thenReturn(Optional.of(foldingBike));

        assertEquals(Optional.of(foldingBike), dao.findByBrand(brand));
    }

    @Test
    void saveAll() {
        List<FoldingBike> bikes = Arrays.asList(stub.stub("E-spider"), stub.stub("Elektron"), stub.stub("Prototype"));

        dao.saveAll(bikes);

        verify(serializer).writeLines(bikes, new FoldingBikeFileDao.FoldingBikeSerializer());
    }
}