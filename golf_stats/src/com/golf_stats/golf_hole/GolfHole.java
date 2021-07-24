package com.golf_stats.golf_hole;

public class GolfHole implements GolfHoleInterface {
    int holeNumber;
    int par;
    int score;
    int putts;
    boolean fairwayHit;
    boolean greenInRegulation;
    boolean upAndDown;

    /**
     * The constructor method.
     *
     * @param holeNumber
     *   The number of the hole.
     * @param par
     *   The par of the hole.
     * @param score
     *   The score the player made.
     * @param putts
     *   The number of putts the player made.
     * @param fairwayHit
     *   If the player hit the fairway.
     * @param greenInRegulation
     *   If the player hit the green in Regulation.
     * @param upAndDown
     *   If the player got an up and down if the green was not hit in regulation.
     */
    public GolfHole(int holeNumber, int par, int score, int putts, boolean fairwayHit, boolean greenInRegulation, boolean upAndDown) {
        this.holeNumber = holeNumber;
        this.par = par;
        this.score = score;
        this.putts = putts;
        this.fairwayHit = fairwayHit;
        this.greenInRegulation = greenInRegulation;
        this.upAndDown = upAndDown;
    }

    @Override
    public int getHoleNumber() {
        return holeNumber;
    }

    @Override
    public int getPar() {
        return par;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getPutts() {
        return putts;
    }

    @Override
    public boolean isFairwayHit() {
        return fairwayHit;
    }

    @Override
    public boolean isGreenInRegulation() {
        return greenInRegulation;
    }

    @Override
    public boolean isUpAndDown() {
        return upAndDown;
    }
}
