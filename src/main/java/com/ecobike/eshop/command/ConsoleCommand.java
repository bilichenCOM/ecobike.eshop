package com.ecobike.eshop.command;

import com.ecobike.eshop.helper.ConsoleReaderHelper;

public abstract class ConsoleCommand implements Command {

    protected static ConsoleReaderHelper consoleHelper = new ConsoleReaderHelper();

    public void setConsoleHelper(ConsoleReaderHelper consoleHelper) {
        ConsoleCommand.consoleHelper = consoleHelper;
    }
}
