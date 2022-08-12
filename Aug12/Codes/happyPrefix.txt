class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        
        int len = 0;
        int i = 1;
        while(i < lps.length){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len + 1;            
                len++;
                i++;
            } else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            } else {
                len = lps[len - 1];
            }
        }
        
        int k = lps[s.length() - 1];
        return s.substring(0, k);
    }
}