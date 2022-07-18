class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int l = 0;
        int r = nums.length - 1;
        int k = res.length - 1;
        while(k >= 0){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[k] = nums[l] * nums[l];
                l++;
            } else {
                res[k] = nums[r] * nums[r];
                r--;
            }
            
            k--;
        }
        
        return res;
    }
}