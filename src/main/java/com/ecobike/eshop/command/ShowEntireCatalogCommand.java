package com.ecobike.eshop.command;

import com.ecobike.eshop.service.BikeService;

import java.util.Arrays;

public class ShowEntireCatalogCommand implements Command {

    private BikeService[] bikeServices;

    public ShowEntireCatalogCommand(BikeService... bikeServices) {
        this.bikeServices = bikeServices;
    }

    @Override
    public void execute() {
        Arrays.stream(bikeServices)
                .map(bs -> bs.getAll())
                .forEach(System.out::println);
    }
}
