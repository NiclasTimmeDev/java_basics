package com.golf_stats.stats_calculator;

import com.golf_stats.golf_hole.GolfHole;
import com.golf_stats.stats_presenter.StatsPresenter;

import java.util.ArrayList;
import java.util.List;

public class StatsCalculator {

    /**
     * The raw data.
     */
    private final List<List<String>> data;

    private final List<GolfHole> golfHoles = new ArrayList<GolfHole>();

    /**
     * The constructor function.
     *
     * @param data
     *   The data that will be analyzed.
     */
    public StatsCalculator(List<List<String>> data) {

        this.data = data;

        // Convert data to golf hole data.
        this.convertToGolfHoles();

        // Calculate the statistics.
        this.calculateStats();

    }

    /**
     * Getter function for the data variable.
     *
     * @return List<List<String>>
     */
    public List<List<String>> getData() {
        return data;
    }

    /**
     * Convert the data to golf holes stats.
     *
     * Each entry in the data list is a list itself which represents the stats for one golf hole.
     * The structure is: hole number, par, score, putts, fairway hit, green in regulation, up and down,
     */
    public void convertToGolfHoles () {
        for (List<String> datapoint: data) {
            int holeNumber = Integer.parseInt(datapoint.get(0));
            int par = Integer.parseInt(datapoint.get(1));
            int score = Integer.parseInt(datapoint.get(2));
            int putts = Integer.parseInt(datapoint.get(3));
            boolean fairwayHit = datapoint.get(4).equals("1");
            boolean greenInRegulation = datapoint.get(5).equals("1");
            boolean upAndDown = datapoint.get(6).equals("1");
            GolfHole hole = new GolfHole(holeNumber, par, score, putts, fairwayHit, greenInRegulation, upAndDown);
            this.golfHoles.add(hole);
        }
    }

    /**
     * Calculate the statistics based on the golf hole data.
     */
    public void calculateStats() {
        // The score and the par of the round.
        int[] score = this.calculateScore();

        // The number of putts the player made.
        int putts = this.calculatePutts();

        // The percentage of hit fairways.
        double percentageFairwaysHit = this.calculateFairwaysHit();

        // The percentage of greens in Regulation.
        double percentageGreensInRegulation = this.calculateGreensInRegulation();

        // The percentage of up and downs.
        double percentageUpAndDowns = this.calculateUpAndDowns();

        StatsPresenter presenter = new StatsPresenter(score, putts, percentageFairwaysHit, percentageGreensInRegulation, percentageUpAndDowns);
    }

    /**
     * Calculate the score.
     *
     * This happens by adding up the scores
     * the payler submitted for each hole.
     *
     * @return int
     *   The score.
     */
    public int[] calculateScore(){
        // The strokes and the par of the data.
        int[] result = {0, 0};

        for (GolfHole hole : this.golfHoles) {
            // Calculate the strokes.
            result[0] = result[0] + hole.getScore();

            // Calculate the par.
            result[1] = result[1] + hole.getPar();
        }
        return result;
    }

    /**
     * Calculate the number of putts the player made.
     *
     * @return int
     *   The number of putts.
     */
    public int calculatePutts() {
        int putts = 0;

        for (GolfHole hole : this.golfHoles) {
            putts = putts + hole.getPutts();
        }
        return putts;
    }

    /**
     * Calculate the percentage of hit fairways.
     *
     * @return double
     *   The percentage.
     */
    public double calculateFairwaysHit() {
        double percentage = 0.0;
        double numberOfFairways = 0;
        double numberOfFairwaysHit = 0;

        // Only if the hole is not a par 3 it has a fairway that can be hit.
        for(GolfHole hole : this.golfHoles) {
            if(hole.getPar() != 3) {
                numberOfFairways++;

                // Check if the fairway was hit.
                if(hole.isFairwayHit()) {
                    numberOfFairwaysHit++;
                }
            }
        }

        /*
         * Calculate the percentage.
         * Make sure that we do not divide by 0.
         */
        if (numberOfFairways > 0) {
            percentage = numberOfFairwaysHit / numberOfFairways;
        }
        return percentage;
    }

    /**
     * Calculate the percentage of greens in Regulation.
     *
     * @return double
     *   The percentage.
     */
    public double calculateGreensInRegulation() {
        double percentage = 0.0;
        double numberOfGreens = 0;
        double numberOfHoles = this.golfHoles.size();

        for(GolfHole hole : this.golfHoles) {
            if(hole.isGreenInRegulation()) {
                numberOfGreens++;
            }
        }

        /*
         * Calculate the percentage.
         * Make sure that we do not divide by 0.
         */
        if (numberOfGreens > 0) {
            percentage = numberOfGreens / numberOfHoles;
        }
        return percentage;
    }

    /**
     * Calculate the percentage of ups and downs.
     *
     * @return double
     *   The percentage.
     */
    public double calculateUpAndDowns() {
        double numberOfMissedGreens = 0.0;
        double numberOfUpsAndDowns = 0.0;

        // Only if the hole is not a par 3 it has a fairway that can be hit.
        for(GolfHole hole : this.golfHoles) {
            if(!hole.isGreenInRegulation()) {
                numberOfMissedGreens++;

                // Check if the fairway was hit.
                if(hole.isUpAndDown()) {
                    numberOfUpsAndDowns++;
                }
            }
        }

        /*
         * If no greens were missed set the up and down
         * percentage to 100%
         */
        if(numberOfMissedGreens == 0) {
            return 1.0;
        }

        return numberOfUpsAndDowns / numberOfMissedGreens;
    }
}
