class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int left=0;
        int right=n-1;
        while(left<right){
            if(s[left]!=s[right]){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            }
            left++;
            right--;

        }
        
    }
}