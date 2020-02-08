package com.ecobike.eshop;

import com.ecobike.eshop.command.*;
import com.ecobike.eshop.dao.EBikeDao;
import com.ecobike.eshop.service.BikeService;
import com.ecobike.eshop.service.EBikeService;
import com.ecobike.eshop.service.FoldingBikeService;
import com.ecobike.eshop.service.SpeedelecService;

import java.util.Scanner;

public class EcoBikeApplication {

    private static String outputFileName = "output.txt";

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
            }
        }
    }

    private CLInterface getCli() {
        CLInterface cli = new CLInterface();

        BikeService foldingBikeService = new FoldingBikeService();
        BikeService speedelecService = new SpeedelecService();
        BikeService eBikeService = new EBikeService(new EBikeDao());

        cli.setCommand(1, new ShowEntireCatalogCommand(foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(2, new AddNewBikeCommand(foldingBikeService));
        cli.setCommand(3, new AddNewBikeCommand(speedelecService));
        cli.setCommand(4, new AddNewBikeCommand(eBikeService));
        cli.setCommand(5, new FindFirstItemCommand(foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(6, new WriteToFileCommand(outputFileName, foldingBikeService, speedelecService, eBikeService));
        cli.setCommand(7, new StopApplicationCommand());

        return cli;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            outputFileName = args[0];
        }
        new EcoBikeApplication().run();
    }
}
