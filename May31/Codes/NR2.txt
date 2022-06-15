class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null;
        Node tail = null;

        while(curr != null){
            // code for curr on level x, and head-tail on level x + 1
            while(curr != null){
                if(curr.left != null){
                    if(head == null){
                        head = curr.left;
                        tail = curr.left;
                    } else {
                        tail.next = curr.left;
                        tail = curr.left;
                    }
                }

                if(curr.right != null){
                    if(head == null){
                        head = curr.right;
                        tail = curr.right;
                    } else {
                        tail.next = curr.right;
                        tail = curr.right;
                    }
                }

                curr = curr.next;
            }

            curr = head;
            head = null;
            tail = null;
        }

        return root;
    }
}