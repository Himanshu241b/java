import java.util.Scanner;

public class SubsetSum{

    public static boolean canPartition(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int[] arr = new int[size];
        System.out.print("Enter the elements of array : ");
        for (int element = 0; element < size; element++) {
            arr[element] = scanner.nextInt();
        }


        if (canPartition(arr)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
