class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        int n=seq.length();
        int[] ans=new int[n];
        int dept=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                //assign 0 or 1 base on current
                ans[i]=dept%2;
                dept++;
            }else{
                dept--;
                ans[i]=dept%2;
            }
        }
        return ans;
    }
}