package com.ecobike.eshop.command;

import com.ecobike.eshop.service.BikeService;

public class WriteToFileCommand implements Command {

    public WriteToFileCommand(BikeService... bikeServices) {
    }

    @Override
    public void execute() {

    }

    @Override
    public String toString() {
        return "Write to file";
    }
}
