class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lac = Integer.MIN_VALUE;
        int hac = 0;
        for(int wt: weights){
            hac += wt;
            lac = Math.max(lac, wt);
        }
        
        while(lac < hac){
            int ac = (lac + hac) / 2;
            
            int partsReqd = 1;
            int currPartWt = 0;
            for(int wt: weights){
                if(currPartWt + wt <= ac){
                    currPartWt += wt;
                } else {
                    currPartWt = wt;
                    partsReqd++;
                }
            }
            
            if(partsReqd > days){
                lac = ac + 1;
            } else {
                hac = ac;
            }
        }
        
        return lac;
    }
}