class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int currentScore = stack.pop();
                
              
                int addedScore = (innerScore == 0) ? 1 : 2 * innerScore;
                
                stack.push(currentScore + addedScore);
            }
        }

        return stack.pop();
    }
}