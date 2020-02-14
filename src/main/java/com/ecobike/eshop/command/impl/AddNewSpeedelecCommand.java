package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.impl.SpeedelecService;

public class AddNewSpeedelecCommand extends AddNewBikeCommand<Speedelec> {

    public AddNewSpeedelecCommand(SpeedelecService speedelecService) {
        super(speedelecService);
    }

    @Override
    public void execute() {
        Speedelec speedelec = new Speedelec();
        initCommonFields(speedelec);
        speedelec.setMaximumSpeed(consoleHelper.readInt("maximum speed: "));
        speedelec.setBatteryCapacity(consoleHelper.readInt("battery capacity: "));
        saveInMemory(speedelec);
        printInfo();
    }

    @Override
    public String toString() {
        return "Add a new speedelec";
    }
}
