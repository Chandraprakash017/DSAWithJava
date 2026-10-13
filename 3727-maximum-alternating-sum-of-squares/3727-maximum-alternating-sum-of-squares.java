class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
      
        long[] squares = new long[n];
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }
        
 
        Arrays.sort(squares);
        
        long totalSum = 0;
        int left = 0;        
        int right = n - 1; 
        boolean addFlag = true;
        
        while (left <= right) {
            if (addFlag) {
                totalSum += squares[right];
                right--;
            } else {
                totalSum -= squares[left];
                left++;
            }
            addFlag = !addFlag;
        }
        
        return totalSum;
    }
}