class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            } else if(st.size() == 0){
                st.push(ch);
            } else if(st.peek() == ')'){
                st.push(ch);
            } else {
                st.pop();
            }
        }
        
        return st.size();
    }
}