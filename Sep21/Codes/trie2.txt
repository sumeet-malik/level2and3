class Solution {
    class Node {
        Node[] arr = new Node[26];
        boolean eow = false;
    }
    
    Node root = new Node();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
            Node temp = root;
            for(char ch: word.toCharArray()){
                if(temp.arr[ch - 'a'] == null){
                    temp.arr[ch - 'a'] = new Node();
                }
                temp = temp.arr[ch - 'a'];
            }
            temp.eow = true;
        }
        
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper(board, vis, i, j, new StringBuilder(), root);
            }
        }
        
        return new ArrayList<>(res);
    }
    
    int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    HashSet<String> res = new HashSet<>();
    void helper(char[][] board, boolean[][] vis, int i, int j, StringBuilder sb, Node node){
        char ch = board[i][j];
        sb.append(ch);
        
        if(node.arr[ch - 'a'] == null){
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        Node child = node.arr[ch - 'a'];
        if(child.eow){
            res.add(sb.toString());
        }
        
        vis[i][j] = true;
        for(int[] dir: dirs){
            int ii = i + dir[0];
            int jj = j + dir[1];
            if(ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && vis[ii][jj] == false){
                helper(board, vis, ii, jj, sb, child);
            }
        }
        vis[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}