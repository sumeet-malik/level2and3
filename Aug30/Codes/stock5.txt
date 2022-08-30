class Solution {
    public int maxProfit(int[] prices) {
        int[] dps = new int[prices.length];
        
        int lpsf = prices[0];
        dps[0] = 0;
        for(int i = 1; i < prices.length; i++){
            lpsf = Math.min(lpsf, prices[i]);
            
            int pist = prices[i] - lpsf;
            dps[i] = Math.max(dps[i - 1], pist);
        }
        
        int[] dpb = new int[prices.length];
        dpb[dpb.length - 1] = 0;
        int mpsf = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i --){
            mpsf = Math.max(mpsf, prices[i]);
            
            int pibt = mpsf - prices[i];
            dpb[i] = Math.max(dpb[i + 1], pibt);
        }
        
        int val = 0;
        for(int i = 0; i < prices.length; i++){
            val = Math.max(dps[i] + dpb[i], val);
        }
        
        return val;
    }
}