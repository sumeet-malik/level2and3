class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        for(int i = 1; i <= k + 1; i++){
            int[] dp1 = dist.clone();
            for(int[] flight: flights){
                int u = flight[0];
                int v= flight[1];
                int uv = flight[2];
                
                if(dist[u] != Integer.MAX_VALUE){
                    dp1[v] = Math.min(dp1[v], dist[u] + uv);
                }
            }
            dist = dp1;
        }
        
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        } else {
            return dist[dst];
        }
    }
}