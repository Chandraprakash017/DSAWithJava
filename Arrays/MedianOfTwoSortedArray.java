package Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,6};
        int[] arr1={4,5,6};
        int[] ans=new int[arr.length+arr1.length];
        int p1=0;
        int p2=0;
        int p3=0;
        while(p1<arr.length && p2<arr1.length){
            // int val1=p1<arr.length? arr[p1]:Integer.MAX_VALUE;
            // int val2=p2<arr1.length? arr[p2]:Integer.MAX_VALUE;

            if(arr[p1]<arr1[p2]){
                ans[p3]=arr[p1];
                p1++;
            }
            else{
                ans[p3]=arr1[p2];
                p2++;
            }
            p3++;
        }
        while(p1<arr.length){
            ans[p3] = arr[p1++];
            p3++;
        }
        while(p2<arr1.length){
            ans[p3] = arr1[p2++];
            p3++;
        }

        for (int i : ans) {
            System.out.print(i+" ");
        }

        if(ans.length %2 != 0){
            int i= ans.length/2;
            System.out.println("Median " + ans[i]);
        }else{
            int i = (ans.length/2)-1;
            int j = (ans.length/2);
            // System.out.println();
            // System.out.println(i +   j);



            double k = (ans[i]+ans[j])/2.0;
            System.out.println("Median " + k);
        }




        
                
        
    }
    
}
