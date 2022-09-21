class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
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
        Node temp = root;
        for(char ch: word.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        
        return temp.eow;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char ch: prefix.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */