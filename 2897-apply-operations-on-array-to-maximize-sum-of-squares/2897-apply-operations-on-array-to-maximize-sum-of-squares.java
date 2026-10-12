import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        //Har bit position (0 to 31) par kitne 1s hain, count karo
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long MOD = 1_000_000_007;
        long totalSum = 0;
        
        //k elements banane ke liye top k numbers construct karo
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            // Har bit position ko check karo, agar wahan 1 available hai toh is number me daal do
            for (int i = 0; i < 32; i++) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--; // Woh bit use ho gaya, toh count kam kar do
                }
            }
            
            //Square add karte jao aur modulo lo
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}