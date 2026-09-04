class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        //from i to n-1
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Maximum from left
        int maxLeft = nums[0];

        for (int i = 0; i < n; i++) {

            maxLeft = Math.max(maxLeft, nums[i]);

            int minRight = suffixMin[i];

            int instability = maxLeft - minRight;

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }
}