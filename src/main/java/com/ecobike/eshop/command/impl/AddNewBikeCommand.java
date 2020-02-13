package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.ConsoleCommand;
import com.ecobike.eshop.model.Bike;
import com.ecobike.eshop.service.BikeService;

public abstract class AddNewBikeCommand<T extends Bike> extends ConsoleCommand {

    protected final BikeService<T> bikeService;

    protected AddNewBikeCommand(BikeService<T> bikeService) {
        this.bikeService = bikeService;
    }

    protected void initCommonFields(T bike) {
        System.out.printf("Adding new %s...%s", bike.getClass().getSimpleName(), System.lineSeparator());
        System.out.println("Please fill following properties:");
        bike.setBrand(consoleHelper.readString("brand: "));
        bike.setWeight(consoleHelper.readInt("weight(in grams): "));
        bike.setLightsAvailable(consoleHelper.readBoolean("front and back lights available(yes/no): "));
        bike.setColor(consoleHelper.readString("color: "));
        bike.setPrice(consoleHelper.readInt("price: "));
    }

    protected T saveInMemory(T bike) {
        return bikeService.saveInMemory(bike);
    }

    protected void printInfo() {
        System.out.println("New item was created!");;
        System.out.println("Write to file for saving");
    }
}
