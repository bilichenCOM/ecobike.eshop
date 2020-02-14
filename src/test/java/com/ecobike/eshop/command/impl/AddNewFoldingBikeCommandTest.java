package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.service.impl.FoldingBikeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AddNewFoldingBikeCommandTest {


    private static AddNewFoldingBikeCommand command;
    private static FoldingBikeService service;
    private static ConsoleReaderHelper consoleHelper;

    @BeforeAll
    static void initMocks() {
        service = mock(FoldingBikeService.class);
        consoleHelper = mock(ConsoleReaderHelper.class);
        command = new AddNewFoldingBikeCommand(service);
        command.setConsoleHelper(consoleHelper);
    }

    @Test
    void execute() {
        String brand = "MountainBike";
        Integer weight = 18500;
        Integer gearsNumber = 7;
        Integer wheelsSize = 24;
        Boolean lightsAvailable = true;
        String color = "black";
        Integer price = 430;

        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(brand);
        foldingBike.setWheelsSize(wheelsSize);
        foldingBike.setGearsNumber(gearsNumber);
        foldingBike.setWeight(weight);
        foldingBike.setLightsAvailable(lightsAvailable);
        foldingBike.setColor(color);
        foldingBike.setPrice(price);

        when(consoleHelper.readString("brand: ")).thenReturn(brand);
        when(consoleHelper.readInt("size of wheels(in inches): ")).thenReturn(wheelsSize);
        when(consoleHelper.readInt("number of gears: ")).thenReturn(gearsNumber);
        when(consoleHelper.readInt("weight(in grams): ")).thenReturn(weight);
        when(consoleHelper.readBoolean("front and back lights available(yes/no): ")).thenReturn(lightsAvailable);
        when(consoleHelper.readString("color: ")).thenReturn(color);
        when(consoleHelper.readInt("price: ")).thenReturn(price);

        command.execute();

        verify(service).saveInMemory(foldingBike);
    }
}