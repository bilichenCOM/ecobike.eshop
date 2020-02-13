package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.impl.EBikeService;

public class AddNewEBikeCommand extends AddNewBikeCommand<EBike> {

    public AddNewEBikeCommand(EBikeService eBikeService) {
        super(eBikeService);
    }

    @Override
    public void execute() {
        EBike eBike = new EBike();
        initCommonFields(eBike);
        eBike.setMaximumSpeed(consoleHelper.readInt("maximum speed: "));
        eBike.setBatteryCapacity(consoleHelper.readInt("battery capacity(in mAh): "));
        saveInMemory(eBike);
        printInfo();
    }

    @Override
    public String toString() {
        return "Add a new e-bike";
    }
}
