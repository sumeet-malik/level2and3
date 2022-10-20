class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map.containsKey(ch1) == false){
                if(used.contains(ch2) == false){
                    map.put(ch1, ch2);
                    used.add(ch2);
                } else {
                    return false;
                }
            } else {
                if(map.get(ch1) != ch2){
                    return false;
                }
            }
        }
        
        return true;
    }
}