class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        
        boolean[] dupli = new boolean[256];
        int j = -1;
        for(int i = 0; i < s.length(); i++){
            char chi = s.charAt(i);
            if(dupli[chi] == true){
                while(j < i){
                    j++;
                    char chj = s.charAt(j);
                    dupli[chj] = false;
                    
                    if(chj == chi){
                        break;
                    }
                }
            }
            
            dupli[chi] = true;
            int len = i - j;
            res = Math.max(res, len);
        }
        
        return res;
    }
}