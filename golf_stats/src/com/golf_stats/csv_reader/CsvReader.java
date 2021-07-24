package com.golf_stats.csv_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Read data from a given CSV file.
 *
 * The data from the file will be returned in
 * a list format.
 */
public class CsvReader {
    private final String fileName;
    String line;

    /**
     * Constructor method.
     *
     * @param fileName
     *   The path to the CSV file.
     */
    public CsvReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return List<List<String>>
     *   The data that has been coverted from the csv file.
     * @throws IOException
     *   The exception.
     */
    public List<List<String>> readCsv() throws IOException {

        // Instantiate buffer reader and read the CSV file.
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));

        // The data List that will eventually hold the CSV data.
        List<List<String>> data = new ArrayList<>();

        /*
         * The BufferReader reads every line in the CSV
         * file separately. We can use this to will the data
         * list.
         */
        while ((this.line = br.readLine()) != null) {
            data.add(Arrays.asList(this.line.split(",")));
        }

        // Return the data in a format we can work with.
        return data;
    }
}
