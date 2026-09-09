class Solution {
    public long countCommas(long n) {
         long count = 0;
         long base=1000;
       while(n>=base){
        count+=(n-base+1);
        base*=1000;
       }
        return count;
        
    }
}