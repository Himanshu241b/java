import java.util.*;

public class DistinctNumbersInWindow {

    public static int[] countDistinct(int[] A, int B) {
        int N = A.length;
        if (B > N) {
            return new int[0]; // Return an empty array if B > N
        }

        int[] result = new int[N - B + 1];
        Map<Integer, Integer> map = new HashMap<>();

        // Count distinct elements in the first window
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        result[0] = map.size();

        // Slide the window and update the count of distinct elements
        for (int i = B; i < N; i++) {
            int left = i - B; // Index of the leftmost element in the current window
            int removed = A[left]; // Element removed from the window
            int added = A[i]; // Element added to the window

            // Update count for removed element
            if (map.get(removed) == 1) {
                map.remove(removed);
            } else {
                map.put(removed, map.get(removed) - 1);
            }

            // Update count for added element
            map.put(added, map.getOrDefault(added, 0) + 1);

            // Update result array with the count of distinct elements in the current window
            result[left + 1] = map.size();
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A1 = {1, 2, 1, 3, 4, 3};
        int B1 = 3;
        int[] result1 = countDistinct(A1, B1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 3, 3, 2]

        int[] A2 = {1, 1, 2, 2};
        int B2 = 1;
        int[] result2 = countDistinct(A2, B2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 1, 1, 1]
    }
}
