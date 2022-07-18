class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer me = null;
        
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                me = nums[i];
                count = 1;
            } else if(nums[i] == me){
                count++;
            } else {
                count--;
            }
        }
        
        
        
        return me;
    }
}