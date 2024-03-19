import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithZeroSum {
    public static int longestSubarrayWithZeroSum(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        // Initialize the map with (0, -1) to handle cases where the zero sum starts from the beginning
        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If the sum is seen before, update the maxLength
            if (sumMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum));
            } else {
                // Store the sum along with its index
                sumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter " + size + " elements of array:");
        for(int i = 0; i < size; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println("Length of the longest subarray with zero sum: " + longestSubarrayWithZeroSum(nums)); // Output: 5
    }
}
