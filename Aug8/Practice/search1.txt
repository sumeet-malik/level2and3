class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            int idx = (mid + rot) % nums.length;
            
            if(nums[idx] == target){
                return idx;
            } else if(nums[idx] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}