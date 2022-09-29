class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int i = dungeon.length - 1; i >= 0; i--){
            for(int j = dungeon[0].length - 1; j >= 0; j--){
                int min = 0;
                
                if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
                    min = 1;
                } else if(i == dungeon.length - 1){
                    min = dp[i][j + 1];
                } else if(j == dungeon[0].length - 1){
                    min = dp[i + 1][j];
                } else {
                    min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
                
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
        
        return dp[0][0];
    }
}