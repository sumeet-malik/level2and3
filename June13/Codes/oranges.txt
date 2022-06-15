class Solution {
    class Pair {
        int x;
        int y;
        int t;
        
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      int fresh = 0;
      for(int x = 0; x < grid.length; x++){
          for(int y = 0; y < grid[0].length; y++){
              if(grid[x][y] == 2){
                  queue.add(new Pair(x, y, 0));
              } else if(grid[x][y] == 1){
                  fresh++;
              }
          }
      }
    
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      int time = 0;
      while(queue.size() > 0){
          // remove
          Pair rem = queue.remove();
          
          // mark*
          if(visited[rem.x][rem.y] == true){
              continue;
          }
          visited[rem.x][rem.y] = true;
          
          // work
          if(rem.t > time){
              time = rem.t;
          }
          if(grid[rem.x][rem.y] == 1){
              fresh--;
          }
          
          // add neighbors
          addNeighbors(rem.x + 1, rem.y, visited, grid, queue, rem.t + 1);
          addNeighbors(rem.x - 1, rem.y, visited, grid, queue, rem.t + 1);
          addNeighbors(rem.x, rem.y + 1, visited, grid, queue, rem.t + 1);
          addNeighbors(rem.x, rem.y - 1, visited, grid, queue, rem.t + 1);   
      }
        
      if(fresh == 0){
          return time;
      } else {
          return -1;
      }
    }
    
    public void addNeighbors(int x, int y, boolean[][] visited, int[][] grid, ArrayDeque<Pair> queue, int t){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return;
        } else if(visited[x][y]){
            return;
        } else if(grid[x][y] == 0){
            return;
        }
        
        queue.add(new Pair(x, y, t));
    }
    
    
}