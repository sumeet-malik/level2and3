class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        parent = new int[graph.length];
        size = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(i != j && graph[i][j] == 1){
                    unionHelper(i, j);
                }
            }
        }
        
        int[] countMWMap = new int[graph.length];
        for(int i: initial){
            int ri = find(i);
            countMWMap[ri]++;
        }
        
        Arrays.sort(initial);
        
        int mi = initial[0];
        int ms = 0;
        for(int i: initial){
            int ri = find(i);
            if(countMWMap[ri] == 1){
                if(size[ri] > ms) {
                    mi = i;
                    ms = size[ri];
                }
            }
        }
        
        return mi;
    }

    int[] parent;
    int[] size;
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void unionHelper(int x, int y){
        int X = find(x);
        int Y = find(y);
        
        if(X != Y){
            if(size[X] < size[Y]){
                parent[X] = Y;
                size[Y] += size[X];
            } else if(size[Y] <= size[X]){
                parent[Y] = X;
                size[X] += size[Y];
            }
        }
    }
}