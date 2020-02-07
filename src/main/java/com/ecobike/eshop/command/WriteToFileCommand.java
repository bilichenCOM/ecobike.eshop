package com.ecobike.eshop.command;

import com.ecobike.eshop.service.BikeService;

public class WriteToFileCommand implements Command {

    public WriteToFileCommand(String fileName, BikeService... bikeServices) {
    }

    @Override
    public void execute() {

    }
}
