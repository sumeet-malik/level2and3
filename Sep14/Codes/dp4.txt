class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        dp[row][column][0] = 1;
        
        int[][] dirs = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        for(int move = 1; move <= k; move++){
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    for(int[] dir: dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if(x >= 0 && x < n && y >= 0 && y < n){
                            dp[x][y][move] += dp[i][j][move - 1] / 8;
                        }
                    }
                }
            }
        }
        
        double res = 0;
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                res += dp[i][j][k];
            }
        }
        
        return res;
    }
}