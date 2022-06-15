// Morris traversal is better

class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        return helper(root);
    }

    Node helper(Node node){
        if(node == null){
            return null;
        }

        Node lhead = helper(node.left);
        Node rhead = helper(node.right);

        Node onl = node;
        onl.left = onl.right = onl;

        Node s1 = concat(lhead, onl);
        Node s2 = concat(s1, rhead);

        return s2;
    }

    Node concat(Node h1, Node h2){
        if(h1 == null){
            return h2;
        } else if(h2 == null){
            return h1;
        }

        Node t1 = h1.left;
        Node t2 = h2.left;

        t1.right = h2;
        h2.left = t1;

        t2.right = h1;
        h1.left = t2;

        return h1;
    }


    
}