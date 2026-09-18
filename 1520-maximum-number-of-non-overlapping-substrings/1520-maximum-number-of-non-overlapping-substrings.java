class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        
       
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) {
                left[c] = i;
            }
            right[c] = i;
        }
        
        List<String> res = new ArrayList<>();
        int lastRight = -1;
        
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            
           
            if (i == left[c]) {
                int newRight = getRightBoundary(i, s, left, right);
                
               
                if (newRight != -1) {
                    // If it starts after the last added substring's end, it's completely new
                    if (i > lastRight) {
                        res.add(""); 
                    }
                    // If it overlaps, it means this valid substring is fully contained 
                    // within the previous one. We replace the previous one to minimize length.
                    lastRight = newRight;
                    res.set(res.size() - 1, s.substring(i, lastRight + 1));
                }
            }
        }
        
        return res;
    }
    
    private int getRightBoundary(int start, String s, int[] left, int[] right) {
        int end = right[s.charAt(start) - 'a'];
        
        for (int i = start; i <= end; i++) {
            int c = s.charAt(i) - 'a';
          
            if (left[c] < start) {
                return -1;
            }
          
            end = Math.max(end, right[c]);
        }
        return end;
    }
}