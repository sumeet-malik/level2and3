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
    
    public int maxDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        if(queue.size() == grid.length * grid[0].length){
            return -1;
        }
        
        int dist = -1;
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            dist = rem.level;
            
            addN(rem.i - 1, rem.j, rem.level + 1, grid, visited, queue);
            addN(rem.i + 1, rem.j, rem.level + 1, grid, visited, queue);
            addN(rem.i, rem.j - 1, rem.level + 1, grid, visited, queue);
            addN(rem.i, rem.j + 1, rem.level + 1, grid, visited, queue);
        }
        
        return dist;
    }
    
    public void addN(int i, int j, int level, int[][] grid, boolean[][] visited, ArrayDeque<Pair> queue){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || visited[i][j] == true){
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
    

}