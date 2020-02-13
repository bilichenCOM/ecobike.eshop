package com.ecobike.eshop.helper;

import com.ecobike.eshop.ApplicationProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileDeserializer {

    private String filePath;

    public  FileDeserializer() {
        filePath = ApplicationProperties.INPUT_FILE_PATH;
    }

    public <T> List<T> readList(String query, RowMapper<T> rowMapper) {
        try {
            return getStreamForQuery(query)
                    .map(rowMapper::mapRow)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("cannot read list from file, for query: " + query);
        }
        return new ArrayList<>();
    }

    public <T> Optional<T> readObject(String query, String filter, RowMapper<T> rowMapper) {
        try {
            return getStreamForQuery(query)
                    .map(String::toLowerCase)
                    .filter(r -> r.contains(filter.toLowerCase()))
                    .map(rowMapper::mapRow)
                    .findFirst();
        } catch (IOException e) {
            System.err.println("cannot read object from file, for query: " + query);
        }
        return Optional.empty();
    }

    private Stream<String> getStreamForQuery(String query) throws IOException {
        return Files.newBufferedReader(Paths.get(filePath), UTF_8).lines()
                .filter(l -> l.startsWith(query))
                .map(r -> r.substring(query.length()).trim());
    }


    public interface RowMapper<T> {

        String DEFAULT_DELIMITER = "; ";

        T mapRow(String row);
    }
}
