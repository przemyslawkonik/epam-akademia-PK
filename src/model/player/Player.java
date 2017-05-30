package model.player;


import model.board.Board;
import model.field.Mark;

import java.util.Scanner;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Player {

    private Mark mark;

    public Player() {
        this.mark = Mark.EMPTY;
    }

    public Player(Mark mark) {
        this.mark = mark;
    }

    public int selectRow(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        if(row < 0 || row >= board.getRows())
            throw new ArrayIndexOutOfBoundsException();
        return row;
    }

    public int selectColumn(Board board) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        if(column < 0 || column >= board.getColumns())
            throw new ArrayIndexOutOfBoundsException();
        return column;
    }

    public void setOpositeMark() {
        if (mark.equals(Mark.O)) {
            setMark(Mark.X);
        } else if (mark.equals(Mark.X)) {
            setMark(Mark.O);
        }
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
