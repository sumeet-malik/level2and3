class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;
        int sum = 0;
        int j = -1;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            while(sum >= target && j < i){
                res = res == 0? i - j: Math.min(res, i - j);
                
                j++;
                sum -= nums[j];
            }
        }
        
        
        return res;
    }
}