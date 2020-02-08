package com.ecobike.eshop.helper;

import com.ecobike.eshop.ApplicationProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileDeserializer {

    private String filePath;

    public  FileDeserializer() {
        filePath = ApplicationProperties.INPUT_FILE_PATH;
    }

    public <T> List<T> readList(String query, RowMapper<T> rowMapper) throws IOException {
        return Files.newBufferedReader(Paths.get(filePath)).lines()
                .filter(l -> l.startsWith(query))
                .map(l -> rowMapper.mapRow(l))
                .collect(Collectors.toList());
    }

    public interface RowMapper<T> {
        T mapRow(String row);
    }
}
