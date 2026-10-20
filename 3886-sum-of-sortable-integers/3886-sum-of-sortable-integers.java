import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        
        // 1. Precompute prefix maximums and suffix minimums for boundary checks
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        
        prefMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }
        
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }
        
        // 2. Precompute internal descents (where nums[i] > nums[i+1])
        int[] drop = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                drop[i] = 1;
            }
        }
        
        int[] prefDrops = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefDrops[i + 1] = prefDrops[i] + drop[i];
        }
        
        long totalSum = 0;
        
        // 3. Iterate over all possible divisors k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            
            boolean possible = true;
            
            // Check boundary conditions between adjacent blocks
            for (int i = k; i < n; i += k) {
                if (prefMax[i - 1] > suffMin[i]) {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                continue;
            }
            
            // Check each block of length k for rotatability
            for (int start = 0; start < n; start += k) {
                int end = start + k;
                
                // Count internal descents in this block
                int descents = prefDrops[end - 1] - prefDrops[start];
                
                // Check circular boundary descent
                if (nums[end - 1] > nums[start]) {
                    descents++;
                }
                
                // A block can be rotated into sorted order if it has <= 1 descent
                if (descents > 1) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                totalSum += k;
            }
        }
        
        return (int) totalSum;
    }
}