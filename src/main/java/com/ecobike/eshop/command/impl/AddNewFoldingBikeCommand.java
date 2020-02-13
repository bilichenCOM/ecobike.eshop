package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.service.impl.FoldingBikeService;

public class AddNewFoldingBikeCommand extends AddNewBikeCommand<FoldingBike> {

    public AddNewFoldingBikeCommand(FoldingBikeService foldingBikeService) {
        super(foldingBikeService);
    }

    @Override
    public void execute() {
        FoldingBike foldingBike = new FoldingBike();
        initCommonFields(foldingBike);
        foldingBike.setWheelsSize(consoleHelper.readInt("size of wheels(in inches): "));
        foldingBike.setGearsNumber(consoleHelper.readInt("number of gears: "));
        saveInMemory(foldingBike);
        printInfo();
    }

    @Override
    public String toString() {
        return "Add a new folding bike";
    }
}
