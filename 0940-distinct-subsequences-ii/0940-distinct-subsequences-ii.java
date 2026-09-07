class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        int[] endsWith = new int[26];
        
        int totalSum = 0;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
          
            int currentNew = (totalSum + 1) % MOD;
        
            int added = (currentNew - endsWith[idx] + MOD) % MOD;
 
            endsWith[idx] = currentNew;
        
            totalSum = (totalSum + added) % MOD;
        }
        
        return totalSum;
    }
}