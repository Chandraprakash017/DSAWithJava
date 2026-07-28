import java.util.*;
public class RotatedSortedArray {
  static  int search(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if(arr[low]<=arr[mid]){
                if(target>=arr[low] && target<arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(target>arr[mid]&&target<arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9,2,3,4};
        int res=search(arr,3);
        System.out.println(res);
        
    }
    
}
