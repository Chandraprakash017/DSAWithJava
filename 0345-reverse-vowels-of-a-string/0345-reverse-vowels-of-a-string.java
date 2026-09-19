class Solution { 
    public String reverseVowels(String s) { 
       
        StringBuilder vowels = new StringBuilder(); 
        int n = s.length(); 
        
        for (int i = 0; i < n; i++) { 
            char ch = s.charAt(i); 
            if (isVowel(ch)) { 
                vowels.append(ch); 
            } 
        } 
        
       
        char[] arr = s.toCharArray();
        int idx = vowels.length() - 1; 
        
        for (int i = 0; i < n; i++) { 
            if (isVowel(arr[i])) { 
                arr[i] = vowels.charAt(idx--); 
            } 
        } 
        
        return new String(arr); 
    } 


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
