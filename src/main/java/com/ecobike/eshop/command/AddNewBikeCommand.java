package com.ecobike.eshop.command;

import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.model.Bike;

public abstract class AddNewBikeCommand<T extends Bike> implements Command {

    protected ConsoleReaderHelper consoleHelper;

    protected AddNewBikeCommand() {
        consoleHelper = new ConsoleReaderHelper();
    }

    protected void initCommonFields(T bike) {
        System.out.printf("Adding new %s...%s", bike.getClass().getSimpleName(), System.lineSeparator());
        System.out.println("Please fill following properties:");
        bike.setBrand(consoleHelper.readString("brand"));
        bike.setWeight(consoleHelper.readInt("weight(in grams)"));
        bike.setLightsAvailable(consoleHelper.readBoolean("front and back lights available(yes/no)"));
        bike.setColor(consoleHelper.readString("color"));
        bike.setPrice(consoleHelper.readDouble("price"));
    }
}
