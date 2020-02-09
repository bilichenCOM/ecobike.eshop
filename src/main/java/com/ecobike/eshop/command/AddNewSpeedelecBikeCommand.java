package com.ecobike.eshop.command;

import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.SpeedelecService;

public class AddNewSpeedelecBikeCommand extends AddNewBikeCommand<Speedelec> {

    private SpeedelecService speedelecService;

    public AddNewSpeedelecBikeCommand() {
        speedelecService = new SpeedelecService();
    }

    @Override
    public void execute() {
        Speedelec speedelec = new Speedelec();
        initCommonFields(speedelec);
        speedelec.setBatteryCapacity(consoleHelper.readInt("battery capacity"));
        speedelec.setMaximumSpeed(consoleHelper.readInt("maximum speed"));
        System.out.println("New item created");
        System.out.println("Saving...");
        speedelecService.save(speedelec);
        System.out.println("Successfully saved!");
    }

    @Override
    public String toString() {
        return "Add a new speedelec";
    }
}
