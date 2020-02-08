package com.ecobike.eshop.command;

import com.ecobike.eshop.service.FoldingBikeService;

public class AddNewFoldingBikeCommand implements Command {

    private FoldingBikeService foldingBikeService;

    public AddNewFoldingBikeCommand() {
        foldingBikeService = new FoldingBikeService();
    }

    @Override
    public void execute() {

    }

    @Override
    public String toString() {
        return "Add a new folding bike";
    }
}
