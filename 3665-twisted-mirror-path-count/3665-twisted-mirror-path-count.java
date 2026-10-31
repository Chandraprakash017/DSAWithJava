class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;

        // go[r][c][dir] stores an int[] of size 3: {next_r, next_c, next_dir}
        // dir: 0 = down, 1 = right
        int[][][][] go = new int[m][n][2][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 2; dir++) {
                    go[i][j][dir] = simulate(grid, i, j, dir);
                }
            }
        }

        // dp[i][j][0] -> ways to arrive at (i, j) moving DOWN
        // dp[i][j][1] -> ways to arrive at (i, j) moving RIGHT
        long[][][] dp = new long[m][n][2];

        // Base case: Starting at (0, 0)
        int[] firstDown = simulate(grid, 0, 0, 0);
        if (firstDown != null) {
            dp[firstDown[0]][firstDown[1]][firstDown[2]] = (dp[firstDown[0]][firstDown[1]][firstDown[2]] + 1) % MOD;
        }

        int[] firstRight = simulate(grid, 0, 0, 1);
        if (firstRight != null) {
            dp[firstRight[0]][firstRight[1]][firstRight[2]] = (dp[firstRight[0]][firstRight[1]][firstRight[2]] + 1) % MOD;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 2; dir++) {
                    long ways = dp[i][j][dir];
                    if (ways == 0) continue;
                    if (i == m - 1 && j == n - 1) continue; // Already at target

                    // From (i, j), we can make a move in either direction (down or right)
                    for (int nextDir = 0; nextDir < 2; nextDir++) {
                        int[] next = go[i][j][nextDir];
                        if (next != null) {
                            int nr = next[0], nc = next[1], nd = next[2];
                            dp[nr][nc][nd] = (dp[nr][nc][nd] + ways) % MOD;
                        }
                    }
                }
            }
        }

        long totalPaths = (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
        return (int) totalPaths;
    }

    private int[] simulate(int[][] grid, int r, int c, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        while (true) {
            if (dir == 0) r++;
            else c++;

            if (r < 0 || r >= m || c < 0 || c >= n) return null; // Out of bounds

            if (grid[r][c] == 0) {
                return new int[] { r, c, dir };
            } else {
                // Hit a mirror, reflect direction:
                // Entering moving right (1) -> turns down (0)
                // Entering moving down (0) -> turns right (1)
                dir = 1 - dir;
            }
        }
    }
}