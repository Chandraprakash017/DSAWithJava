package Arrays;
import java.util.*;

public class ReverseArray {
    static void reverse(int arr[]){
    int n=arr.length;
    int i=0;
    int j=n-1;
    while(i<=j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    for(int k: arr){
        System.out.println(k);
    }
}
    static void shiftBy1(int arr[]){
        int n=arr.length;
        int temp=arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;

         for(int k: arr){
        System.out.print(k+" ");
    }
    }
    static void alternateDigit(int arr[]){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<=j){
            if(i==j){
                System.out.print(arr[i]);
                return;
            }
            else{
            System.out.print(arr[i]+" ");
            i++;
            System.out.print(arr[j]+" ");
            j--;
            }
        }
    } 
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        // reverse(arr);
        // shiftBy1(arr);
        // alternateDigit(arr);
        // for(int i=arr.length-1;i>=0;i--){
        //     System.out.print(arr[i]);
        // }
        
    }
    
}
