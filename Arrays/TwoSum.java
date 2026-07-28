package Arrays;
import java.util.*;
public class TwoSum {
    public int[] twoSum(int arr[],int target){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    int ans[]={i,j};
                    return ans;
                }
            }
        }
        int ans[]={};
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int target=9;
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(arr, target);
        for(int i: result){
        System.out.println(result[i]);
        }
        
    }
    
}
