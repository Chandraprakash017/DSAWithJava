class Solution {
    public int addDigits(int num) {
        if(num==0){
            return 0;
        }
        while(num>9){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
            
        }
        num=sum;
    }
        // int count=0;
        // while(sum!=0){
        //     int d=sum%10;
        //     count+=d;
        //     sum/=10;

        // }
        return num;
        
    }
}