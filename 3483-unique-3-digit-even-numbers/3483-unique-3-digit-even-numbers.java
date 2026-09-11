class Solution {
    public int totalNumbers(int[] digits) {
    
        int[] availableCount = new int[10];
        for (int digit : digits) {
            availableCount[digit]++;
        }
        
        int total = 0;
        for (int i = 100; i <= 998; i += 2) {
            int[] currentCount = new int[10];
            int temp = i;
            
            while (temp > 0) {
                currentCount[temp % 10]++;
                temp /= 10;
            }
        
            boolean canForm = true;
            for (int j = 0; j < 10; j++) {
                if (currentCount[j] > availableCount[j]) {
                    canForm = false;
                    break;
                }
            }
            
          
            if (canForm) {
                total++;
            }
        }
        
        return total;
    }
}