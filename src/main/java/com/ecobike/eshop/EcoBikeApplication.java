package com.ecobike.eshop;

import com.ecobike.eshop.command.*;
import com.ecobike.eshop.service.BikeService;
import com.ecobike.eshop.service.EBikeService;
import com.ecobike.eshop.service.FoldingBikeService;
import com.ecobike.eshop.service.SpeedelecService;

import java.util.Arrays;
import java.util.Scanner;

public class EcoBikeApplication {

    private void run() {
        CLInterface cli = getCli();
        System.out.println(cli);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String slot = scanner.next();
                try {
                    cli.actionWasTyped(slot);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(cli);
            }
        }
    }

    private CLInterface getCli() {
        CLInterface cli = new CLInterface();

        BikeService foldingBikeService = new FoldingBikeService();
        BikeService speedelecService = new SpeedelecService();
        BikeService eBikeService = new EBikeService();

        cli.setCommand(1, new ShowEntireCatalogCommand(foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(2, new AddNewFoldingBikeCommand());
        cli.setCommand(3, new AddNewSpeedelecBikeCommand());
        cli.setCommand(4, new AddNewEBikeCommand());
        cli.setCommand(5, new FindFirstItemCommand(foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(6, new WriteToFileCommand(foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(7, new StopApplicationCommand());

        return cli;
    }

    public static void main(String[] args) {
        ApplicationProperties.parse(Arrays.asList(args));
        new EcoBikeApplication().run();
    }
}
