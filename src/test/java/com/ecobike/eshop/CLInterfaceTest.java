package com.ecobike.eshop;

import com.ecobike.eshop.command.Command;
import com.ecobike.eshop.stub.command.TestPrintHelloCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CLInterfaceTest {

    private CLInterface cli;

    @BeforeEach
    void createInstanceOfCli() {
        cli = new CLInterface();
    }

    @Test
    void setCommand() {
        Integer testSlot = 1;
        Command testCommand = new TestPrintHelloCommand();
        cli.setCommand(testSlot, testCommand);

        assertEquals(testCommand, cli.getCommands().get(testSlot));
    }

    @Test
    void invokeCommand() {
        Integer testSlot = 1;
        cli.setCommand(testSlot, new TestPrintHelloCommand());

        assertDoesNotThrow(() -> cli.invokeCommand(testSlot));
    }

    @Test
    void actionWasTyped() {
        // TODO: implement this test case;
    }

    @Test
    void testToString() {
        Integer testSlot = 1;
        TestPrintHelloCommand testCommand = new TestPrintHelloCommand();
        cli.setCommand(testSlot, testCommand);
        String expected = String
                .join(System.lineSeparator(),"Please make your choice:", "1 - " + testCommand.toString());

        assertEquals(expected, cli.toString());
    }
}