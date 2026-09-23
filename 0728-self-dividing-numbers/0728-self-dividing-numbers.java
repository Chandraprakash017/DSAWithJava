class Solution {
    public boolean check(int val){
        int temp = val;
        while(temp!=0){
            int digit = temp % 10;
            if(digit==0) return false;
            if(val % digit != 0) return false;
            temp /= 10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> arr=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i)) arr.add(i);
        }
        return arr;
    }
}