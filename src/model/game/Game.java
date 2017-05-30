package model.game;

import model.board.Board;
import model.board.Size;
import model.field.Mark;
import model.player.Player;
import model.player.UnknownPlayerException;

import java.util.Scanner;

/**
 * Created by Przemysław Konik on 2017-05-30.
 */
public class Game {

    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game() {
        board = new Board(Size.SMALL);
        firstPlayer = new Player();
        secondPlayer = new Player();
    }

    public void play() {
        whoIsFirst();
    }

    private void whoIsFirst() {
        while(true) {
            System.out.println("Who is starting (O or X)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();

            try {
                if (choice.equals(Mark.O.toString())) {
                    setOrder(Mark.O, Mark.X);
                    break;
                } else if (choice.equals(Mark.X.toString())) {
                    setOrder(Mark.X, Mark.O);
                    break;
                } else {
                    throw new UnknownPlayerException();
                }
            }catch (UnknownPlayerException e) {
                System.out.println("Unknown Player");
            }
        }
    }

    private void setOrder(Mark mark1, Mark mark2) {
        firstPlayer.setMark(mark1);
        secondPlayer.setMark(mark2);
    }

    

}
