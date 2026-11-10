class Solution {
    public int climbStairs(int n, int[] costs) {
        
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int j = 1; j <= n; j++) {
            for (int i = Math.max(0, j - 3); i < j; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    
                    int costJ = costs[j - 1];
                    int jumpCost = costJ + (j - i) * (j - i);
                    dp[j] = Math.min(dp[j], dp[i] + jumpCost);
                }
            }
        }
        
        return dp[n];
    }
}