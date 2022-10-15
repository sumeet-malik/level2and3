class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str: strs){
            int[] fmap = new int[26];
            for(char ch: str.toCharArray()){
                fmap[ch - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int val: fmap){
                sb.append(val);
                sb.append('-');
            }
            
            String key = sb.toString();
            if(map.containsKey(key) == false){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> list: map.values()){
            res.add(list);
        }
        return res;
    }
}