class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];
        int ossp = 0;
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ossp - prices[i], obsp);
            int nssp = Math.max(obsp + prices[i] - fee, ossp);
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}