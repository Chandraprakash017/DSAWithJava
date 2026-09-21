class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result=new long[k];
        long[] dp=new long[k];
        for(int num: nums){
            long[] nextdp=new long[k];
            int val=num%k;
            nextdp[val]++;
            for(int r=0;r<k;r++){
                if(dp[r]>0){
                    int nextR=(r*val)%k;
                    nextdp[nextR]+=dp[r];
                }
            }
            for(int r=0;r<k;r++){
                result[r]+=nextdp[r];
            }
            dp=nextdp;
                    }
            return result;

        
    }
}