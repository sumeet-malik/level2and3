class Solution {
    class Pair {
        int bus;
        int count;
        
        Pair(int bus, int count){
            this.bus = bus;
            this.count = count;
        }
    }
    
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for(int bus = 0; bus < routes.length; bus++){
            for(int stop: routes[bus]){
                if(!map.containsKey(stop)){
                    map.put(stop, new HashSet<>());
                }
                map.get(stop).add(bus);
            }
        }
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int bus: map.get(source)){
            queue.add(new Pair(bus, 1));
        }
        
        boolean[] visited = new boolean[routes.length];
        while(queue.size() > 0){
            // remove
            Pair rem = queue.remove();
            
            // mark*
            if(visited[rem.bus]){
                continue;
            }
            visited[rem.bus] = true;
            
            // work = check if this is final bus
            for(int stop: routes[rem.bus]){
                if(stop == target){
                    return rem.count;
                }
            }
            
            // add neighbors
            for(int stop: routes[rem.bus]){
                for(int nbus: map.get(stop)){
                    if(visited[nbus] == false){
                        queue.add(new Pair(nbus, rem.count + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}