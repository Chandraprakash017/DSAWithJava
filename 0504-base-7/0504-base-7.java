class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        StringBuilder str=new StringBuilder();
        int temp= Math.abs(num);
        while(temp>0){
            str.append(temp%7);
            temp/=7;
        }
        if(num>0) return str.reverse().toString();
        else return "-"+str.reverse().toString();
    }
}