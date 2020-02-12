package com.ecobike.eshop;

import com.ecobike.eshop.command.impl.*;
import com.ecobike.eshop.helper.ConsoleReaderHelper;
import com.ecobike.eshop.service.BikeService;
import com.ecobike.eshop.service.impl.EBikeService;
import com.ecobike.eshop.service.impl.FoldingBikeService;
import com.ecobike.eshop.service.impl.SpeedelecService;

import java.util.Arrays;

public class EcoBikeApplication {

    private void run() {
        CLInterface cli = getCli();
        ConsoleReaderHelper consoleReaderHelper = new ConsoleReaderHelper();
        while (true) {
            System.out.println(cli);
            Integer slot = consoleReaderHelper.readInt("");
            cli.actionWasTyped(slot);
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
