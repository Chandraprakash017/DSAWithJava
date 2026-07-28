package Arrays;
import java.util.*;
public class FindMaxFreq {
    static void getFreq(int arr[]){
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num: arr){
            freq.put(num,freq.getOrDefault(num, 0)+1);
        }
        for(int k: freq.keySet()){
            System.out.println(k+" -> "+freq.get(k));
        }
    }


    public static void main(String[] args) {
    int arr[]={1,1,2,2,3,1,3,3,4,4,5,5,5,5,5};
    getFreq(arr);
    
        
    }
    
}
