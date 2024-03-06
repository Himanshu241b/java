import java.util.Scanner;

public class AyushStudying {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            System.out.println("Enter number of days:");
            int n = scanner.nextInt(); // Number of days
            System.out.println("Enter number of chapters:");
            int m = scanner.nextInt(); // Number of chapters
            int[] time = new int[m];   // Array to store time required for each chapter

            // Input time required for each chapter
            for (int i = 0; i < m; i++) {
                time[i] = scanner.nextInt();
            }

            int result = minimalMaxTime(n, m, time);
            System.out.println(result);
        }

        scanner.close();
    }

    public static int minimalMaxTime(int n, int m, int[] time) {
        // Binary search for the minimum maximum time
        int low = 1;
        int high = 1000000000; // 10^9

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, m, time, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean isValid(int n, int m, int[] time, int maxTime) {
        int days = 1;
        int currentWorkload = 0;

        for (int i = 0; i < m; i++) {
            // If the time required for the current chapter exceeds maxTime,
            // it's impossible to distribute workload within maxTime
            if (time[i] > maxTime) {
                return false;
            }

            // Check if current workload plus time for this chapter exceeds maxTime
            if (currentWorkload + time[i] > maxTime) {
                days++; // Move to the next day
                currentWorkload = 0; // Reset current workload
            }

            currentWorkload += time[i];
        }

        return days <= n; // Check if days required is less than or equal to n
    }
}
