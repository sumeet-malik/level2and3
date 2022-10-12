class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        
        for(int val: nums){
            sum += val;
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            
            res += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
       
        
        return res;
    }
}