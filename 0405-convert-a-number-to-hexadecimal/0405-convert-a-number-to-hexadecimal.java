class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder str=new StringBuilder();
        
        while(num!=0){
            str.append(map[num & 15]);
            int rem=num%16;
            

            num=(num>>>4);
        }
        return str.reverse().toString();

        
    }
}