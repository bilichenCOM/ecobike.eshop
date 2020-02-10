package com.ecobike.eshop.command;

import com.ecobike.eshop.model.FoldingBike;
import com.ecobike.eshop.service.FoldingBikeService;

public class AddNewFoldingBikeCommand extends AddNewBikeCommand<FoldingBike> {

    private FoldingBikeService foldingBikeService;

    public AddNewFoldingBikeCommand() {
        foldingBikeService = new FoldingBikeService();
    }

    @Override
    public void execute() {
        FoldingBike foldingBike = new FoldingBike();
        initCommonFields(foldingBike);
        foldingBike.setWheelsSize(consoleHelper.readInt("size of wheels(in inches)"));
        foldingBike.setGearsNumber(consoleHelper.readInt("number of gears"));
        System.out.println("New item created!");
        System.out.println("Saving...");
        foldingBikeService.save(foldingBike);
        System.out.println("Successfully saved!");
    }

    @Override
    public String toString() {
        return "Add a new folding bike";
    }
}
