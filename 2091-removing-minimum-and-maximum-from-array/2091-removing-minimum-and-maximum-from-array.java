class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int idx1 = 0;
        int idx2=0;
        for(int i = 1; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
                idx1=i;
            }
            if(nums[i] > max){
                max = nums[i];
                idx2=i;
            }
        }
        int left=Math.min(idx1,idx2);
        int right=Math.max(idx1,idx2);
        int dl=right+1;
        int dr=n-left;
        int db=(left + 1) + (n - right);


        return Math.min(dl,Math.min(dr,db));
        
    }
}