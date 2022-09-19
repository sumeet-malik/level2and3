class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }
    
    public int helper(int[] boxes, int i, int j, int k, int[][][] dp){
        if(i > j){
            return 0;
        }
        
        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        
        int ii = i;
        int kk = k;
        while(ii + 1 <= j && boxes[ii + 1] == boxes[ii]){
            ii++;
            kk++;
        }
        
        int res = (kk + 1) * (kk + 1) + helper(boxes, ii + 1, j, 0, dp);
        for(int m = ii + 1; m <= j; m++){
            if(boxes[m] == boxes[ii]){
                int fact = helper(boxes, ii + 1, m - 1, 0, dp) + 
                           helper(boxes, m, j, kk + 1, dp);
                res = Math.max(res, fact);
            }
        }
        
        dp[i][j][k] = res;
        return res;
    }
}