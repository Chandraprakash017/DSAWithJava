import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            
            // Fixed line: removed the stray '-' before isWhitespace
            if ((!Character.isDigit(currentChar) && !isWhitespace(currentChar)) || i == n - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
    
    private boolean isWhitespace(char c) {
        return c == ' ';
    }
}