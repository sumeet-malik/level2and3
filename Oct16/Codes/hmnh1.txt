class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char ch: t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> smap = new HashMap<>();
        int count = 0;
        int j = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if(tmap.containsKey(ch) && smap.get(ch) <= tmap.get(ch)){
                count++;
            }
            
            while(count == t.length() && j < i){
              String ss = s.substring(j + 1, i + 1);
              if(res.length() == 0 || ss.length() < res.length()){
                  res = ss;
              }
                
              j++;
              ch = s.charAt(j);
              smap.put(ch, smap.get(ch) - 1);
              if(tmap.containsKey(ch) && smap.get(ch) < tmap.get(ch)){
                  count--;
              }
            }
        }
        
        return res;
    }
}