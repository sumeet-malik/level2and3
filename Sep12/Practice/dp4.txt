class Solution {
    long MOD = 1000000007;
    public int distinctSubseqII(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = 2;
        
        int[] lo = new int[26];
        lo[s.charAt(0) - 'a'] = 1;
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = (2 * dp[i - 1]) % MOD;
            
            int ch = s.charAt(i - 1) - 'a';
            if(lo[ch] != 0){
                dp[i] = (dp[i] - dp[lo[ch] - 1] + MOD) % MOD;
            }
            
            lo[ch] = i;
        }
        
        return (int)dp[s.length()] - 1;
    }
}