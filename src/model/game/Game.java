package model.game;

import model.board.Board;
import model.board.FieldIsAlreadyMarkedException;
import model.board.Size;
import model.field.Field;
import model.field.Mark;
import model.player.Player;
import model.player.UnknownPlayerException;

import java.util.*;

/**
 * Created by Przemysław Konik on 2017-05-30.
 */
public class Game {

    private final Board board;
    private Player player;
    private boolean win;

    public Game() {
        board = new Board(Size.SMALL);
        player = new Player();
        win = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Do you want to start a new game (y or n)?");
            answer = scanner.nextLine().toUpperCase();
            if(answer.equals("Y")) {
                board.clear();
                play();
            } else if (answer.equals("N")) {
                System.exit(0);
            }
        }while(true);
    }

    private void play() {
        win = false;
        player = whoIsFirst();
        while(true) {
            switch (player.getMark()) {
                case O: {
                    turn(player);
                    break;
                }
                case X: {
                    turn(player);
                    break;
                }
            }
            if(isGameEnd()) {
                break;
            }
            player.setOpositeMark();
        }
        //rezultat po zakonczeniu rundy
        board.show();
        showResult();
    }

    private void showResult() {
        if(win) {
            System.out.println("The winner is " + player.getMark());
        } else {
            System.out.println("Match result: draw");
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
            board.show();
            try {
                System.out.println("Select row: ");
                row = player.selectRow(board);

                System.out.println("Select column: ");
                column = player.selectColumn(board);

                board.setField(row, column, player.getMark());
                win = isHorizontalWin(row) || isVerticalWin(column) || isDiagonalWin();
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
        return isWin() || board.isFull();
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

    private boolean isWin() {
        return win;
    }

    private boolean isHorizontalWin(int row) {
        List<Field> fields = new ArrayList<>();
        //wypelnienie listy rzedem w ktorym dodano znak
        for (int i = 0; i < board.getColumns(); i++) {
            fields.add(board.getField(i + row * board.getColumns()));
        }
        return compareFields(fields);
    }

    private boolean isVerticalWin(int column) {
        List<Field> fields = new ArrayList<>();
        //wypelnienie listy kolumna w ktorym dodano znak
        for (int i = column; i < board.size(); i+=board.getRows()) {
            fields.add(board.getField(i));
        }
        return compareFields(fields);
    }

    private boolean isDiagonalWin() {
        List<Field> fields1 = new ArrayList<>();
        //przekatna od lewej do prawej
        for (int i = 0; i < board.size(); i+=board.getRows()+1) {
            fields1.add(board.getField(i));
        }
        //przekatna od prawej do lewej
        List<Field> fields2 = new ArrayList<>();
        for(int i=board.getRows()-1; i<board.size()-1; i+=board.getRows()-1) {
            fields2.add(board.getField(i));
        }
        return compareFields(fields1) || compareFields(fields2);
    }

    private boolean compareFields(List<Field> fields) {
        for (int i = 0; i < fields.size() - 1; i++) {
            Mark current = fields.get(i).getMark();
            Mark next = fields.get(i + 1).getMark();
            if (!current.equals(next) || current.equals(Mark.EMPTY)) {
                return false;
            }
        }
        return true;
    }



}
