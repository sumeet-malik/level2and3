class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return helper(grid, 0, 0, grid[0].length - 1, dp);
    }
    
    public int helper(int[][] grid, int r1, int c1, int c2, Integer[][][] dp){
        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length || r1 >= grid.length){
            return Integer.MIN_VALUE;
        } else if(dp[r1][c1][c2] != null){
            return dp[r1][c1][c2];
        }
        
        int r2 = r1;
        int res = grid[r1][c1];
        if(c1 != c2){
            res += grid[r2][c2];
        }
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2 - 1, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2 + 1, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1, c2 - 1, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1,  c2, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1, c2 + 1, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2 - 1, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2, dp));
        max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2 + 1, dp));
        if(max != Integer.MIN_VALUE){
            res += max;
        }
        
        dp[r1][c1][c2] = res;
        return res;
    }
}