package com.ecobike.eshop;

import org.junit.jupiter.api.BeforeAll;

public class EcoBikeApplicationTest {

    @BeforeAll
    static void setTestFilePath() {
        ApplicationProperties.INPUT_FILE_PATH = "test-input.txt";
        ApplicationProperties.OUTPUT_FILE_PATH = "test-output.txt";
    }
}
