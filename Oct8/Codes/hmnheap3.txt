class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int val: arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for(int key: map.keySet()){
            if(map.get(key) == 0){
                continue;
            }
            
            int reqd = 0;
            
            if(key < 0){
                if(key % 2 != 0){
                    return false;
                } else {
                    reqd = key / 2;
                }
            } else {
                reqd = 2 * key;
            }
            
            if(map.getOrDefault(reqd, 0) < map.get(key)){
                return false;
            } else {
                map.put(reqd, map.get(reqd) - map.get(key));
            }
        }
        
        return true;
    }
}