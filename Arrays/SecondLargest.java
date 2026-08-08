package Arrays;
import java.util.*;
public class SecondLargest {
    public static void main(String[] args) {
        
    
    int[] arr={1,2,3,4,5};
    int largest=-1;
    int slargest=-1;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>largest){
            slargest=largest;
            largest=arr[i];
        }
        if(arr[i]<largest && arr[i]>slargest &&arr[i]!=largest){

            slargest=arr[i];
        }
    }
    System.out.println("The Largest Number is: "+slargest);
    
}
}