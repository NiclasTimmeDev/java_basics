package com.golf_stats.stats_presenter;

public interface StatsPresenterInterface {
    int[] score = {0, 0};
    int putts = 0;
    double percentageFairwaysHit = 0.0;
    double percentageGreensInRegulation = 0.0;
    double percentageUpAndDowns = 0.0;

    public int[] getScore();

    public int getPutts();

    public double getPercentageFairwaysHit();

    public double getPercentageGreensInRegulation();

    public double getPercentageUpAndDowns();
}
