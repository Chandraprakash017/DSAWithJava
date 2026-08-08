package Arrays;
import java.util.*;
public class Duplicates {
    public static void main(String[] args) {
        int[] arr={1,2,1,4,2,5};
        Arrays.sort(arr);
        Vector<Integer> ans = new Vector<>();
        ans.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                ans.add(arr[i]);

            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
