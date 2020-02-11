package com.ecobike.eshop.command;

import com.ecobike.eshop.service.BikeService;

public class FindFirstItemCommand implements Command {

    public FindFirstItemCommand(BikeService... bikeServices) {
    }

    @Override
    public void execute() {
        // TODO: implement search method;
    }

    @Override
    public String toString() {
        return "Find first item of a particular brand";
    }
}
