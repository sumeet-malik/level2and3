class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return Math.max(0, helper(grid, 0, 0, 0, dp));
    }
    
    public int helper(int[][] grid, int r1, int c1, int c2, Integer[][][] dp){
        int r2 = r1 + c1 - c2;
        
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length){
            return Integer.MIN_VALUE;
        } else if(grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        } else if(r1 == grid.length - 1 && c1 == grid[0].length - 1){
            return grid[r1][c1];
        } else if(dp[r1][c1][c2] != null){
            return dp[r1][c1][c2];
        }
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, helper(grid, r1 + 1, c1, c2, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1, c2 + 1, dp));
        max = Math.max(max, helper(grid, r1, c1 + 1, c2, dp));
        max = Math.max(max, helper(grid, r1, c1 + 1, c2 + 1, dp));
        
        int res;
        
        if(max == Integer.MIN_VALUE){
            res = Integer.MIN_VALUE;
        } else {
            res = grid[r1][c1];
            if(c1 != c2){
                res += grid[r2][c2];
            }
            
            res += max;
        }
        
        dp[r1][c1][c2] = res;
        return res;
    }
}