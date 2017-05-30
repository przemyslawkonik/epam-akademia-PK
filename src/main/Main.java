package main;

import model.board.Board;
import model.board.Size;
import model.game.Game;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Main {

    public static void main(String[] args) {
        Board board1 = new Board(Size.SMALL);
        board1.showBoard();

        System.out.println();
        System.out.println();

        Board board2 = new Board(Size.MEDIUM);
        board2.showBoard();

        Game game = new Game();
        game.play();
    }

}
