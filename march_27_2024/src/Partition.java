import java.util.Scanner;

public class Partition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array and the desired difference : ");
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Result: " + countPartitions(arr, d));
        scanner.close();
    }

    static int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[n + 1][d + 1];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= d; j++) {
                dp[i + 1][j] += dp[i][j];
                if (j + arr[i] <= d) {
                    dp[i + 1][j + arr[i]] += dp[i][j];
                }
            }
        }

        int count = 0;
        for (int i = (d + 1) / 2; i <= d; i++) {
            count += dp[n][i];
        }

        return count;
    }
}
