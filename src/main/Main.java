package main;

import model.Board;
import model.Player;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.showBoard();
        Player player = new Player();
        board.setField(player.setMark(0,2));
        board.showBoard();
    }
}
