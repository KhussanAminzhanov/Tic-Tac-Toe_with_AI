package tictactoe;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class HardAI implements Player{

    public  void     move(Field field) {
        System.out.println(field);
        System.out.println("Making move level \"hard\"");
        char[][] board = getCopyField(field);
        char ai = field.getCurrentMove();
        char user = ai == 'X' ? 'O' : 'X';
        int row = 0, col = 0;
        int bestScore = -100;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = ai;
                    int score = minimax(board,false, ai, user);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        row = i; col = j;
                    }
                }
            }
        }
        field.set(row, col);
    }

    private int      minimax(char[][] board, boolean isMaximizing, char ai, char user) {
        char result = Field.checkWinner(board);
        if (result == ai) return 10;
        if (result == user) return -10;
        if (result == ' ') return 0;


        int bestScore;
        if (isMaximizing) {
            bestScore = -100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = ai;
                        int score = minimax(board, false, ai, user);
                        board[i][j] = ' ';
                        bestScore = max(score, bestScore);
                    }
                }
            }
        } else {
            bestScore = 100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = user;
                        int score = minimax(board,  true, ai, user);
                        board[i][j] = ' ';
                        bestScore = min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;

    }
    private char[][] getCopyField(Field field) {
        char[][] fieldCopy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fieldCopy[i][j] = field.getCell(i, j);
            }
        }
        return fieldCopy;
    }

}


