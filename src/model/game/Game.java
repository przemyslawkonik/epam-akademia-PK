package model.game;

import model.board.Board;
import model.board.Size;
import model.board.TicTacToeBoard;
import model.field.FieldIsAlreadyMarkedException;
import model.field.Mark;
import model.player.Player;
import model.player.UnknownPlayerException;

import java.util.*;

/**
 * Created by Przemysław Konik on 2017-05-30.
 */
public class Game {

    private final Board board;
    private Player player1;
    private Player player2;
    private State state;

    public Game() {
        board = new TicTacToeBoard(Size.SMALL);
        player1 = new Player(Mark.O);
        player2 = new Player(Mark.X);
        state = State.GAME_IN_PROGRESS;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Do you want to start a new game (y or n)?");
            answer = scanner.nextLine().toUpperCase();
            if(answer.equals("Y")) {
                board.clear();
                state = State.GAME_IN_PROGRESS;
                play();
            } else if (answer.equals("N")) {
                System.exit(0);
            }
        }while(true);
    }

    private void play() {
        Mark mark = whoIsFirst();
        while(true) {
            if(mark.equals(player1.getMark()))
                turn(player1);
            else
                turn(player2);

            if(!state.equals(State.GAME_IN_PROGRESS)) {
                break;
            }
            mark = mark.setOpposite();
        }
        board.show();
        updateStats(mark);
        showResult(mark);
    }

    private void updateStats(Mark mark) {
        if(mark.equals(player1.getMark()))
            player1.getStats().addWin();
        else
            player2.getStats().addWin();
    }

    private void showResult(Mark mark) {
        switch (state) {
            case WIN: {
                System.out.println("The winner is " + mark + "  " + player1.getMark() + ": " + player1.getStats().getWins() + " | " +
                        player2.getMark() + ": " + player2.getStats().getWins());
                break;
            }
            case DRAW: {
                System.out.println("The match result is draw   " + player1.getMark() + ": " + player1.getStats().getWins() + " | " +
                        player2.getMark() + ": " + player2.getStats().getWins());
                break;
            }
        }
    }

    private Mark whoIsFirst() {
        System.out.println("Who is starting (O or X)");
        while(true) {
            try{
                return getFirst();
            }catch (UnknownPlayerException e) {
                System.out.println("Unknown player");
            }
        }
    }

    private Mark getFirst() {
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

    private void turn(Player player) {
        System.out.println("Player " + player.getMark() + " turn");
        int row, column;
        while (true) {
            board.show();
            try {
                System.out.println("Select row: ");
                row = player.selectRow(board);

                System.out.println("Select column: ");
                column = player.selectColumn(board);

                board.setField(row, column, player.getMark());
                state = new Result().get(row, column, board);
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

}
