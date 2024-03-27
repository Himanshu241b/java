import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows  and columns  in the matrix: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int result = uniquePaths(rows, columns);

        System.out.println("Total number of unique paths: " + result);


    }

    public static int uniquePaths(int rows, int coloumns) {
        int[][] dp = new int[rows][coloumns];

        // Initialize first row and first column to 1
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < coloumns; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < coloumns; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the value at the bottom-right cell
        return dp[rows - 1][coloumns - 1];
    }
}
