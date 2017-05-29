package model;

import model.enums.Mark;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Player {

    private Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
    }

    public int setMark(int row, int column) {
        return row*3+column;
    }
}
