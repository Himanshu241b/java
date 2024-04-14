import java.util.ArrayList;
import java.util.Collections;

public class SteppingNumbers {
    public static ArrayList<Integer> findSteppingNumbers(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        // Base case: If A is 0, add it to the result as it's a stepping number
        if (A == 0) {
            result.add(0);
        }

        // Perform BFS starting from each digit from 1 to 9
        for (int i = 1; i <= 9; i++) {
            bfs(A, B, i, result);
        }

        // Sort the result array in ascending order
        Collections.sort(result);

        return result;
    }

    private static void bfs(int A, int B, int num, ArrayList<Integer> result) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int current = queue.remove(0);

            if (current >= A && current <= B) {
                result.add(current);
            }

            // Get the last digit of the current number
            int lastDigit = current % 10;

            // Generate stepping numbers by appending lastDigit + 1 and lastDigit - 1
            if (lastDigit - 1 >= 0) {
                queue.add(current * 10 + (lastDigit - 1));
            }
            if (lastDigit + 1 <= 9) {
                queue.add(current * 10 + (lastDigit + 1));
            }
        }
    }

    public static void main(String[] args) {
        int A = 10;
        int B = 20;
        ArrayList<Integer> steppingNumbers = findSteppingNumbers(A, B);

        // Print the stepping numbers
        System.out.println(steppingNumbers);
    }
}
