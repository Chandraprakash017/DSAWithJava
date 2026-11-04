import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] windowCost = new long[n - x + 1];
        
        // Two TreeMaps acting as multisets to maintain the sliding window median in O(log x)
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;
        
        // Helper to get total elements currently tracked
        // Target left size: (x + 1) / 2
        int targetLeft = (x + 1) / 2;
        
        for (int i = 0; i < n; i++) {
            // 1. Add incoming element
            if (left.isEmpty() || nums[i] <= left.lastKey()) {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                leftSum += nums[i];
                leftSize++;
            } else {
                right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                rightSum += nums[i];
                rightSize++;
            }
            
            // Balance sizes
            while (leftSize > targetLeft) {
                int val = left.lastKey();
                removeNum(left, val);
                leftSum -= val;
                leftSize--;
                
                right.put(val, right.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }
            while (leftSize < targetLeft && !right.isEmpty()) {
                int val = right.firstKey();
                removeNum(right, val);
                rightSum -= val;
                rightSize--;
                
                left.put(val, left.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            }
            
            // 2. Remove outgoing element if window size exceeds x
            if (i >= x) {
                int out = nums[i - x];
                if (left.containsKey(out)) {
                    removeNum(left, out);
                    leftSum -= out;
                    leftSize--;
                } else {
                    removeNum(right, out);
                    rightSum -= out;
                    rightSize--;
                }
                
                // Re-balance after removal
                while (leftSize > targetLeft) {
                    int val = left.lastKey();
                    removeNum(left, val);
                    leftSum -= val;
                    leftSize--;
                    
                    right.put(val, right.getOrDefault(val, 0) + 1);
                    rightSum += val;
                    rightSize++;
                }
                while (leftSize < targetLeft && !right.isEmpty()) {
                    int val = right.firstKey();
                    removeNum(right, val);
                    rightSum -= val;
                    rightSize--;
                    
                    left.put(val, left.getOrDefault(val, 0) + 1);
                    leftSum += val;
                    leftSize++;
                }
            }
            
            // 3. Record cost once window size reaches x
            if (i >= x - 1) {
                int median = left.lastKey();
                long cost = ((long) leftSize * median - leftSum) + (rightSum - (long) rightSize * median);
                windowCost[i - x + 1] = cost;
            }
        }
        
        // Step 2: Dynamic Programming to pick k non-overlapping windows.
        long INF = 1000000000000000L; // Safe large number below JS safe integer limit
        long[][] dp = new long[k + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        
        for (int j = 1; j <= k; j++) {
            for (int i = x * j; i <= n; i++) {
                dp[j][i] = Math.min(dp[j][i - 1], dp[j - 1][i - x] + windowCost[i - x]);
            }
        }
        
        return dp[k][n];
    }
    
    private void removeNum(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}