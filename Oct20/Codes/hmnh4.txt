class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                count++;
            }
            
            if(count >= k){
                res += map[count - k];
            }
            map[count]++;
        }
        
        return res;
    }
}