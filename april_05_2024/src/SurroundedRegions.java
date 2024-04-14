import java.util.*;

public class SurroundedRegions {
    public static void captureRegions(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Mark 'O's on the boundary and their neighbors as 'B'
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        // Flip 'O's to 'X's and 'B's back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'B') board[i][j] = 'O';
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') return;

        board[i][j] = 'B';

        // Visit neighbors
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];
        System.out.println("Enter the elements of the board:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }

        captureRegions(board);

        System.out.println("Updated board:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        scanner.close();
    }
}
