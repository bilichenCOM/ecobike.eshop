package com.ecobike.eshop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.ecobike.eshop.ApplicationProperties.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationPropertiesTest {

    @Test
    void parse_validParams_assignedToFields() {
        String inputPath = "test.txt";
        String outputPath = "test-output.txt";
        List<String> params = Arrays.asList("--input=".concat(inputPath), "--output=".concat(outputPath));

        parse(params);

        assertEquals(inputPath, INPUT_FILE_PATH);
        assertEquals(outputPath, OUTPUT_FILE_PATH);
    }

    @Test
    void parse_notValidParams_defaultValueRemained() {
        String param1 = "-in=test.txt";
        String param2 = "-out=test-out.txt";
        String inputBefore = INPUT_FILE_PATH;
        String outputBefore = OUTPUT_FILE_PATH;

        parse(Arrays.asList(param1, param2));

        assertEquals(inputBefore, INPUT_FILE_PATH);
        assertEquals(outputBefore, OUTPUT_FILE_PATH);
    }
}