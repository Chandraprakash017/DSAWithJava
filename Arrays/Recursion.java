package Arrays;

public class Recursion {
    public static void printreverse(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printreverse(n-1);
        
    }
    public static void main(String[] args) {
        int n=10;
        printreverse(n);
    }
    
}
