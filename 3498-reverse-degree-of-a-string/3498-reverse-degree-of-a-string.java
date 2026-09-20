class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int sum=0;
        int product=1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            product=(26-(ch-'a'))*(i+1);
            sum+=product;
            
            

        }
        return sum;
        
    }
}