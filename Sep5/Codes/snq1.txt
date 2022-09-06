class Solution {
    public boolean backspaceCompare(String s, String t) {
        String res1 = process(s);
        String res2 = process(t);
        return res1.equals(res2);
    }
    
    public String process(String s){
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch != '#'){
                st.push(ch);
            } else if(st.size() > 0){
                st.pop();
            } else {
                // nothing
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            char ch = st.pop();
            sb.append(ch);
        }
        
        return sb.toString();
    }
}