import java.util.Scanner;

public class Jumps {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        if (n <= 1) {
            return 0; // If there is only one shop, no need to jump
        } else if (arr[0] == 0) {
            return -1; // If the first shop is unreachable, return -1
        }

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jumps; // Reached the last shop
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1; // Unable to reach the last shop
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of shops: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[size];
        System.out.print("Enter the space-separated  for each shop: ");
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        int minJumps = minJumps(arr);
        System.out.println("Minimum number of jumps needed: " + minJumps);
    }
}
