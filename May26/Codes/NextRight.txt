class Solution {
    public Node connect(Node root) {
        Node lmost = root;

        while(lmost != null){
            Node curr = lmost;

            while(curr != null){
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }

                if(curr.right != null && curr.next != null){
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            lmost = lmost.left;
        }

        return root;
    }
}