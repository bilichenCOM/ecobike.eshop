package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.ConsoleCommand;
import com.ecobike.eshop.service.BikeService;

import java.util.Arrays;

public class WriteToFileCommand extends ConsoleCommand {

    private BikeService[] bikeServices;

    public WriteToFileCommand(BikeService... bikeServices) {
        this.bikeServices = bikeServices;
    }

    @Override
    public void execute() {
        Arrays.stream(bikeServices)
                .forEach(BikeService::saveAllFromMemory);
        System.out.println("successfully saved!");
    }

    @Override
    public String toString() {
        return "Write to file";
    }
}
