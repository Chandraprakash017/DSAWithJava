class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1000000007;
        int totalPoints = n + k - 1;
        int choose = 2 * k;
        
        // If we need to choose more points than are available, 0 ways.
        if (choose > totalPoints) {
            return 0;
        }
        
        long result = 1;
        // Compute (totalPoints C choose) % MOD using Fermat's Little Theorem
        for (int i = 1; i <= choose; i++) {
            result = result * (totalPoints - i + 1) % MOD;
            result = result * modInverse(i, MOD) % MOD;
        }
        
        return (int) result;
    }
    
    // Calculates (base^exp) % mod
    private long power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
    
    // Calculates modular inverse of n modulo mod
    private long modInverse(long n, int mod) {
        return power(n, mod - 2, mod);
    }
}