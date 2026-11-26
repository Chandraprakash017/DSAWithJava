class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        int k=10;
        while(n>=k){
            n-=k;
            k--;
        if(k==0){
            break;
        }

        }
        return k%2==9%2;
    }
}