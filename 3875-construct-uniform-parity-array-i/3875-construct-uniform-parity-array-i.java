class Solution { 
    public boolean uniformArray(int[] nums1) { 
        int minOdd = Integer.MAX_VALUE; 
        
        // Step 1: Find the smallest odd number in the array
        // for (int x : nums1) { 
        //     if (x % 2 != 0) { // works for positive and negative odds
        //         minOdd = Math.min(minOdd, x); 
        //     } 
        // } 
        
        // // Step 2: If an even number is smaller than the minimum odd number, return false
        // for (int x : nums1) { 
        //     if (x % 2 == 0 && minOdd != Integer.MAX_VALUE && x < minOdd) { 
        //         return false; 
        //     } 
        // } 
        
        return true; 
    } 
}
