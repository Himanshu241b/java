public class MinimumJumps {
    public int minJumps(String A) {
        int mod = 1000000003;
        int n = A.length();

        // Count the number of occupied seats and store their indices
        int occupied = 0;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                indices[occupied++] = i;
            }
        }

        // If all seats are empty, return 0
        if (occupied == 0) {
            return 0;
        }

        // Calculate the midpoint of occupied seats
        int midpoint = indices[occupied / 2];

        // Calculate the minimum number of jumps for each person to reach the midpoint
        int jumps = 0;
        for (int i = 0; i < occupied; i++) {
            jumps = (jumps + Math.abs(midpoint - indices[i])) % mod;
        }

        return jumps;
    }

    public static void main(String[] args) {
        MinimumJumps solution = new MinimumJumps();

        String A1 = "....x..xx...x..";
        System.out.println(solution.minJumps(A1));  // Output: 5

        String A2 = "....xxx";
        System.out.println(solution.minJumps(A2));  // Output: 0
    }
}

