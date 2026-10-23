class Solution {
    public int countSegments(String s) {
        //if(s.equals("")) return 0;
        // String[] arr = s.split(" ");
        // return arr.length;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '&&(i==0 || s.charAt(i-1)==' ')){
                count++;
            }
        }
        return count;
    }
}