class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int las = 1;
        int has = 0;
        for(int pile: piles){
            has = Math.max(pile, has);
        }
        
        while(las < has){
            int as = (las + has) / 2;
            
            // calculate hours
            int totalTime = 0;
            for(int pile: piles){
                int time = (pile + as - 1) / as;
                totalTime += time;
            }
            
            if(totalTime > h){
                las = as + 1;
            } else {
                has = as;
            }
        }
        
        return las;
    }
}