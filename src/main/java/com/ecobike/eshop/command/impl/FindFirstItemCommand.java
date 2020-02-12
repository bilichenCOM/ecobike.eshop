package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.ConsoleCommand;
import com.ecobike.eshop.model.Bike;
import com.ecobike.eshop.service.BikeService;

import java.util.Arrays;
import java.util.Optional;

public class FindFirstItemCommand extends ConsoleCommand {

    private BikeService[] bikeServices;

    public FindFirstItemCommand(BikeService... bikeServices) {
        this.bikeServices = bikeServices;
    }

    @Override
    public void execute() {
        String keyWord = consoleHelper.readString("search for a brand:");
        Optional<Bike> foundResult = Arrays.stream(bikeServices)
                .map(bs -> bs.findByBrand(keyWord))
                .filter(Optional::isPresent)
                .findFirst().get();
        if (foundResult.isPresent()) {
            System.out.println(foundResult.get());
        } else {
            System.out.printf("items with brand %s were not found", keyWord);
        }
    }

    @Override
    public String toString() {
        return "Find first item of a particular brand";
    }
}
