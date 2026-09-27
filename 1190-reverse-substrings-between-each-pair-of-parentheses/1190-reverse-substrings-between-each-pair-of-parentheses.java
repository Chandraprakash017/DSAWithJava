class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
       
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
       
        StringBuilder result = new StringBuilder();
        int i = 0;
        int direction = 1;
        
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
               
                i = pair[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
            i += direction;
        }
        
        return result.toString();
    }
}