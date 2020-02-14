package com.ecobike.eshop;

import com.ecobike.eshop.command.ConsoleCommand;
import com.ecobike.eshop.command.Invoker;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.join;
import static java.lang.System.lineSeparator;

public class CLInterface implements Invoker<Integer, ConsoleCommand> {

    private Map<Integer, ConsoleCommand> commands;

    public CLInterface() {
        commands = new HashMap<>();
    }

    public Map<Integer, ConsoleCommand> getCommands() {
        return commands;
    }

    @Override
    public void setCommand(Integer slot, ConsoleCommand command) {
        commands.put(slot, command);
    }

    @Override
    public void invokeCommand(Integer key) {
        commands.get(key).execute();
    }

    public void actionWasTyped(Integer input) {
        if (!commands.containsKey(input)) {
            System.err.println("no such action for number " + input);
            return;
        }
        invokeCommand(input);
    }

    @Override
    public String toString() {
        return commands.entrySet().stream()
                .map(e -> join(" - ", e.getKey().toString(), e.getValue().toString()))
                .reduce("Please make your choice:", (c1, c2) -> join(lineSeparator(), c1, c2));
    }
}
