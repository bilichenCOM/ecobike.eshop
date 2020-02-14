package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.impl.EBikeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AddNewEBikeCommandTest {

    private static AddNewEBikeCommand command;
    private static EBikeService service;
    private static ConsoleReaderHelper consoleHelper;

    @BeforeAll
    static void initMocks() {
        service = mock(EBikeService.class);
        consoleHelper = mock(ConsoleReaderHelper.class);
        command = new AddNewEBikeCommand(service);
        command.setConsoleHelper(consoleHelper);
    }

    @Test
    void execute() {
        String brand = "Electronix";
        Integer maxSpeed = 40;
        Integer weight = 18500;
        Integer battCapacity = 16000;
        Boolean lightsAvailable = true;
        String color = "black";
        Integer price = 430;

        EBike eBike = new EBike();
        eBike.setBrand(brand);
        eBike.setMaximumSpeed(maxSpeed);
        eBike.setWeight(weight);
        eBike.setBatteryCapacity(battCapacity);
        eBike.setLightsAvailable(lightsAvailable);
        eBike.setColor(color);
        eBike.setPrice(price);

        when(consoleHelper.readString("brand: ")).thenReturn(brand);
        when(consoleHelper.readInt("maximum speed: ")).thenReturn(maxSpeed);
        when(consoleHelper.readInt("weight(in grams): ")).thenReturn(weight);
        when(consoleHelper.readInt("battery capacity(in mAh): ")).thenReturn(battCapacity);
        when(consoleHelper.readBoolean("front and back lights available(yes/no): ")).thenReturn(lightsAvailable);
        when(consoleHelper.readString("color: ")).thenReturn(color);
        when(consoleHelper.readInt("price: ")).thenReturn(price);

        command.execute();

        verify(service).saveInMemory(eBike);
    }
}