package com.ecobike.eshop.dao.impl;

import com.ecobike.eshop.helper.FileDeserializer;
import com.ecobike.eshop.helper.FileSerializer;
import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.stub.model.SpeedelecStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpeedelecFileDaoTest {


    private static SpeedelecFileDao dao;
    private static FileDeserializer deserializer;
    private static FileSerializer serializer;
    private static SpeedelecStub stub;

    @BeforeAll
    static void initMocks() {
        deserializer = mock(FileDeserializer.class);
        serializer = mock(FileSerializer.class);
        dao = new SpeedelecFileDao();
        dao.setFileDeserializer(deserializer);
        dao.setFileSerializer(serializer);
        stub = new SpeedelecStub();
    }

    @Test
    void findAll() {
        Speedelec speedelec1 = stub.stub("E-spider");
        Speedelec speedelec2 = stub.stub("Elektron");
        Speedelec speedelec3 = stub.stub("Prototype");
        List<Speedelec> bikes = Arrays.asList(speedelec1, speedelec2, speedelec3);

        when(deserializer.readList("E-BIKE", new SpeedelecFileDao.SpeedelecRowMapper()))
                .thenReturn(bikes);

        assertEquals(bikes, dao.findAll());
    }

    @Test
    void findByBrand() {
        String brand = "MountainBike";
        Speedelec speedelec = stub.stub("MountainBike Corp.");

        when(deserializer.readObject("E-BIKE", brand, new SpeedelecFileDao.SpeedelecRowMapper()))
                .thenReturn(Optional.of(speedelec));

        assertEquals(Optional.of(speedelec), dao.findByBrand(brand));
    }

    @Test
    void saveAll() {
        List<Speedelec> bikes = Arrays.asList(stub.stub("E-spider"), stub.stub("Elektron"), stub.stub("Prototype"));

        dao.saveAll(bikes);

        verify(serializer).writeLines(bikes, new SpeedelecFileDao.SpeedelecSerializer());
    }
}