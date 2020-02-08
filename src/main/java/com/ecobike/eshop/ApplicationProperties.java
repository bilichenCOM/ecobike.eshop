package com.ecobike.eshop;

import java.util.List;

public class ApplicationProperties {

    private static final String INPUT_FILE_PATH_PARAM = "--input=";
    private static final String OUTPUT_FILE_PATH_PARAM = "--output=";

    public static String INPUT_FILE_PATH = "bikes.txt";
    public static String OUTPUT_FILE_PATH = "output.txt";

    private ApplicationProperties() {
    }

    public static void parse(List<String> commandLineInput) {
        for (String param:commandLineInput) {
            if (param.startsWith(INPUT_FILE_PATH_PARAM)) {
                INPUT_FILE_PATH = param.replace(INPUT_FILE_PATH_PARAM, "");
            }
            if (param.startsWith(OUTPUT_FILE_PATH_PARAM)) {
                OUTPUT_FILE_PATH = param.replace(OUTPUT_FILE_PATH_PARAM, "");
            }
        }
    }
}
