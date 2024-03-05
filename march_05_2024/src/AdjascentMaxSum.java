//imports
import java.util.Scanner;

class AdjacentMaxSum {
    public static int adjacentMaxSum(int[][] A) {
        int N = A[0].length;

        if (N == 1) return Math.max(A[0][0], A[1][0]);

        int[] dp = new int[N];

        dp[0] = Math.max(A[0][0], A[1][0]);
        dp[1] = Math.max(dp[0], Math.max(A[0][1], A[1][1]));

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + A[0][i], dp[i - 2] + A[1][i]));
        }

        return dp[N - 1];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in 2d array");
        int size = scanner.nextInt();
        if(size % 2 != 0)
            System.out.println("Only even elements are possible");
        int[][] array = new int[2][size/2];
        System.out.println("Enter the "+size+" elements of the array");
        for(int row=0; row<2 ; row++)
            for(int col=0; col < size/2; col++)
                array[row][col] = scanner.nextInt();

        System.out.println("Max adjascent sum is"+adjacentMaxSum(array));
    }
}
