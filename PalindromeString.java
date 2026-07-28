public class PalindromeString {
    public static void main(String[] args) {
        String input = "civic";
        System.out.println(isPalindrome(input));
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            //     left++;
            // }
            // while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            //     right--;
            // }
            // if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            //     return false;
            // }
            left++;
            right--;
        }
        return true;
    }
}
