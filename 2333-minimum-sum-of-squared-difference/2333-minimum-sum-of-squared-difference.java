import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalOps = (long) k1 + k2;
        int maxDiff = 0;
        int[] diffCounts = new int[100001];
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffCounts[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }
        
        
        for (int d = maxDiff; d > 0; d--) {
            if (diffCounts[d] == 0) continue;
            
            long opsToUse = Math.min(totalOps, (long) diffCounts[d]);
            
            diffCounts[d] -= opsToUse;
            diffCounts[d - 1] += (int) opsToUse;
            totalOps -= opsToUse;
            
            if (totalOps == 0) break;
        }
        
      
        long minSumSqDiff = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (diffCounts[d] > 0) {
                minSumSqDiff += (long) diffCounts[d] * d * d;
            }
        }
        
        return minSumSqDiff;
    }
}