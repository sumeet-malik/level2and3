class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = 0;
        int cnt1 = 0;
        int can2 = 0;
        int cnt2 = 0;
        
        for(int val: nums){
            if(cnt1 == 0){
                cnt1 = 1;
                can1 = val;
            } else if(val == can1){
                cnt1++;
            } else if(cnt2 == 0){
                cnt2 = 1;
                can2 = val;
            } else if(val == can2){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0;
        cnt2 = 0;
        for(int val: nums){
            if(val == can1){
                cnt1++;
            } else if(val == can2){
                cnt2++;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(cnt1 > nums.length / 3){
            res.add(can1);
        }
        if(cnt2 > nums.length / 3){
            res.add(can2);
        }
        
        return res;
    }
}