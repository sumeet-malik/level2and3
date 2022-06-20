class Solution {
    class Pair {
        int i;
        int j;
        int level;
        
        Pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    
    public int shortestBridge(int[][] grid) {
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        boolean found = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, queue, i, j);
                    found = true;
                    break;
                }
            }
            
            if(found){
                break;
            }
        }
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(grid[rem.i][rem.j] == -2){
                continue;
            }
            
            if(grid[rem.i][rem.j] == 1){
                return rem.level - 1;
            }
            
            grid[rem.i][rem.j] = -2;
            
            addN(grid, queue, rem.i - 1, rem.j, rem.level + 1);
            addN(grid, queue, rem.i + 1, rem.j, rem.level + 1);
            addN(grid, queue, rem.i, rem.j - 1, rem.level + 1);
            addN(grid, queue, rem.i, rem.j + 1, rem.level + 1);
        }
        
        return -1;
    }
    
    public void addN(int[][] grid, ArrayDeque<Pair> queue, int i, int j, int level){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == -1){
            return;
        } else if(grid[i][j] == -2){
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
    
    public void dfs(int[][] grid, ArrayDeque<Pair> queue, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1){
            return;
        }
        
        grid[i][j] = -1;
        queue.add(new Pair(i, j, 0));
        dfs(grid, queue, i - 1, j);
        dfs(grid, queue, i + 1, j);
        dfs(grid, queue, i, j - 1);
        dfs(grid, queue, i, j + 1);
    }
}