package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.impl.SpeedelecService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AddNewSpeedelecBikeCommandTest {

    private static AddNewSpeedelecCommand command;
    private static SpeedelecService service;
    private static ConsoleReaderHelper consoleHelper;

    @BeforeAll
    static void initMocks() {
        service = mock(SpeedelecService.class);
        consoleHelper = mock(ConsoleReaderHelper.class);
        command = new AddNewSpeedelecCommand(service);
        command.setConsoleHelper(consoleHelper);
    }

    @Test
    void execute() {
        String brand = "JetBike";
        Integer maxSpeed = 35;
        Integer weight = 18500;
        Boolean lightsAvailable = true;
        Integer battCapacity = 19500;
        String color = "black";
        Integer price = 430;

        Speedelec speedelec = new Speedelec();
        speedelec.setBrand(brand);
        speedelec.setMaximumSpeed(maxSpeed);
        speedelec.setWeight(weight);
        speedelec.setLightsAvailable(lightsAvailable);
        speedelec.setBatteryCapacity(battCapacity);
        speedelec.setColor(color);
        speedelec.setPrice(price);

        when(consoleHelper.readString("brand: ")).thenReturn(brand);
        when(consoleHelper.readInt("maximum speed: ")).thenReturn(maxSpeed);
        when(consoleHelper.readInt("weight(in grams): ")).thenReturn(weight);
        when(consoleHelper.readBoolean("front and back lights available(yes/no): ")).thenReturn(lightsAvailable);
        when(consoleHelper.readInt("battery capacity: ")).thenReturn(battCapacity);
        when(consoleHelper.readString("color: ")).thenReturn(color);
        when(consoleHelper.readInt("price: ")).thenReturn(price);

        command.execute();

        verify(service).saveInMemory(speedelec);
    }
}