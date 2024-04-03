package March_28;
import java.util.ArrayDeque;
import java.util.Queue;

public class BobAndArcade {

    public static int minTrampolineJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.poll();
                if (current == n - 1) return jumps;
                for (int i = current + 1; i <= Math.min(n - 1, current + arr[current]); i++) {
                    if (!visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
            jumps++;
        }

        return -1; // If unable to reach the last shop
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {2, 1, 3, 2, 4},
                {3, 2, 1},
                {1, 0, 3, 2, 1},
                {1, 1, 1, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println(minTrampolineJumps(testCase));
        }
    }
}

