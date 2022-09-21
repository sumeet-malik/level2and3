class WordDictionary {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(char ch: word.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new Node();
            }
            temp = temp.children[ch - 'a'];
        }
        
        temp.eow = true;
    }
    
    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    boolean helper(String word, int i, Node node){
        if(i == word.length()){
            return node.eow;
        }
        
        char ch = word.charAt(i);
        if(ch != '.'){
            if(node.children[ch - 'a'] != null){
                return helper(word, i + 1, node.children[ch - 'a']);
            } else {
                return false;
            }
        } else {
            for(char nch = 'a'; nch <= 'z'; nch++){
                if(node.children[nch - 'a'] != null){
                    boolean found = helper(word, i + 1, node.children[nch - 'a']);
                    if(found){
                        return true;
                    }
                } 
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */