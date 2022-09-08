class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        
        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                
                for(int lk = g + 1, rk = 1; lk >= 1; lk--, rk++){
                    int left = (lk == g + 1? 0: dp[i][j - lk]);
                    int right = (rk == g + 1? 0: dp[i + rk][j]);
                    int val = (i - 1 >= 0? nums[i - 1]: 1) * 
                              nums[i + rk - 1] * 
                              (j + 1 < nums.length? nums[j + 1]: 1);
                    
                    dp[i][j] = Math.max(dp[i][j], left + right + val);
                }
                
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}