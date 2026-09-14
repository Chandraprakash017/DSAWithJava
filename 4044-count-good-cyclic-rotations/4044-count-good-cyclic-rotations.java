class Solution {
    public int countGoodRotations(int[] nums) {
        long total=0;
        long half=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int c=0;
        for(int i=0;i<n/2;i++){
            half+=nums[i];
        }
        for(int i=0;i<n;i++){
            if(2*half>total){
                c++;
            }
            half-=nums[i];
            half+=nums[(i+n/2)%n];
        }
        return c;
        
    }
}