class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        for(int coin: coins){
            for(int a = 0; a <= amount; a++){
                if(a >= coin){
                    dp[a] += dp[a - coin];
                }
            }
        }
        
        return dp[amount];
    }
}