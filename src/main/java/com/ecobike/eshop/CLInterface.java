package com.ecobike.eshop;

import com.ecobike.eshop.command.Command;

import java.util.ArrayList;
import java.util.List;

public class CLInterface {

    private List<Command> commands;

    public CLInterface() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }
}
