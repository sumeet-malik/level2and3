class Solution {
    long MOD = 1000000007L;
    
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        
        
        long ans = 0;
        long p = 1;
        
        for(int i = 0; i < nums.length; i++){
            ans = (ans + p * nums[i] - p * nums[nums.length - 1 - i]) % MOD;
            p = (p * 2) % MOD;
        }
        
        return (int)ans;
    }
                   

}