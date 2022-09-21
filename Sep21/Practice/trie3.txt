class Solution {
    class Node {
        boolean eow;
        Node[] arr = new Node[26];
    }
    
    String res = "";
    public String longestWord(String[] words) {
        Node root = new Node();
        
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
        
        helper(root, new StringBuilder());        
        return res;
    }
    
    void helper(Node node, StringBuilder str){        
        if(str.length() > res.length()){
            res = str.toString();
        }
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            Node child = node.arr[ch - 'a'];
            if(child != null && child.eow == true){
                str.append(ch);
                helper(child, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}