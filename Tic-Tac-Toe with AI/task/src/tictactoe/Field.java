package tictactoe;

public class Field {
    private final char[][] field;
    private char currentMove;
    private char winner;

    public Field() {
        field = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        currentMove = 'X';
        winner = ' ';
    }

    @Override
    public String  toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------")
                .append(System.lineSeparator());

        for (char[] row : field) {
            stringBuilder.append("| ")
                    .append(row[0]).append(" ")
                    .append(row[1]).append(" ")
                    .append(row[2]).append(" |")
                    .append(System.lineSeparator());
        }

        stringBuilder.append("---------");
        return stringBuilder.toString();
    }

    public char    getCell(int x, int y) {
        return field[x][y];
    }
    public char    getCurrentMove() {
        return currentMove;
    }
    public char    getWinner() {
        return winner;
    }
    public int     getCountEmptyCells() {
        int count = 0;
        for (char[] symbols : field) {
            for (char symbol : symbols) {
                if (symbol == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    public int[][] getEmptyCells() {
        int numberEmptyCells = getCountEmptyCells();
        int[][] emptyCells = new int[numberEmptyCells][2];
        int k = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == ' ') {
                    emptyCells[k] = new int[]{i,j};
                    k++;
                }
            }
        }
        return emptyCells;
    }

    //static functions

    public static   boolean equals(char a, char b, char c) {
        return a == b && b == c && a != ' ';
    }
    public static   char checkWinner(char[][] board) {
        char winner = ' ';
        for (int i = 0; i < 3; i++) {
            if (equals(board[i][0], board[i][1], board[i][2]))
                winner = board[i][0];
        }
        //vertical
        for (int i = 0; i < 3; i++) {
            if (equals(board[0][i], board[1][i], board[2][i]))
                winner = board[0][i];
        }
        //diagonal
        if (equals(board[0][0], board[1][1], board[2][2]))
            winner = board[0][0];
        if (equals(board[0][2], board[1][1], board[2][0]))
            winner = board[0][2];
        int openSpots = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') openSpots++;
            }
        }
        return winner == ' ' && openSpots == 0 ? ' ' : winner;
    }

    public void    set(int row, int col) {
        if (field[row][col] != ' ' || winner != ' ') {
            throw new IllegalStateException();
        }
        field[row][col] = currentMove;
        currentMove = currentMove == 'X' ? 'O' : 'X';
        winner = checkWinner(field);
    }
    public boolean willWin(int row, int col, char symbol) {
        if (field[row][col] == ' ') {
            char before = field[row][col];
            field[row][col] = symbol;

            boolean won = checkWinner(field) == symbol;

            field[row][col] = before;
            return won;
        }
        return false;
    }
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}