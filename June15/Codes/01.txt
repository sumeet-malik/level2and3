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
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i, j, 0));
                }
                visited[i][j] = -1;
            }
        }
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j] != -1){
                continue;
            }
            visited[rem.i][rem.j] = rem.level;
            
            addChild(mat, visited, queue, rem.i - 1, rem.j, rem.level + 1);
            addChild(mat, visited, queue, rem.i + 1, rem.j, rem.level + 1);
            addChild(mat, visited, queue, rem.i, rem.j - 1, rem.level + 1);
            addChild(mat, visited, queue, rem.i, rem.j + 1, rem.level + 1);
        }
        
        return visited;
    }
    
    public void addChild(int[][] mat, int[][] visited, ArrayDeque<Pair> queue, int i, int j, int level){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visited[i][j] != -1){
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
}