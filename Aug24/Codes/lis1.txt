class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        
        for(int i = 1; i < lis.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lis[j]);
                }
            }
            
            lis[i] = max + 1;
        }

        int len = 0;
        for(int val: lis){
            len = Math.max(val, len);
        }
        
        return len;
    }
}