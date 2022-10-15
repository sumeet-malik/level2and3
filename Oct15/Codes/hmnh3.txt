class RandomizedCollection {
    Random r;
    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    
    public RandomizedCollection() {
        r = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean flag = false;
        
        if(!map.containsKey(val)){
            flag = true;
            map.put(val, new HashSet<>());
        }
        
        map.get(val).add(list.size());
        list.add(val);
        
        return flag;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int lidx = list.size() - 1;
        if(list.get(lidx) != val){
            int vidx = map.get(val).iterator().next();
            swap(lidx, vidx);
        }
        
        list.remove(lidx);
        map.get(val).remove(lidx);
        if(map.get(val).size() == 0){
            map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
    
    private void swap(int i, int j){
        int ith = list.get(i);
        int jth = list.get(j);
        list.set(i, jth);
        list.set(j, ith);
        
        map.get(ith).remove(i);
        map.get(ith).add(j);
        
        map.get(jth).remove(j);
        map.get(jth).add(i);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */