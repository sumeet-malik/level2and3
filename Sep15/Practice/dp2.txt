class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        int n = dp.length - 1;
        int m = dp[0].length - 1;
        for(int i = n; i >= 0; i--){
            for(int j = m; j >= 0; j--){
                if(i == n && j == m){
                    dp[i][j] = true;
                } else if(j == m){
                    dp[i][j] = false;
                } else if(i == n){
                    if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                        dp[i][j] = dp[i][j + 2];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                            dp[i][j] = dp[i + 1][j] || dp[i][j + 2]; 
                        } else {
                            dp[i][j] = dp[i][j + 2];
                        }
                    } else {
                        if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                            dp[i][j] = dp[i + 1][j + 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}