class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1000000;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int sum = 0;
            for(int val: nums){
                sum += (val + mid - 1) / mid;
            }
            
            if(sum > threshold){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}