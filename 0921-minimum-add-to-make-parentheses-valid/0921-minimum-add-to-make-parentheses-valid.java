class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int count=0;
        int back=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                back++;
            }
            else{
                if(back>0){
                    back--;
                }else{
                    count++;
                }

            }
            
        }
        
        
        return count+back;
        
    }
}