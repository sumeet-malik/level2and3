class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }
        
        int beg = 0;
        int end = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end, map[ch - 'a']);
            
            if(i == end){
                int len = end - beg + 1;
                res.add(len);
                end = beg = i + 1;
            }
        }
        
        return res;
    }
}