package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];

        System.out.print("Input command: ");
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            String[] arguments = command.split("\\s+");
            if (arguments.length != 3 || !"start".equals(arguments[0])) {
                System.out.println("Bad parameters!");
            } else {

                players[0] = Player.of(arguments[1]);
                players[1] = Player.of(arguments[2]);

                if (players[0] == null || players[1] == null) {
                    System.out.println("Bad parameters!");
                    continue;
                }

                playGame(players[0], players[1]);
                System.out.println();
            }
            System.out.print("Input command: ");
            command = scanner.nextLine();
        }
    }

    private static void playGame(Player xPlayer, Player oPlayer) {
        Field field = new Field();

        while (!field.isFull() && field.getWinner() == ' ') {
            if (field.getCurrentMove() == 'X') {
                xPlayer.move(field);
            } else {
                oPlayer.move(field);
            }
        }

        System.out.println(field);
        char winner = field.getWinner();

        if (winner == 'X' || winner == 'O') System.out.println(winner + " wins");
        else if (winner == ' ') System.out.println("Draw");
        else throw new IllegalStateException();

    }
}