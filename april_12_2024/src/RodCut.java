import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RodCut {
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        // Add 0 and A to the weak points
        B.add(0);
        B.add(A);

        // Sort the weak points
        B.sort(null);

        int n = B.size();

        // Initialize dp array to store the cost of cutting from i to j
        int[][] dp = new int[n][n];

        // Initialize cuts map to store the order of cuts
        Map<String, ArrayList<Integer>> cuts = new HashMap<>();

        // Calculate the cost and order of cuts using bottom-up dynamic programming
        for (int len = 2; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                ArrayList<Integer> cutOrder = new ArrayList<>();

                for (int k = left + 1; k < right; k++) {
                    int cost = dp[left][k] + dp[k][right] + B.get(right) - B.get(left);
                    if (cost < dp[left][right]) {
                        dp[left][right] = cost;
                        cutOrder.clear();
                        cutOrder.add(B.get(k));
                        cutOrder.addAll(cuts.getOrDefault(left + "-" + k, new ArrayList<>()));
                        cutOrder.addAll(cuts.getOrDefault(k + "-" + right, new ArrayList<>()));
                        cuts.put(left + "-" + right, cutOrder);
                    }
                }
            }
        }

        // Return the order of cuts
        return cuts.get("0-" + (n - 1));
    }
}
