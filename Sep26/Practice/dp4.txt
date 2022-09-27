class Solution {
    String[] arr;
    public int findMaxForm(String[] strs, int m, int n) {
        arr = strs;
        int[][][] dp = new int[arr.length][m + 1][n + 1];
        return helper(0, m, n, dp);
    }
    
    
    public int helper(int idx, int m, int n, int[][][] dp){
        if(idx == arr.length) {
            return 0;
        } else if(dp[idx][m][n] != 0){
            return dp[idx][m][n];
        }
        
        int czeroes = 0;
        int cones = 0;
        for(char ch: arr[idx].toCharArray()){
            if(ch == '0'){
                czeroes++;
            } else {
                cones++;
            }
        }
        
        int len1 = 0;
        if(czeroes <= m && cones <= n){
            len1 = 1 + helper(idx + 1, m - czeroes, n - cones, dp);
        }
        
        int len2 = 0 + helper(idx + 1, m, n, dp);
        int res = Math.max(len1, len2);
        
        dp[idx][m][n] = res;
        return res;
    }
}