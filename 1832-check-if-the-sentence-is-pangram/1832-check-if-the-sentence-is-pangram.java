class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] ans=new boolean[26];
        for(char ch: sentence.toCharArray()){
            ans[ch-'a']=true;
        }
        for(boolean b: ans){
            if(!b) return false;
        }
        return true;
    }
}