package Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr={1,6,3,0,7};
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;

            }
        }
        int i=0;
        int j=n-1;
        while(i!=j){
            if(arr[i]>arr[j]){
                System.out.println("False");
                
            }
            else{
                System.out.println("true");
                break;

            }
            i++;
            j--;
        }

    }
    
}
