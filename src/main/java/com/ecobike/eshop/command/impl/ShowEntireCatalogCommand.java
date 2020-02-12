package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.ConsoleCommand;
import com.ecobike.eshop.service.BikeService;

import java.util.Arrays;

public class ShowEntireCatalogCommand extends ConsoleCommand {

    private BikeService[] bikeServices;

    public ShowEntireCatalogCommand(BikeService... bikeServices) {
        this.bikeServices = bikeServices;
    }

    @Override
    public void execute() {
        Arrays.stream(bikeServices)
                .flatMap(bs -> bs.getAll().stream())
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Show the entire EcoBike catalog";
    }
}
