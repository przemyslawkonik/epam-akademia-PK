package model.stats;

/**
 * Created by Przemysław Konik on 2017-06-01.
 */
public class Stats {

    private int wins;

    public Stats() {
        wins = 0;
    }

    public void addWin() {
        wins++;
    }

    public int getWins() {
        return wins;
    }
}
