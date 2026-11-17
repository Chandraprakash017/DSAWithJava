class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // 1. Precompute minimum changes to make s[l..r] a semi-palindrome
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                int len = r - l + 1;
                int best = Integer.MAX_VALUE;

                // Proper divisors d of len (1 <= d < len)
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;
                    // Check each of the d groups: offset rOff from 0 to d - 1
                    for (int rOff = 0; rOff < d; rOff++) {
                        int left = l + rOff;
                        int right = l + rOff + ((len - 1 - rOff) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[l][r] = best;
            }
        }

        // dp[i][j] = min changes to partition suffix s[i..n-1] into j parts
        int INF = 1_000_000_000;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[n][0] = 0;

        // 2. Partition into j parts from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                // Each semi-palindrome part must have length at least 2
                for (int end = i + 1; end < n; end++) {
                    if (dp[end + 1][j - 1] < INF) {
                        dp[i][j] = Math.min(dp[i][j], cost[i][end] + dp[end + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][k];
    }
}