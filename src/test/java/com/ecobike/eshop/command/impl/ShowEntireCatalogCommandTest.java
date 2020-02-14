package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.service.BikeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ShowEntireCatalogCommandTest {

    private static ShowEntireCatalogCommand command;
    private static BikeService[] services;

    @BeforeAll
    static void initMocks() {
        services = new BikeService[] { mock(BikeService.class), mock(BikeService.class), mock(BikeService.class) };
        command = new ShowEntireCatalogCommand(services);
    }

    @Test
    void execute() {
        command.execute();

        Arrays.stream(services)
                .forEach(s -> verify(s).getAll());
    }
}