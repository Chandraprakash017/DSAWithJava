package Arrays;

public class PowerOfTwoRecursion {
    public static int power(int x,int y){
        if(y==0) return 1;
        if(y<0) return 1/power(x,-y);
        return x * power(x, y - 1);
    }
    public static void main(String[] args) {
        int x=2;
        int y=8;
        System.out.println(power(x, y));

    }
    
}
