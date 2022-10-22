class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int r = n / 4;
        
        int[] map = new int[26];
        for(char ch: s.toCharArray()){
            map[ch - 'A']++;
        }
        
        int reqd = 0;
        for(char ch: "QWER".toCharArray()){
            if(map[ch - 'A'] > r){
                map[ch - 'A'] -= r;
                reqd += map[ch - 'A'];
            } else {
                map[ch - 'A'] = 0;
            }
        }
        
        if(reqd == 0){
            return 0;
        }
        
        int res = 0;
        
        int count = 0;
        int[] map2 = new int[26];
        int j = -1;
        for(int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);
            map2[cha - 'A']++;
            
            if(map2[cha - 'A'] <= map[cha - 'A']){
                count++;
            }
            
            while(count == reqd && j < i){
                res = res == 0? i - j: Math.min(res, i - j);
                
                j++;
                char chr = s.charAt(j);
                map2[chr - 'A']--;
                if(map2[chr - 'A'] < map[chr - 'A']){
                    count--;
                }
            }
        }
        
        return res;
    }
    
    
}