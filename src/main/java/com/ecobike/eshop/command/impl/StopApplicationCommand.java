package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.Command;

public class StopApplicationCommand implements Command {
    @Override
    public void execute() {
        System.out.println("stopping the application");
    }

    @Override
    public String toString() {
        return "Stop the program";
    }
}
