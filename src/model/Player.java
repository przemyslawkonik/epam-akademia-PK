package model;

import model.enums.Mark;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Player {

    private Mark mark;

    public Player() {

    }

    public Player(Mark mark) {
        this.mark = mark;
    }

    public int markField(int row, int column) {
        return row*3+column;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }
}
