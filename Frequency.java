public class Frequency {
    static void freqCount(String s){
        int[] freq=new int[26];
        for(char c: s.toLowerCase().toCharArray()){
            if(c >= 'a' && c <= 'z'){
                freq[c - 'a']++;
            }
        }
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                System.out.println((char)('a' + i) + " " + freq[i]);
            }
        }
    }
    public static void main(String[] args) {
        String str="Chandra";
        freqCount(str);
        
    }
    
}