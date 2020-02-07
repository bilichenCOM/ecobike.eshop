package com.ecobike.eshop.stub;

import com.ecobike.eshop.command.Command;

public class TestPrintHelloCommand implements Command {

    @Override
    public void execute() {
        System.out.println("hello!");
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TestPrintHelloCommand;
    }

    @Override
    public String toString() {
        return "Test Print Hello";
    }
}
