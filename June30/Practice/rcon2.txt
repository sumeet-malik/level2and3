class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        
        int first = -1;
        int second = -1;
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(parent[v] == -1){   
                parent[v] = i;
            } else {
                first = parent[v];
                second = i;
                break;
            }
        }
        
        Arrays.fill(parent, 0);
        int[] res = null;
        
        if(second == -1){ // noone with a second parent, means a cycle with root
            for(int i = 0; i < edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                
                int rootu = find(u);
                
                if(v == rootu){ // cycle
                    res = edges[i]; 
                    break;
                } else {
                    parent[v] = rootu;
                }
            }
            
            return res;
        } else {
            res = edges[second];
            
            for(int i = 0; i < edges.length; i++){
                if(second == i){
                    continue;
                }
                
                int u = edges[i][0];
                int v = edges[i][1];
                
                int rootu = find(u);
                
                if(v == rootu){ // cycle
                    res = edges[first];
                    break;
                } else {
                    parent[v] = rootu;
                }
            }
            
            return res;
        }
    }
    
    int[] parent;
    int find(int i){
        if(parent[i] == 0){
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }
}