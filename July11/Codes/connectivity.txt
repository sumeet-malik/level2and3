class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        p = new int[n + 1];
        r = new int[n + 1];
        for(int i = 0; i < p.length; i++){
            p[i] = i;
            r[i] = 0;
        }
        
        for(int div = threshold + 1; div <= n; div++){
            for(int m = 1; div * m <= n; m++){
                union(div, div * m);
            }
        }
        
        ArrayList<Boolean> res = new ArrayList<>();
        
        for(int[] query: queries){
            int n1 = query[0];
            int n2 = query[1];
            boolean flag = (find(n1) == find(n2));
            res.add(flag);
        }
        
        return res;
    }
    
    int[] p;
    int[] r;
    
    int find(int x){
        if(p[x] == x){
            return x;
        } else {
            p[x] = find(p[x]);
            return p[x];
        }
    }
    
    void union(int X, int Y){
        int x = find(X);
        int y = find(Y);
        
        if(x == y){
            return;
        }
        
        if(r[x] < r[y]){
            p[x] = y;
        } else if(r[y] < r[x]){
            p[y] = x;
        } else {
            p[y] = x;
            r[x]++;
        }
    }
    
}