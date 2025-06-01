package Middle2;

import java.util.Random;

public class Game {
    private char[][] board;
    private Player player;
    public char computerSymbol;

    public Game(Player player) {
        this.board = new char[3][3];
        this.player = player;
        this.computerSymbol = player.getSymbol() == 'X' ? 'O' : 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void drawBoard() {
        System.out.println("____________");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n___________");

        }
    }

    //ход игрока
    public boolean playerMove(int move) {
        int row = (move - 1) / 3;//для строки/для столбца
        int col = (move - 1) % 3;

        if (board[row][col] == '-') {
            board[row][col] = player.getSymbol();
            return true;
        } else {
            System.out.println("Выберите другую ячейку");
            return false;
        }
    }

    //ход компьютера
    public void computerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != '-');

        board[row][col] = computerSymbol;
    }

    //проверка победителя
    public boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                    || (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
