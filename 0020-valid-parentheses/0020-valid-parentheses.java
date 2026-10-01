class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']'){
                if(st.empty()){
                    return false;
                }
                else{
                    char c = st.pop();
                    if(ch==')'&& c!='(') return false;
                    if(ch=='}'&& c!='{') return false;
                    if(ch==']'&& c!='[') return false;
                    
                    

                }
            }

        }
        return st.empty();
        
    }
}