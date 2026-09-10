import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String s) {
      
        String[] words=s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> charToWord = new HashMap<>();
        HashSet<String> mappedWords = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (charToWord.containsKey(currentChar)) {
                if (!charToWord.get(currentChar).equals(currentWord)) {
                    return false;
                }
            } else {
               
                if (mappedWords.contains(currentWord)) {
                    return false;
                }
                charToWord.put(currentChar, currentWord);
                mappedWords.add(currentWord);
            }
        }
        
        return true;
    }
}