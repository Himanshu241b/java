package April_2;
public class UniquePathsInMaze {
    public static int uniquePaths(int[][] maze) {
        int MOD = 1000000007;
        int N = maze.length;
        int M = maze[0].length;
        int[][] dp = new int[N][M];

        // Initialize dp array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (int)(((long)(i > 0 ? dp[i-1][j] : 0) + (long)(j > 0 ? dp[i][j-1] : 0)) % MOD);
                }
            }
        }

        return dp[N-1][M-1];
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {{0, 0}, {0, 0}},
                {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}},
                {{0, -1}, {-1, 0}}
        };

        for (int[][] testCase : testCases) {
            System.out.println(uniquePaths(testCase));
        }
    }
}

