class Solution {
    class Pair implements Comparable<Pair> {
        int i;
        int j;
        int cost;
        
        Pair(int i, int j, int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
        
        public int compareTo(Pair o){
            return this.cost - o.cost;
        }
    }
    
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.cost;
            }
            
            addNeighbors(rem.i - 1, rem.j, grid, visited, pq, rem.cost);
            addNeighbors(rem.i + 1, rem.j, grid, visited, pq, rem.cost);
            addNeighbors(rem.i, rem.j - 1, grid, visited, pq, rem.cost);
            addNeighbors(rem.i, rem.j + 1, grid, visited, pq, rem.cost);
        }
        
        return -1;
    }
    
    void addNeighbors(int i, int j, int[][] grid, boolean[][] visited, PriorityQueue<Pair> pq, int ocost){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true){
            return;
        }
        
        pq.add(new Pair(i, j, Math.max(ocost, grid[i][j])));
    }
}