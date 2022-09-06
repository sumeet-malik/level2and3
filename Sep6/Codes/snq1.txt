class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int[] rem = new int[26];
        for(char ch: arr){
            rem[ch - 'a']++;
        }
        
        boolean[] ais = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(char ch: arr){
            rem[ch - 'a']--;
            
            if(ais[ch - 'a'] == false){
                while(st.size() > 0 && rem[st.peek() - 'a'] > 0 && ch < st.peek()){
                    ais[st.peek() - 'a'] = false;
                    st.pop();
                }
                
                st.push(ch);
                ais[ch - 'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.peek());
            st.pop();
        }
        
        return sb.reverse().toString();
    }
}