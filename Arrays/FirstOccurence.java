package Arrays;

public class FirstOccurence {

    static int findFirstOccurrence(int[] arr){

        int target = 3;
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;   // left side dekh rhe
                
            }

            else if(arr[mid] < target){
                low = mid + 1;
            }

            else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,2,2,3,3,3,4,4};

        int result = findFirstOccurrence(arr);

        System.out.println("First Occurence of Target Is found At Index: "+result);
    }
}