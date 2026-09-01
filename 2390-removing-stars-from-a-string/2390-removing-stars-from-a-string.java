import java.util.*;

class Solution {
    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for (int ch = 0; ch < s.length(); ch++) {

            if (s.charAt(ch) != '*') {
                st.push(s.charAt(ch));
            } else {
                st.pop();
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char c : st) {
            ans.append(c);
        }

        return ans.toString();
    }
}