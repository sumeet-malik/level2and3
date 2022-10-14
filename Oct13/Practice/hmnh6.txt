class Solution {
    int[][] dirs = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        HashMap<Integer, Integer> m3 = new HashMap<>();
        HashMap<Integer, Integer> m4 = new HashMap<>();
        HashMap<Integer, Boolean> m5 = new HashMap<>();
        
        for(int[] lamp: lamps){
            int x = lamp[0];
            int y = lamp[1];
            if(m5.containsKey(x * n + y) == false){
                m1.put(x, m1.getOrDefault(x, 0) + 1);
                m2.put(y, m2.getOrDefault(y, 0) + 1);
                m3.put(x + y, m3.getOrDefault(x + y, 0) + 1);
                m4.put(x - y, m4.getOrDefault(x - y, 0) + 1);
                m5.put(x * n + y, true);
            }
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            
            ans[i] = m1.getOrDefault(x, 0) > 0 || 
                     m2.getOrDefault(y, 0) > 0 ||
                     m3.getOrDefault(x + y, 0) > 0 ||
                     m4.getOrDefault(x - y, 0) > 0? 1: 0;
            for(int[] dir: dirs){
                int xx = x + dir[0];
                int yy = y + dir[1];
                if(m5.containsKey(xx * n + yy)){
                    m1.put(xx, m1.getOrDefault(xx, 0) - 1);
                    m2.put(yy, m2.getOrDefault(yy, 0) - 1);
                    m3.put(xx + yy, m3.getOrDefault(xx + yy, 0) - 1);
                    m4.put(xx - yy, m4.getOrDefault(xx - yy, 0) - 1);
                    m5.remove(xx * n + yy);
                }
            }
        }
        
        return ans;
    }
}