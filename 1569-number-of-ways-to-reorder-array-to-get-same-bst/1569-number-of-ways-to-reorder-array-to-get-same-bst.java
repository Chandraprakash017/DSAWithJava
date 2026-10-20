import java.util.*;

class Solution {
    private static final int MOD = 1000000007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        combinations = new long[n + 1][n + 1];
        
        // Precompute binomial coefficients using Pascal's identity
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) (countWays(list) - 1 + MOD) % MOD;
    }

    private long countWays(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        int lSize = left.size();
        int rSize = right.size();

        // Ways to interleave left and right elements * ways for left subtree * ways for right subtree
        long ways = combinations[lSize + rSize][lSize];
        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;
    }
}