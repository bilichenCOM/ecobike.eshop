package com.ecobike.eshop;

import com.ecobike.eshop.command.Command;
import com.ecobike.eshop.command.Invoker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.String.join;
import static java.lang.System.lineSeparator;

public class CLInterface implements Invoker<Integer, Command> {

    private Map<Integer, Command> commands;

    public CLInterface() {
        commands = new HashMap<>();
    }

    public Map<Integer, Command> getCommands() {
        return commands;
    }

    @Override
    public void setCommand(Integer slot, Command command) {
        commands.put(slot, command);
    }

    @Override
    public void invokeCommand(Integer key) {
        commands.get(key).execute();
    }

    public void actionWasTyped(String input) {
        if (!Pattern.matches("\\d{1,3}", input)) {
            throw new NumberFormatException("wrong, please provide number of action");
        }
        int slot = Integer.parseInt(input);
        if (!commands.containsKey(slot)) {
            throw new NumberFormatException("no such action for number " + slot);
        }
        invokeCommand(slot);
    }

    @Override
    public String toString() {
        return commands.entrySet().stream()
                .map(e -> join(" - ", e.getKey().toString(), e.getValue().toString()))
                .reduce("Please make your choice:", (c1, c2) -> join(lineSeparator(), c1, c2));
    }
}
