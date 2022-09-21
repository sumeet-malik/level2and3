class MapSum {
    class Node {
        int val = 0;
        Node[] arr = new Node[26];
    }

    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node temp = root;
        for(char ch: key.toCharArray()){
            if(temp.arr[ch - 'a'] == null){
                temp.arr[ch - 'a'] = new Node();
            }
            temp = temp.arr[ch - 'a'];
        }
        
        temp.val = val;
    }
    
    int sum;
    public int sum(String prefix) {
        Node temp = root;
        for(char ch: prefix.toCharArray()){
            if(temp.arr[ch - 'a'] == null){
                return 0;
            }
            temp = temp.arr[ch - 'a'];
        }
        
        sum = 0;
        helper(temp);
        return sum;
    }
    
    void helper(Node node){
        sum += node.val;
        for(Node child: node.arr){
            if(child != null){
                helper(child);
            }
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */