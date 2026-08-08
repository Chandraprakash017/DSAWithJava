package Arrays;

public class ElementAppear {
    public static void main(String[] args) {

        int[] arr = {1,2,4,2,2,4,5};
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }

            if(count >= n/2) {
                System.out.println(arr[i]);
                return;
            }
        }

        System.out.println("No Majority Element");
    }
}