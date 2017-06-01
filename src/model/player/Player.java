package model.player;

import model.board.Board;
import model.field.Mark;
import model.stats.Stats;

import java.util.Scanner;

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

    public int selectRow(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        row-=1;
        if(row < 0 || row >= board.rows())
            throw new ArrayIndexOutOfBoundsException();
        return row;
    }

    public int selectColumn(Board board) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        column-=1;
        if(column < 0 || column >= board.columns())
            throw new ArrayIndexOutOfBoundsException();
        return column;
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
