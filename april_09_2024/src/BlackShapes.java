import java.util.Scanner;

public class BlackShapes {
    public static int blackShapes(char[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;

        int rows = A.length;
        int cols = A[0].length;
        int count = 0;

        // Iterate through each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If cell contains 'X', increment count and perform DFS
                if (A[i][j] == 'X') {
                    count++;
                    dfs(A, i, j);
                }
            }
        }

        return count;
    }

    // Depth-First Search (DFS)
    private static void dfs(char[][] A, int i, int j) {
        int rows = A.length;
        int cols = A[0].length;

        // Mark current cell as visited
        A[i][j] = 'O';

        // Check all four directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // Check if the new cell is within bounds and contains 'X'
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && A[newRow][newCol] == 'X') {
                dfs(A, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns (space-separated):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[][] matrix = new char[rows][cols];
        System.out.println("Enter the matrix row by row:");

        // Input matrix
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            matrix[i] = row.toCharArray();
        }

        int result = blackShapes(matrix);
        System.out.println("Number of black shapes: " + result);
    }
}
