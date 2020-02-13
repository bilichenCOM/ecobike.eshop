package com.ecobike.eshop.command.impl;

import com.ecobike.eshop.command.ConsoleCommand;

public class StopApplicationCommand extends ConsoleCommand {

    @Override
    public void execute() {
        System.out.println("stopping the application");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Stop the program";
    }
}
