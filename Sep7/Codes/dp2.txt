class Solution {
    public int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        
        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    dp[i][j] = 0;
                } else if(g == 1){
                    dp[i][j] = 0;
                } else if(g == 2){
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                } else {
                   dp[i][j] = Integer.MAX_VALUE;
                    
                    for(int lk = g - 1, rk = 1; lk >= 1; lk--, rk++){
                        int left = dp[i][j - lk];
                        int right = dp[i + rk][j];
                        int value = arr[i] * arr[i + rk] * arr[j];
                        dp[i][j] = Math.min(dp[i][j], left + right + value);
                    }
                }
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}