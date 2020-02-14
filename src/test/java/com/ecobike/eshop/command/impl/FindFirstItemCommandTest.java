package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.model.Bike;
import com.ecobike.eshop.service.BikeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class FindFirstItemCommandTest {

    private static FindFirstItemCommand command;
    private static BikeService[] services;
    private static ConsoleReaderHelper consoleHelper;

    @BeforeAll
    static void initMocks() {
        services = new BikeService[] { mock(BikeService.class), mock(BikeService.class), mock(BikeService.class) };
        consoleHelper = mock(ConsoleReaderHelper.class);
        command = new FindFirstItemCommand(services);
        command.setConsoleHelper(consoleHelper);
    }

    @Test
    void execute() {
        String brand = "Rocket";
        Bike bike = mock(Bike.class);
        bike.setBrand(brand);
        Optional<Bike> optionalBike = Optional.of(bike);

        when(consoleHelper.readString("search for a brand: ")).thenReturn(brand);
        when(services[0].findByBrand(brand)).thenReturn(optionalBike);

        command.execute();

        verify(services[0]).findByBrand(brand);
        verify(services[1], never()).findByBrand(anyString());
        verify(services[2], never()).findByBrand(anyString());
    }
}