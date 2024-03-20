import java.util.HashMap;

public class FourSum {

    public static String checkFourSum(int[] nums, int target) {
        int n = nums.length;

        // Create a HashMap to store the sum of pairs of elements and their indices
        HashMap<Integer, int[]> pairSumMap = new HashMap<>();

        // Populate the HashMap with the sum of pairs of elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                pairSumMap.put(sum, new int[]{i, j});
            }
        }

        // Check for quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int complement = target - sum;

                if (pairSumMap.containsKey(complement)) {
                    int[] indices = pairSumMap.get(complement);
                    // Check if all indices are different
                    if (indices[0] != i && indices[1] != i && indices[0] != j && indices[1] != j) {
                        return "Yes";
                    }
                }
            }
        }

        // No quadruplet found
        return "No";
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 3, 3, 10, 2},
                {2, 4, 6, 3, 1, 1},
                {0, 10, 1, 2, 2},
                {-2, 12, -1, 1, 20, 1}
        };
        int[] targets = {9, 20, 15, 20};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1) + ": " + checkFourSum(testCases[i], targets[i]));
        }
    }
}
