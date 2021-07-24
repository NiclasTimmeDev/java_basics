package com.golf_stats.stats_presenter;

public class StatsPresenter implements StatsPresenterInterface {

    int[] score;
    int putts;
    double percentageFairwaysHit;
    double percentageGreensInRegulation;
    double percentageUpAndDowns;

    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";

    public StatsPresenter(int[] score, int putts, double percentageFairwaysHit, double percentageGreensInRegulation, double percentageUpAndDowns) {
        this.score = score;
        this.putts = putts;
        this.percentageFairwaysHit = percentageFairwaysHit;
        this.percentageGreensInRegulation = percentageGreensInRegulation;
        this.percentageUpAndDowns = percentageUpAndDowns;

        this.printStats();
    }

    public void printStats(){
        // Score.
        this.printScore();

        // Putts.
        this.printPutts();

        // Percentage of fairways hit.
        this.printFairways();

        // Percentage of Greens in Regulation.
        this.printGreensInRegulation();

        // Ups and downs.
        this.printUpAndDowns();
    }

    private void printScore() {
        String color = this.getScore()[0] - this.getScore()[1] < 0 ? GREEN : RED;

        System.out.println("Score: " + color + this.getScore()[0] + " (" + (this.getScore()[0] - this.getScore()[1]) + ")" + RESET);
    }

    private void printPutts() {
        System.out.println("Putts: " + this.getPutts());
    }

    private void printFairways() {
        String color = this.getPercentageFairwaysHit() > 0.5 ? GREEN : RED;

        System.out.println("Percentage of hit fairways: " + color + this.getPercentageFairwaysHit() + RESET);
    }

    private void printGreensInRegulation() {
        String color = this.getPercentageGreensInRegulation() > 0.5 ? GREEN : RED;

        System.out.println("Percentage of greens in Regulation: " + color + this.getPercentageGreensInRegulation() + RESET);
    }

    private void printUpAndDowns() {
        String color = this.getPercentageUpAndDowns() > 0.5 ? GREEN : RED;

        System.out.println("Percentage of Up And Downs: " + color + this.getPercentageUpAndDowns() + RESET);
    }

    @Override
    public int[] getScore() {
        return score;
    }

    @Override
    public int getPutts() {
        return putts;
    }

    @Override
    public double getPercentageFairwaysHit() {
        return percentageFairwaysHit;
    }

    @Override
    public double getPercentageGreensInRegulation() {
        return percentageGreensInRegulation;
    }

    @Override
    public double getPercentageUpAndDowns() {
        return percentageUpAndDowns;
    }
}
