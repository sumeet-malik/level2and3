class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        
        for(int i = 2; i < dp.length; i++){
            int f2 = dp[p2] * 2;
            int f3 = dp[p3] * 3;
            int f5 = dp[p5] * 5;
            
            dp[i] = Math.min(f2, Math.min(f3, f5));
            
            if(dp[i] == f2){
                p2++;
            }
            if(dp[i] == f3){
                p3++;
            }
            if(dp[i] == f5){
                p5++;
            }
        }
        
        return dp[n];
    }
}