package model.player;


import model.field.Mark;

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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
