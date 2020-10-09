package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer implements Player {
    @Override
    public void move(Field field) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(field);
            System.out.print("Enter coordinates: ");
            try {
                int col = scanner.nextInt();
                int row = scanner.nextInt();
                if (row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (field.getCell(3 - row, col - 1) == ' ') {
                    field.set(3 - row, col -1);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}