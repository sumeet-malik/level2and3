class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    int atMostK(int[] nums, int k){
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = -1;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            // release
            while(j < i && map.size() > k){
                j++;
                map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
            }
            
            res += (i - j);
        }
        
        return res;
    }
}