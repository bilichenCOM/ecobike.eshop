package com.ecobike.eshop;

import com.ecobike.eshop.command.ConsoleCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class CLInterfaceTest {

    private CLInterface cli;

    @BeforeEach
    void createInstanceOfCli() {
        cli = new CLInterface();
    }

    @Test
    void setCommand() {
        Integer testSlot = 1;
        ConsoleCommand testCommand = mock(ConsoleCommand.class);

        cli.setCommand(testSlot, testCommand);

        assertEquals(testCommand, cli.getCommands().get(testSlot));
    }

    @Test
    void invokeCommand_existsInCommandMap_invokesCommand() {
        Integer testSlot = 1;
        ConsoleCommand testCommand = mock(ConsoleCommand.class);
        cli.getCommands().put(testSlot, testCommand);

        cli.invokeCommand(testSlot);

        verify(testCommand).execute();
    }

    @Test
    void actionWasTyped_existingSlot_invokesCommand() {
        Integer slot = 1;
        ConsoleCommand testCommand = mock(ConsoleCommand.class);
        cli.getCommands().put(slot, testCommand);

        cli.actionWasTyped(slot);

        verify(testCommand).execute();
    }

    @Test
    void actionWasTyped_notExistingSlot_doesNothing() {
        Integer slot = 1;
        ConsoleCommand testCommand = mock(ConsoleCommand.class);
        cli.getCommands().put(slot + 1, testCommand);

        cli.actionWasTyped(slot);

        verify(testCommand, never()).execute();
    }

    @Test
    void testToString() {
        Integer testSlot = 1;
        ConsoleCommand testCommand = mock(ConsoleCommand.class);
        cli.getCommands().put(testSlot, testCommand);

        when(testCommand.toString()).thenReturn("Mock command does nothing useful.");

        String expected = String
                .join(System.lineSeparator(),"Please make your choice:", "1 - Mock command does nothing useful.");

        assertEquals(expected, cli.toString());
    }
}