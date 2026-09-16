class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // Start backtracking 0 se
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> currentList, String s, int start) {
        
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        
       
        for (int end = start; end < s.length(); end++) {
       
            if (isPalindrome(s, start, end)) {
          
                currentList.add(s.substring(start, end + 1));
                
              
                backtrack(result, currentList, s, end + 1);
                
             
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    
   
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}