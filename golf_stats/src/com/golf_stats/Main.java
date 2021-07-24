package com.golf_stats;

import com.golf_stats.csv_reader.CsvReader;
import com.golf_stats.stats_calculator.StatsCalculator;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // Read the CSV data.
        CsvReader csvReader = new CsvReader("/Users/niclastimm/code/Udemy/Java/golf_stats/data/nine_holes.csv");
        List<List<String>> data = csvReader.readCsv();

        // Calculate and print the CSV statistics.
        StatsCalculator stats = new StatsCalculator(data);
    }
}
