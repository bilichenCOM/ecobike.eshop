package com.ecobike.eshop.command;

import com.ecobike.eshop.helper.ConsoleReaderHelper;

public abstract class ConsoleCommand implements Command {

    protected static final ConsoleReaderHelper consoleHelper = new ConsoleReaderHelper();
}
