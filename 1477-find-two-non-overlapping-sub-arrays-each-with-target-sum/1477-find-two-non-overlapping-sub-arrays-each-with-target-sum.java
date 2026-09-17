class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] minLenUntil = new int[n];
        
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
           
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int currLen = right - left + 1;
                
              
                if (left > 0 && minLenUntil[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currLen + minLenUntil[left - 1]);
                }
                
                bestSoFar = Math.min(bestSoFar, currLen);
            }
            
            minLenUntil[right] = bestSoFar;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}