class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        } else if(s1.equals(s2)){
            return true;
        }
        
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                for(int j = 0; j <= n - len; j++){
                    if(len == 1){
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for(int k = 1; k <= len - 1; k++){
                            if(dp[i][j][len] == false){
                                boolean f1 = dp[i][j][k] && dp[i + k][j + k][len - k];
                                boolean f2 = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                                dp[i][j][len] = f1 || f2;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}