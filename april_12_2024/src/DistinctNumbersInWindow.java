import java.util.*;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of the window:");
        int B = scanner.nextInt();

        int[] result = countDistinctInWindows(A, B);
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] countDistinctInWindows(int[] A, int B) {
        int n = A.length;
        if (B > n) {
            return new int[0]; // Return empty array if B > N
        }

        int[] result = new int[n - B + 1];
        Map<Integer, Integer> map = new HashMap<>();

        // Count distinct elements in the first window
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        result[0] = map.size();

        // Slide the window and update result array
        for (int i = 1; i <= n - B; i++) {
            int left = i - 1;
            int right = i + B - 1;

            // Remove the element going out of the window
            if (map.get(A[left]) == 1) {
                map.remove(A[left]);
            } else {
                map.put(A[left], map.get(A[left]) - 1);
            }

            // Add the new element coming into the window
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);

            // Update the result array with distinct count in the current window
            result[i] = map.size();
        }

        return result;
    }
}

