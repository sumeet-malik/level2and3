class Solution {
    public int dominantIndex(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(idx1 == -1 || nums[i] >= nums[idx1]){
                idx2 = idx1;
                idx1 = i;
            } else if(idx2 == -1 || nums[i] >= nums[idx2]){
                 idx2 = i;
            }
        }
        
        if(nums[idx1] >= 2 * nums[idx2]){
            return idx1;
        } else {
            return -1;
        } 
    }
}