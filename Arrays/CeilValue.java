package Arrays;

public class CeilValue {
    public static int ceil(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;
        System.out.println(ceil(arr, target));
    }
}
    

