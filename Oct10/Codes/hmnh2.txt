class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(sum, 1);
        for(int val: nums){
            sum += val;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}