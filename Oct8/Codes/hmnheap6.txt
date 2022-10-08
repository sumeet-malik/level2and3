class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: answers){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int res = 0;
        
        for(int key: map.keySet()){
            int gs = key + 1;
            int count = map.get(key);
            
            int numGroups = (count + gs - 1) / gs;
            int rabbits = numGroups * gs;
            res += rabbits;
        }
        
        return res;
    }
}