class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    Random r = new Random();
    int lim;
    
    public Solution(int n, int[] blacklist) {
        lim = n - blacklist.length;
        
        HashSet<Integer> set = new HashSet<>();
        for(int bl: blacklist){
            set.add(bl);
        }
        
        int curr = lim;
        for(int bl: blacklist){
            if(bl < lim){
                while(set.contains(curr)){
                    curr++;
                }
                map.put(bl, curr);
                curr++;
            }
        }
    }
    
    public int pick() {
        int ans = r.nextInt(lim);
        
        if(map.containsKey(ans)){
            ans = map.get(ans);
        }
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */