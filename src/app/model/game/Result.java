package app.model.game;

import app.model.board.Board;
import app.model.field.Field;
import app.model.field.Mark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-06-01.
 */
public class Result {

    public State get(int row, int column, Board board) {
        if(isHorizontalWin(row, board) || isVerticalWin(column, board) || isDiagonalWin(board))
            return State.WIN;
        else if(board.isFull())
            return State.DRAW;
        else
            return State.GAME_IN_PROGRESS;
    }

    private boolean isHorizontalWin(int row, Board board) {
        List<Field> fields = new ArrayList<>();
        //wypelnienie listy rzedem w ktorym dodano znak
        for (int i = 0; i < board.columns(); i++) {
            fields.add(board.getField(i + row * board.columns()));
        }
        return compareFields(fields);
    }

    private boolean isVerticalWin(int column, Board board) {
        List<Field> fields = new ArrayList<>();
        //wypelnienie listy kolumna w ktorym dodano znak
        for (int i = column; i < board.size(); i+=board.rows()) {
            fields.add(board.getField(i));
        }
        return compareFields(fields);
    }

    private boolean isDiagonalWin(Board board) {
        List<Field> fields1 = new ArrayList<>();
        //przekatna od lewej do prawej
        for (int i = 0; i < board.size(); i+=board.rows()+1) {
            fields1.add(board.getField(i));
        }
        //przekatna od prawej do lewej
        List<Field> fields2 = new ArrayList<>();
        for(int i=board.rows()-1; i<board.size()-1; i+=board.rows()-1) {
            fields2.add(board.getField(i));
        }
        return compareFields(fields1) || compareFields(fields2);
    }

    private boolean compareFields(List<Field> fields) {
        for (int i = 0; i < fields.size() - 1; i++) {
            Mark current = fields.get(i).getMark();
            Mark next = fields.get(i + 1).getMark();
            if (!current.equals(next) || current.equals(Mark.EMPTY)) {
                return false;
            }
        }
        return true;
    }
}
