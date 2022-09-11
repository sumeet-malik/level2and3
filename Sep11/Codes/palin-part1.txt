class Solution {
    boolean[][] ip;
    
    void IsPalindrome(String s){
        ip = new boolean[s.length()][s.length()];
        for(int g= 0; g < ip[0].length; g++){
            for(int i = 0, j = g; j < ip[0].length; i++, j++){
                if(g == 0){
                    ip[i][j] = true;
                } else if(g == 1){
                    ip[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                   ip[i][j] = s.charAt(i) == s.charAt(j) && ip[i + 1][j - 1] == true; 
                }
            }
        }
    }
    
    
    public List<List<String>> partition(String s) {
        IsPalindrome(s);
        List<List<String>>[] dp = new List[s.length()];
        return helper(s, s.length() - 1, dp);
    }
    
    public List<List<String>> helper(String s, int j, List[] dp){
        if(j < 0){
            List<List<String>> bres = new ArrayList<>();
            List<String> blist = new ArrayList<>();
            bres.add(blist);
            return bres;
        } 
        
        if(dp[j] != null){
            return (List<List<String>>)dp[j];
        }
      
        
        List<List<String>> mres = new ArrayList<>();
        
        for(int i = j; i >= 0; i--){
            if(ip[i][j] == true){
                String palin = s.substring(i, j + 1);
                
                List<List<String>> rres = helper(s, i - 1, dp);
                for(List<String> rlist: rres){
                    ArrayList<String> mlist = new ArrayList<>(rlist);
                    mlist.add(palin);
                    mres.add(mlist);
                }
            }
        }
        
        dp[j] = mres;
        return mres;
    }
}