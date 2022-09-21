class StreamChecker {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    
    Node root = new Node();
    public StreamChecker(String[] words) {
        for(String word: words){
            Node temp = root;
            for(int i = word.length() - 1; i >= 0; i--){
                char ch = word.charAt(i);
                if(temp.children[ch - 'a'] == null){
                    temp.children[ch - 'a'] = new Node();
                }
                temp = temp.children[ch - 'a'];
            }
            
            temp.eow = true;
        }
    }
    
    StringBuilder sb = new StringBuilder();
    public boolean query(char letter) {
        sb.append(letter);
        
        Node temp = root;
        for(int i = sb.length() - 1; i >= 0; i--){
            char ch = sb.charAt(i);
            if(temp.children[ch - 'a'] == null){
                return false;
            } else {
                temp = temp.children[ch - 'a'];
                if(temp.eow){
                    return true;
                }
            }
        }
        
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */