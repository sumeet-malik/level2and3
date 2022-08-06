class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lams = 1;
        int hams = 0;
        
        for(int num: nums){
            hams = Math.max(num, hams);
        }
        
        while(lams < hams){
            int ams = (lams + hams) / 2;
            
            int opsReqd = 0;
            for(int ball: nums){
                if(ball > ams){
                    int spare = ball - ams;
                    int ops = (spare + ams - 1) / ams;
                    opsReqd += ops;
                }
            }
            
            // System.out.println(lams + "-" + hams + "-" + ams + "-" + opsReqd);
            
            if(opsReqd > maxOperations){
                lams = ams + 1;
            } else {
                hams = ams;
            }
        }
        
        return lams;
    }
}