class Solution {
    class Pair {
        String config;
        int moveNum = 0;
        
        Pair(String config, int moveNum){
            this.config = config;
            this.moveNum = moveNum;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        HashSet<String> vis = new HashSet<>();
        LinkedList<Pair> queue = new LinkedList<>();
        
        Pair root = new Pair(getBoardConfig(board), 0);
        queue.addLast(root);
        while(queue.size() > 0){
            Pair rem = queue.removeFirst();
            
            // mark*
            if(vis.contains(rem.config)){
                continue;
            }
            vis.add(rem.config);
            
            // work
            if(rem.config.equals("123450")){
                return rem.moveNum;
            }
            
            // add neighbors
            int idx = rem.config.indexOf('0');
            int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {2, 4}};
            
            for(int i: dirs[idx]){
                String nconfig = swap(rem.config, idx, i);
                if(vis.contains(nconfig) == false){
                    queue.add(new Pair(nconfig, rem.moveNum + 1));
                }
            }
        }
        
        return -1;
    }
    
    public String swap(String config, int i, int j){
        StringBuilder sb = new StringBuilder(config);
        
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
    
    public String getBoardConfig(int[][] board){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                sb.append(board[i][j]);
            }
        }
        
        
        return sb.toString();
    }
}