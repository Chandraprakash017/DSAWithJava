class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // The target sum for our middle subarray
        int target = totalSum - x;
        
        // If target is negative, it's impossible to find a valid subarray
        if (target < 0) {
            return -1;
        }
        
        // If target is exactly 0, we need to remove all elements
        if (target == 0) {
            return nums.length;
        }
        
        int n = nums.length;
        int maxLen = -1;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
    
        return maxLen == -1 ? -1 : n - maxLen;
    }
}