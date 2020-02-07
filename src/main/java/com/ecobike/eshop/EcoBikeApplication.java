package com.ecobike.eshop;

import com.ecobike.eshop.command.ShowEntireCatalogCommand;

import java.util.Scanner;

public class EcoBikeApplication {

    public static void main(String[] args) {
        new EcoBikeApplication().run();
    }

    private void run() {
        CLInterface cli = getCli();
//        List<Command> commands = CommandLineInterface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {

            }
        }
    }

    private CLInterface getCli() {
        CLInterface cli = new CLInterface();
        cli.addCommand(new ShowEntireCatalogCommand());
        //TODO: add more commands;
        return cli;
    }
}
