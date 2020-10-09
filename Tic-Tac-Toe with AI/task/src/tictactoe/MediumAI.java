package tictactoe;

import java.util.Random;

public class MediumAI implements Player {

    Random random = new Random();

    public void move(Field field) {
        System.out.println(field);
        System.out.println("Making move level \"medium\"");

        char symbol = field.getCurrentMove();
        int row, col;
        int[][] emptyCells = field.getEmptyCells();

        for (int[] emptyCell : emptyCells) {
            if (field.willWin(emptyCell[0], emptyCell[1], symbol)) {
                row = emptyCell[0];
                col = emptyCell[1];
                field.set(row, col);
                return;
            }
        }

        symbol = symbol == 'X' ? 'O' : 'X';
        for (int[] emptyCell : emptyCells) {
            if (field.willWin(emptyCell[0], emptyCell[1], symbol)) {
                row = emptyCell[0];
                col = emptyCell[1];
                field.set(row, col);
                return;
            }
        }

        int[] randomCoordinates = emptyCells[random.nextInt(emptyCells.length)];
        field.set(randomCoordinates[0], randomCoordinates[1]);
    }
}
