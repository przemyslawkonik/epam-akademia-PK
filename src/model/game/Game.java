package model.game;

import model.board.Board;
import model.board.Size;
import model.board.TicTacToeBoard;
import model.field.FieldIsAlreadyMarkedException;
import model.field.Mark;
import model.player.Player;
import tools.Input;
import tools.enums.UserAnswer;

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
        while (true) {
            System.out.println("Do you want to start a new game (y or n)?");
            try {
                if (isStart()) {
                    prepare();
                    play();
                } else System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong answer! Try again!");
            }
        }
    }

    private boolean isStart() {
        return UserAnswer.valueOf(Input.get()).isYes();
    }

    private void prepare() {
        board.clear();
        state = State.GAME_IN_PROGRESS;
    }

    private void play() {
        Player currentPlayer = whoIsFirst();
        while (true) {
            if (currentPlayer.equals(player1)) {
                turn(player1);
            } else {
                turn(player2);
            }
            if (!state.equals(State.GAME_IN_PROGRESS)) {
                break;
            }
            currentPlayer = switchPlayer(currentPlayer);
        }
        updateStats(currentPlayer);
        board.show();
        showResult(currentPlayer);
    }

    private Player switchPlayer(Player player) {
        if(player.equals(player1))
            return player2;
        else
            return player1;
    }

    private void updateStats(Player player) {
        if(state.equals(State.WIN))
            player.getStats().addWin();
    }

    private void showResult(Player player) {
        switch (state) {
            case WIN: {
                System.out.println("The winner is " + player.getMark());
                break;
            }
            case DRAW: {
                System.out.println("The match result is draw");
                break;
            }
        }
        player1.showStats();
        player2.showStats();
    }

    private Player whoIsFirst() {
        while(true) {
            System.out.println("Who is starting (O or X)");
            try{
                Mark mark = Mark.valueOf(Input.get().toUpperCase());
                if(mark.equals(player1.getMark()))
                    return player1;
                else
                    return player2;
            }catch (IllegalArgumentException e) {
                System.out.println("Unknown player! Try again!");
            }
        }
    }

    private void turn(Player player) {
        int row, column;
        while (true) {
            try {
                board.show();
                System.out.println("Player " + player.getMark() + " turn");
                System.out.println("Select row: ");
                row = player.selectRow();

                System.out.println("Select column: ");
                column = player.selectColumn();

                board.setField(row, column, player.getMark());
                state = new Result().get(row, column, board);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Value is not an Integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Given values are out of the board");
            } catch (FieldIsAlreadyMarkedException e) {
                System.out.println("Selected field is already marked");
            }
        }
    }

}
