class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int card: deck){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        int ans = 0;
        
        for(int card: map.keySet()){
            int count = map.get(card);
            ans = gcd(ans, count);
        }
        
        return ans > 1;
    }
    
    public int gcd(int a, int b){
        if(a % b == 0){
            return b;
        } else {
            return gcd(b, a % b);    
        }    
    }
}