package com.ecobike.eshop.command;

import com.ecobike.eshop.model.EBike;
import com.ecobike.eshop.service.EBikeService;

public class AddNewEBikeCommand extends AddNewBikeCommand<EBike> {

    private EBikeService eBikeService;

    public AddNewEBikeCommand() {
        eBikeService = new EBikeService();
    }

    @Override
    public void execute() {
        EBike eBike = new EBike();
        initCommonFields(eBike);
        eBike.setMaximumSpeed(consoleHelper.readInt("maximum speed"));
        eBike.setBatteryCapacity(consoleHelper.readInt("battery capacity(in mAh)"));
        System.out.println("New item was created");
        System.out.println("Saving...");
        eBikeService.save(eBike);
        System.out.println("Successfully saved!");
    }

    @Override
    public String toString() {
        return "Add a new e-bike";
    }
}
