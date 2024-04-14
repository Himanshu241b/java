import java.util.*;

public class EqualAveragePartition {

    public static ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        // Initialize the result
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Calculate the total sum of elements in the array
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        // Sort the input array to ensure lexicographical order
        Collections.sort(A);

        int n = A.size();

        // Initialize a DP array to track possible sum combinations
        boolean[][] dp = new boolean[totalSum + 1][n + 1];
        dp[0][0] = true;

        // Fill the DP array
        for (int num : A) {
            for (int sum = totalSum; sum >= num; sum--) {
                for (int count = 1; count <= n; count++) {
                    if (dp[sum - num][count - 1]) {
                        dp[sum][count] = true;
                    }
                }
            }
        }

        // Traverse the DP array to find a solution
        for (int i = 1; i < n; i++) {
            if (totalSum * i % n == 0 && dp[totalSum * i / n][i]) {
                int sumA = totalSum * i / n;
                int remainingSum = totalSum - sumA;
                int idx = n;
                ArrayList<Integer> setA = new ArrayList<>();
                ArrayList<Integer> setB = new ArrayList<>();

                // Reconstruct the sets A and B
                while (i > 0 || remainingSum > 0) {
                    if (i > 0 && dp[remainingSum][i]) {
                        setA.add(A.get(--idx));
                        sumA -= A.get(idx);
                        i--;
                    } else {
                        setB.add(A.get(--idx));
                        remainingSum -= A.get(idx);
                    }
                }

                // Add the sets to the result
                result.add(setA);
                result.add(setB);
                return result;
            }
        }

        // If no solution is found, return an empty list
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 7, 15, 29, 11, 9));
        ArrayList<ArrayList<Integer>> result = avgset(A);

        if (result.isEmpty()) {
            System.out.println("No solution exists.");
        } else {
            for (ArrayList<Integer> partition : result) {
                System.out.print(partition + " ");
            }
        }
    }
}
