package com.ecobike.eshop.command;

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
