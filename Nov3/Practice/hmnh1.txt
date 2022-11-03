class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = -1;
        for(int i = 0; i < fruits.length; i++){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            
            // release
            while(j < i && map.size() > 2){
                j++;
                map.put(fruits[j], map.get(fruits[j]) - 1);
                if(map.get(fruits[j]) == 0){
                    map.remove(fruits[j]);
                }
            }
            
            res = Math.max(res, i - j);
        }
        
        return res;
    }
}