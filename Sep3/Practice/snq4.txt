class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(st.size() == 0 || arr[i] > 0 || st.peek() < 0){
                st.push(arr[i]);
            } else {
                while(st.size() > 0 && st.peek() > 0 && Math.abs(arr[i]) > st.peek()){
                    st.pop();
                }
                
                if(st.size() == 0 || st.peek() < 0){
                    st.push(arr[i]);
                } else if(Math.abs(arr[i]) == st.peek()){
                    st.pop();
                } else {
                    // do nothing
                }
            }
        }
        
        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while(st.size() > 0){
            ans[idx] = st.pop();
            idx--;
        }
        
        return ans;
    }
}