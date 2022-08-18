class Solution {
    public boolean search(int[] nums, int target)  {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] < nums[hi]){ // mid to hi is sorted
                if(target >= nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if(nums[mid] > nums[hi]) { // lo to mid is sorted
                if(target >= nums[lo] && target <= nums[mid]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi--;
            }
        }
        
        return false;
    }
}