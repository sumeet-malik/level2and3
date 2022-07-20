class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left[i] = 1;
            } else {
                left[i] = left[i - 1] * nums[i - 1];
            }
        }
        
        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right = right * nums[i + 1];
            left[i] = left[i] * right;
        }
        
        return left;
    }
}