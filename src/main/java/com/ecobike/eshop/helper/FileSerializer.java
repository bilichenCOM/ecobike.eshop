package com.ecobike.eshop.helper;

import com.ecobike.eshop.ApplicationProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;

public class FileSerializer {

    private String filePath;

    public FileSerializer() {
        filePath = ApplicationProperties.OUTPUT_FILE_PATH;
    }

    public <T> void writeLines(List<T> list, Serializer<T> serializer) {
        List<String> lines = list.stream()
                .map(serializer::serializeToString)
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(filePath), lines, CREATE, WRITE, APPEND);
        } catch (IOException e) {
            System.err.println("FileSerializer: cannot save data to file");
        }
    }

    public interface Serializer<T> {
        String DEFAULT_DELIMITER = "; ";

        String serializeToString(T t);
    }
}
