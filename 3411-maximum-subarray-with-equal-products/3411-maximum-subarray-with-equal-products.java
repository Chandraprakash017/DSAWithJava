class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                g = (j == i) ? val : gcd(g, val);
                l = (j == i) ? val : lcm(l, val);

        
                if (prod > 2520L * g) {
                    prod = Long.MAX_VALUE;
                } else {
                    prod *= val;
                }

                if (prod == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }
}