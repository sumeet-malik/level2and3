class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        
        HashMap<Character, Integer> pmap = new HashMap<>();
        for(char ch: p.toCharArray()){
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> smap = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);
            if(pmap.containsKey(cha) && smap.get(cha) <= pmap.get(cha)){
                count++;
            }
            
            if(i >= p.length()){
                char chr = s.charAt(i - p.length());
                smap.put(chr, smap.get(chr) - 1);
                if(pmap.containsKey(chr) && smap.get(chr) < pmap.get(chr)){
                    count--;
                }
            }
            
            if(count == p.length()){
                res.add(i - p.length() + 1);
            }
        }
        
        return res;
    }
}