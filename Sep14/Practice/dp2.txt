class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int stone: stones){
            map.put(stone, new HashSet<>());
        }
        
        map.get(0).add(1);
        for(int i = 0; i < stones.length - 1; i++){
            int stone = stones[i];
            
            for(int step: map.get(stone)){
                int reach = stone + step;
                
                if(reach == stones[stones.length - 1]){
                    return true;
                } else if(map.containsKey(reach)) {
                    map.get(reach).add(step);
                    map.get(reach).add(step + 1);
                    if(step - 1 > 0){
                        map.get(reach).add(step - 1);
                    }
                }
            }
        }
        
        return false;
    }
}