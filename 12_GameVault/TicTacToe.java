import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("\n🟦 Welcome to Tic Tac Toe 🟦");

        while (!gameEnded) {
            printBoard();

            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row and column (0-2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

            board[row][col] = currentPlayer;

            if (hasWon(currentPlayer)) {
                printBoard();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("🤝 It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        resetBoard();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char c : row) {
                System.out.print(c + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isDraw() {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    public static void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }
}
