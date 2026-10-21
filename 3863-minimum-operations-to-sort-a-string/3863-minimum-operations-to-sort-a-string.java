class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        if (isSorted(arr)) {
            return 0;
        }
        
        char minChar = arr[0], maxChar = arr[0];
        for (char c : arr) {
            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }
      
        if (n == 2) {
            return -1;
        }
        
      
        boolean minAtStart = (arr[0] == minChar);
        boolean maxAtEnd = (arr[n - 1] == maxChar);
        
        if (minAtStart || maxAtEnd) {
            return 1;
        }
        
        int minCount = 0, maxCount = 0;
        for (char c : arr) {
            if (c == minChar) minCount++;
            if (c == maxChar) maxCount++;
        }
      
        if (arr[0] == maxChar && maxCount == 1 && arr[n - 1] == minChar && minCount == 1) {
            return 3;
        }
        
       
        return 2;
    }
    
    private boolean isSorted(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}