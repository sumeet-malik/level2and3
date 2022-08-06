class Solution {
    public int splitArray(int[] nums, int m) {
        int highest_sum_allowed = 0;
        int lowest_sum_allowed = Integer.MIN_VALUE;
        
        for(int num: nums){
            highest_sum_allowed += num;
            lowest_sum_allowed = Math.max(lowest_sum_allowed, num);
        }
        
        while(lowest_sum_allowed < highest_sum_allowed){
            int limit = (lowest_sum_allowed + highest_sum_allowed) / 2;
            
            int countParts = 1;
            int currPartSum = 0;
            for(int num: nums){
                if(currPartSum + num <= limit){
                    currPartSum += num; 
                } else {
                    currPartSum = num;
                    countParts++;
                }
            }
            
            if(countParts > m){
                lowest_sum_allowed = limit + 1;
            } else {
                highest_sum_allowed = limit;
            }
        }
        
        return lowest_sum_allowed;
    }
}