import java.util.Scanner;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the No of rows in the Triangle : ");
            int Rows = scanner.nextInt();

            int[][] triangle = new int[Rows][Rows];


            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }


            int minPathSum = minimumPathSum(triangle);
            System.out.println(minPathSum);


        scanner.close();
    }

    public static int minimumPathSum(int[][] triangle) {
        int length = triangle.length;


        int[][] dp = new int[length][length];


        for (int i = 0; i < length; i++) {
            dp[length - 1][i] = triangle[length - 1][i];
        }


        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }


        return dp[0][0];
    }
}
