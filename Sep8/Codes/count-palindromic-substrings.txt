class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        
        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                
                if(dp[i][j]){
                    res++;
                }
            }
        }
        
        return res;
    }
}