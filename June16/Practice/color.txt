class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc = grid[row][col];
        traverse(grid, row, col, oc);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == -oc){
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    public void traverse(int[][] grid, int i, int j, int oc){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oc){
            return;
        }
        
        grid[i][j] = -oc;
        
        traverse(grid, i - 1, j, oc);
        traverse(grid, i + 1, j, oc);
        traverse(grid, i, j - 1, oc);
        traverse(grid, i, j + 1, oc);
        
        if(i > 0 && j > 0 && i < grid.length - 1 && j < grid[0].length - 1 &&
           Math.abs(grid[i - 1][j]) == oc &&
           Math.abs(grid[i + 1][j]) == oc &&
           Math.abs(grid[i][j - 1]) == oc &&
           Math.abs(grid[i][j + 1]) == oc){
            grid[i][j] = oc;
        }
    }
}