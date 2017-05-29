package model;

import model.enums.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Board {

    private static final int size = 9;
    private List<Mark> board;
    private boolean boardFull;

    public Board() {
        board = new LinkedList<>();
        fillBoard();
        boardFull = false;
    }

    private void fillBoard() {
        for (int i = 0; i < size; i++) {
            board.add(Mark.EMPTY);
        }
    }

    public void showBoard() {
        for (int i = 0; i < size; i++) {
            if (i % 3 == 0) {
                System.out.println();
                //continue;
            }
            System.out.print(board.get(i));
        }
        System.out.println();
    }

    public boolean setField(int field, Mark mark) {
        if (field > size || field < 0) {
            System.out.println("Field out of range");
            return false;
        }
        if (board.get(field).equals(Mark.X) || board.get(field).equals(Mark.O)) {
            System.out.println("This field is already marked");
            return false;
        } else {
            board.set(field, mark);
            return true;
        }
    }

    public boolean isGameEnd() {
        //boolean result = false;
        if (isHorizontalWin())
            return true;
        if (isVerticalWin())
            return true;
        if (isAnotherWin())
            return true;

        for(Mark m : board) {
            if(m.equals(Mark.EMPTY)) {
                boardFull = false;
                return false;
            }
        }
        boardFull = true;
        return true;
    }

    //should check field != -
    private boolean isVerticalWin() {
        if (!board.get(0).equals(Mark.EMPTY) && !board.get(1).equals(Mark.EMPTY) && !board.get(2).equals(Mark.EMPTY))
            if (board.get(0).equals(board.get(3)) && board.get(3).equals(board.get(6)) && board.get(0).equals(board.get(6)))
                return true;
        if (!board.get(1).equals(Mark.EMPTY) && !board.get(4).equals(Mark.EMPTY) && !board.get(7).equals(Mark.EMPTY))
            if (board.get(1).equals(board.get(4)) && board.get(4).equals(board.get(7)) && board.get(1).equals(board.get(7)))
                return true;
        if (!board.get(2).equals(Mark.EMPTY) && !board.get(5).equals(Mark.EMPTY) && !board.get(8).equals(Mark.EMPTY))
            if (board.get(2).equals(board.get(5)) && board.get(5).equals(board.get(8)) && board.get(2).equals(board.get(8)))
                return true;
        return false;
    }

    //should check field != -
    private boolean isHorizontalWin() {
        if (!board.get(0).equals(Mark.EMPTY) && !board.get(1).equals(Mark.EMPTY) && !board.get(2).equals(Mark.EMPTY))
            if (board.get(0).equals(board.get(1)) && board.get(1).equals(board.get(2)) && board.get(0).equals(board.get(2)))
                return true;
        if (!board.get(3).equals(Mark.EMPTY) && !board.get(4).equals(Mark.EMPTY) && !board.get(5).equals(Mark.EMPTY))
            if (board.get(3).equals(board.get(4)) && board.get(4).equals(board.get(5)) && board.get(3).equals(board.get(5)))
                return true;
        if (!board.get(6).equals(Mark.EMPTY) && !board.get(7).equals(Mark.EMPTY) && !board.get(8).equals(Mark.EMPTY))
            if (board.get(6).equals(board.get(7)) && board.get(7).equals(board.get(8)) && board.get(6).equals(board.get(8)))
                return true;
        return false;
    }

    //should check field != -
    private boolean isAnotherWin() {
        if (!board.get(0).equals(Mark.EMPTY) && !board.get(4).equals(Mark.EMPTY) && !board.get(8).equals(Mark.EMPTY))
            if (board.get(0).equals(board.get(4)) && board.get(4).equals(board.get(8)) && board.get(0).equals(board.get(8)))
                return true;
        if (!board.get(2).equals(Mark.EMPTY) && !board.get(4).equals(Mark.EMPTY) && !board.get(6).equals(Mark.EMPTY))
            if (board.get(2).equals(board.get(4)) && board.get(4).equals(board.get(6)) && board.get(2).equals(board.get(6)))
                return true;
        return false;
    }

    public boolean isBoardFull() {
        return boardFull;
    }

}