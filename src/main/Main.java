package main;

import model.Board;
import model.Player;
import model.enums.Mark;

import java.util.Scanner;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player();
        Player player2 = new Player();
        Player winner;

        whoIsFirst(player1, player2);
        //System.out.println(player1.getMark()+""+player2.getMark());
        do {
            do {
                board.showBoard();
            }while(!board.setField(turn(player1), player1.getMark()));

            /*
            if(!board.isGameEnd()) {
                winner = player1;
                break;
            }
            */

            do {
                board.showBoard();
            }while(!board.setField(turn(player2), player2.getMark()));

            //winner = player2;

        }while(!board.isGameEnd());

        //System.out.println("Winner is " + winner.getMark());

    }

    public static void whoIsFirst(Player player1, Player player2) {
        boolean isPlayerSet = false;
        while(!isPlayerSet) {
            System.out.println("Who is starting first (O or X)?");
            Scanner scanner = new Scanner(System.in);
            String choice;
            choice = scanner.nextLine();
            if(choice.equals("O")) {
                isPlayerSet = true;
                player1.setMark(Mark.O);
                player2.setMark(Mark.X);
            } else if(choice.equals("X")) {
                isPlayerSet = true;
                player1.setMark(Mark.X);
                player2.setMark(Mark.O);
            }
            else {
                System.out.println("Unknown player");
            }
        }
    }

    public static int turn(Player player) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;

        System.out.println("Player " + player.getMark() + " turn");
        System.out.println("Insert row: ");
        row = scanner.nextInt();
        System.out.println("Insert column: ");
        column = scanner.nextInt();

        return player.markField(row, column);
    }

}
