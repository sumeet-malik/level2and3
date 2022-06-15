class Solution{
    Node clone(Node node){
        if(temp == null){
            return null;
        }
        
        Node temp = new Node(node.data);
        temp.left = clone(node.left);
        temp.right = clone(node.right);

        return temp;
    }
}