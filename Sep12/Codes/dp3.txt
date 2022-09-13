class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        
        int[] idxs = new int[primes.length];
        Arrays.fill(idxs, 1);
        
        for(int i = 2; i < dp.length; i++){
            long ans = Long.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idxs[j];
                
                ans = Math.min(ans, dp[idx] * prime);
            }
            
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idxs[j];
                
                if(ans == dp[idx] * prime){
                    idxs[j] = idx + 1;
                }
            }
            
            dp[i] = ans;
        }
        
        return (int)dp[n];
    }
}