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
            board.add(Mark.O);
        }
    }

    public void showBoard() {
        for (int i = 0; i < size; i++) {
            if (i % 3 == 0) {
                System.out.println();
                continue;
            }
            System.out.print(board.get(i));
        }
    }
}