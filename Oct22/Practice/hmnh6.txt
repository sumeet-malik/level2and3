class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int res = 0;
        
        Integer crackPoint = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row: wall){
            int sum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                int brick = row.get(i);
                sum += brick;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                
                if(crackPoint == null){
                    crackPoint = sum;
                } else if(map.get(sum) > map.get(crackPoint)){
                    crackPoint = sum;
                }
            }
        }
        
        return wall.size() - map.getOrDefault(crackPoint, 0);
    }
}