package main;

import model.Board;
import model.Player;
import model.enums.Mark;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(Mark.X);
        Player player2 = new Player(Mark.O);

        board.showBoard();
        board.setField(player1.setMark(2,2));
        board.setField(player2.setMark(0,1));
        board.showBoard();
    }
}
