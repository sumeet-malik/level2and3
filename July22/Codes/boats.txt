class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        
        while(l < r){
            int val = people[l] + people[r];
            
            if(val <= limit){
                ans++;
                l++;
                r--;
            } else {
                ans++;
                r--;
            }
        }
        
        if(l == r){
            ans += 1;
        }
        
        return ans;
    }
}