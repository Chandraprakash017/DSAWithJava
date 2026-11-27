class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];

        for (int i = 0; i < n; i++) {
            int f1 = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f1 == 0) {
                    cnt++;
                }
            }
            freeCount[i] = cnt;
        }

        // dp[b] = max copies obtainable using at most budget b
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstGain = 1 + freeCount[i];

            // 1. First copy of item i (at most once per item type)
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstGain);
            }

            // 2. Extra copies of item i (+1 copy each, no extra freebies)
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}