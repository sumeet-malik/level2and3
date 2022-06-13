class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    traverse(grid, visited, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void traverse(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == '0'){
            return;
        } else if(visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        traverse(grid, visited, i - 1, j);
        traverse(grid, visited, i + 1, j);
        traverse(grid, visited, i, j - 1);
        traverse(grid, visited, i, j + 1);
    }
}