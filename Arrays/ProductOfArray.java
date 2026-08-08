package Arrays;
import java.util.*;
public class ProductOfArray {
    public static void main(String[] args) {
        //product of array excapt self
        int[] arr={1,2,3,4};
        Vector<Integer>ans = new Vector<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int prod=1;
        for(int j=0;j<n;j++){
            if(i!=j){
            
            prod*=arr[j];
            }
            
                
           


        }
        
        ans.add(prod);
    }
        
        System.out.println(ans);



        //Output=[24,12,8,6].

    }
    
}
