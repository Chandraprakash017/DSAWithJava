package Arrays;

public class BinarySearch {
    static void search(int[] arr){
        int target = 3;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(arr[mid] == target)
            {
                System.out.println("Found at index " + mid);
                return;
            }

            else if(arr[mid] < target)
            {
                low = mid + 1;
            }

            else
            {
                high = mid - 1;
            }
        }
    }
    public static void main(String[] args) {
        // int[] arr={11,22,33,66,98};
        int[] arr={1,2,2,2,3,3,3,4,4};
        search(arr);
    }
    
}
