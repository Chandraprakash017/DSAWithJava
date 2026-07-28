package Arrays;
import java.util.*;
public class ArrayPalindrome {
    public static void main(String[] args){
        
        int[] arr={1,1,2,2,3};
        int n=arr.length;
        int[] ans={};
	for(int i=0;i<n;i++){
		for(int j=1;j<n;j++){
			if(arr[i]==arr[j]){
				ans[i]=arr[i];
}}}
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]+" ");
        }

    }
    
}
