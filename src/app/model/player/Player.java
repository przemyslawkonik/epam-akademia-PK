package app.model.player;

import app.model.field.Mark;
import app.model.stats.Stats;
import app.tools.Input;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Player {

    private Mark mark;
    private Stats stats;

    public Player() {
        this.mark = Mark.EMPTY;
        stats = new Stats();
    }

    public Player(Mark mark) {
        this.mark = mark;
        stats = new Stats();
    }

    public int selectRow() {
        int row = Integer.parseInt(Input.get());
        return --row;
    }

    public int selectColumn() {
        int column = Integer.parseInt(Input.get());
        return --column;
    }

    public void showStats() {
        System.out.println(getMark() + ": " + stats.getWins());
    }

    public Stats getStats() {
        return stats;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

}
