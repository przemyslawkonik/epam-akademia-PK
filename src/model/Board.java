package model;

import com.sun.org.apache.xpath.internal.operations.String;
import model.enums.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Board {

    private static final int size = 9;
    private List<Mark> board;

    public Board() {
        board = new LinkedList<>();
        fillBoard();
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
        for(Mark m : board) {
            if(m.equals(Mark.EMPTY))
                return false;
        }
        return true;
    }
}