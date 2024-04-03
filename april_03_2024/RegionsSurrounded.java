package april_03_2024;
import java.util.*;
public class RegionsSurrounded {
    public void captureSurroundedRegions(ArrayList<ArrayList<Character>> board) {
        if (board == null || board.size() == 0) return;
        int rows = board.size();
        int cols = board.get(0).size();

        // Traverse the first and last rows
        for (int col = 0; col < cols; col++) {
            if (board.get(0).get(col) == 'O') {
                dfs(board, 0, col);
            }
            if (board.get(rows - 1).get(col) == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // Traverse the first and last columns
        for (int row = 0; row < rows; row++) {
            if (board.get(row).get(0) == 'O') {
                dfs(board, row, 0);
            }
            if (board.get(row).get(cols - 1) == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        // Flip all 'O's to 'X's and revert '#' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board.get(i).get(j) == 'O') {
                    board.get(i).set(j, 'X');
                } else if (board.get(i).get(j) == '#') {
                    board.get(i).set(j, 'O');
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> board, int row, int col) {
        int rows = board.size();
        int cols = board.get(0).size();

        if (row < 0 || row >= rows || col < 0 || col >= cols || board.get(row).get(col) != 'O') {
            return;
        }

        board.get(row).set(col, '#');

        // Traverse in all four directions
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public void printBoard(ArrayList<ArrayList<Character>> board) {
        for (ArrayList<Character> row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

