import java.util.Scanner;

public class PainterProblem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of boards:");
        int numberOfBoards = scanner.nextInt();

        System.out.println("Enter the number of painters:");
        int numberofPainters = scanner.nextInt();

        int[] boards = new int[numberOfBoards];
        System.out.println("Enter the lengths of the boards:");
        for (int board = 0; board < numberOfBoards; board++) {
            boards[board] = scanner.nextInt();
        }

        scanner.close();

        // Calculate the minimum time to paint all boards
        int minTime = calculateMinimumTime(boards, numberofPainters);
        System.out.println("Minimum time required to paint all boards: " + minTime);
    }

    // Function to calculate the minimum time to paint all boards
    private static int calculateMinimumTime(int[] boards, int noOFPainters) {
        int total = 0;
        int max = 0;

        // Calculate the total length of all boards and find the maximum length
        for (int board : boards) {
            total += board;
            max = Math.max(max, board);
        }

        int left = max;
        int right = total;

        // Apply binary search to find the minimum time
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(boards, noOFPainters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Helper function to check if it's possible to paint all boards within given time
    private static boolean isValid(int[] boards, int noOFPainters, int time) {
        int painters = 1;
        int currentLength = 0;

        for (int board : boards) {
            currentLength += board;
            if (currentLength > time) {
                painters++;
                currentLength = board;
            }
        }

        return painters <= noOFPainters;
    }
}

