package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.model.Speedelec;
import com.ecobike.eshop.service.impl.SpeedelecService;

public class AddNewSpeedelecBikeCommand extends AddNewBikeCommand<Speedelec> {

    public AddNewSpeedelecBikeCommand(SpeedelecService speedelecService) {
        super(speedelecService);
    }

    @Override
    public void execute() {
        Speedelec speedelec = new Speedelec();
        initCommonFields(speedelec);
        speedelec.setBatteryCapacity(consoleHelper.readInt("battery capacity: "));
        speedelec.setMaximumSpeed(consoleHelper.readInt("maximum speed: "));
        saveInMemory(speedelec);
        printInfo();
    }

    @Override
    public String toString() {
        return "Add a new speedelec";
    }
}
