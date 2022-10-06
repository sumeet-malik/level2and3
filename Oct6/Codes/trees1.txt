class TreeAncestor {
    public int getHeight(int[] parent){
        int res = 0;
        
        int last = parent.length - 1;
        while(last != -1){
            last = parent[last];
            res++;
        }
        
        return res;
    }
    
    int[][] tree;
    public TreeAncestor(int n, int[] parent) {
        int ht = getHeight(parent);   
        int bits = 0;
        while((1 << bits) <= ht){
            bits++;
        }
        
        tree = new int[parent.length][bits];
        for(int bit = 0; bit < tree[0].length; bit++){
            for(int i = 0; i < tree.length; i++){
                if(bit == 0){
                    tree[i][bit] = parent[i];
                } else {
                    int mida = tree[i][bit - 1];
                    tree[i][bit] = mida == -1? -1: tree[mida][bit - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if(k >= (1 << tree[0].length)){
            return -1;
        }
        
        int res = node;
        
        int bit = 0;
        while((1 << bit) <= k){
            if ((k & (1 << bit)) != 0){
                res = tree[res][bit];
                if(res == -1){
                    return -1;
                }
            }
            bit++;
        }
        
        return res;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */