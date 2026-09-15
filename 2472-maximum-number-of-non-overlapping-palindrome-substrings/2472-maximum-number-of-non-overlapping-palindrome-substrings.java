class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        
        // Step 1: Precompute all palindromes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }
        
        // Step 2: DP to find the maximum non-overlapping palindromes
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Option 1: Do not include the current character in a palindrome
            dp[i] = dp[i - 1];
            
            // Option 2: Try to form a palindrome ending at current character (index i-1)
            // We check all possible starting indices j where length >= k
            for (int j = i - k; j >= 0; j--) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n];
    }
}