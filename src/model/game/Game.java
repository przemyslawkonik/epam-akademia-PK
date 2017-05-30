package model.game;

import model.board.Board;
import model.board.FieldIsAlreadyMarkedException;
import model.board.Size;
import model.field.Mark;
import model.player.Player;
import model.player.UnknownPlayerException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Przemysław Konik on 2017-05-30.
 */
public class Game {

    private final Board board;
    //private Player player;

    public Game() {
        board = new Board(Size.SMALL);
    }

    public void play() {
        Player player = whoIsFirst();
        while(!isGameEnd()) {
            switch (player.getMark()) {
                case O: {
                    turn(player);
                    player.setMark(Mark.X);
                    break;
                }
                case X: {
                    turn(player);
                    player.setMark(Mark.O);
                    break;
                }
            }
        }
    }

    private Player whoIsFirst() {
        while(true) {
            System.out.println("Who is starting (O or X)");
            try {
                return new Player(setFirst());
            }catch (UnknownPlayerException e) {
                System.out.println("Unknown Player");
            }
        }
    }

    private void turn(Player player) {
        System.out.println("Player " + player.getMark() + " turn");
        int row, column;
        while (true) {
            board.showBoard();
            try {
                System.out.println("Select row: ");
                row = player.selectRow(board);

                System.out.println("Select column: ");
                column = player.selectColumn(board);

                board.setField(row, column, player.getMark());
                break;

            } catch (InputMismatchException e) {
                System.out.println("Value is not an Integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Given value is out of the board");
            } catch (FieldIsAlreadyMarkedException e) {
                System.out.println("Selected field is already marked");
            }
        }
    }

    private boolean isGameEnd() {
        return board.isFull();
    }

    private Mark setFirst() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals(Mark.O.toString())) {
            return Mark.O;
        } else if (choice.equals(Mark.X.toString())) {
            return Mark.X;
        } else {
            throw new UnknownPlayerException();
        }
    }

}
