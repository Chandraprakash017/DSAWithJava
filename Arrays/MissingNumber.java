package Arrays;
import java.util.*;
public class MissingNumber {
    public static void main(String[] args) {
        int arr[]={1,2,1,2,3,3,5};
        int n=arr.length;
        int xor=0;
        for(int i:arr){
            xor=xor^i;
        }
        System.out.print(xor);
        
    }
    
}
