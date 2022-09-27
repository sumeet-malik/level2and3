class Solution {
    public int superEggDrop(int eggs, int n) {
        int[][] dp = new int[eggs + 1][n + 1];
        
        for(int e = 1; e <= eggs; e++){
            for(int f = 1; f <= n; f++){
                if (e == 1 || f <= 1){
                    dp[e][f] = f;
                } else {
                    int lo = 1;
                    int hi = f;
                    while(lo < hi){
                        int mid = (lo + hi) / 2;
                        int t1 = dp[e - 1][mid - 1];
                        int t2 = dp[e][f - mid];
                        
                        if(t1 < t2){
                            lo = mid + 1;
                        } else if(t2 < t1) {
                            hi = mid;
                        } else {
                            lo = mid;
                            break;
                        }
                    }
                    
                    dp[e][f] = 1 + Math.max(dp[e - 1][lo - 1], dp[e][f - lo]);
                }
            }
        }
        
        return dp[eggs][n];
    }
}