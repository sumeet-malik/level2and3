class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> pair: pairs){
            int i = pair.get(0);
            int j = pair.get(1);
            
            int il = find(i);
            int jl = find(j);
            if(il != jl){
                union(il, jl);
            }
        }
        
        PriorityQueue<Character>[] pqs = new PriorityQueue[s.length()];
        for(int i = 0; i < pqs.length; i++){
            pqs[i] = new PriorityQueue<>();
        }
        
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = s.charAt(i);
            pqs[il].add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = pqs[il].remove();
            sb.append(ch);
        }
        
        return sb.toString();
    }
    int[] parent;
    int[] rank;
    
    void union(int x, int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        } else if(rank[y] < rank[x]){
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}