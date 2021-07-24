package com.golf_stats.golf_hole;

public interface GolfHoleInterface {
    int holeNumber = 0;
    int par = 0;
    int score = 0;
    int putts = 2;
    boolean fairwayHit = false;
    boolean greenInRegulation = false;
    boolean upAndDown = false;

    public int getHoleNumber();

    public int getPar();


    public int getScore();


    public int getPutts();

    public boolean isFairwayHit();

    public boolean isGreenInRegulation();

    public boolean isUpAndDown();
}
