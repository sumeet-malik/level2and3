import java.util.*;

public class AVL {
    public class Node {
        int data;
        int height = 0;
        int bal = 0;

        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public Node construct(int[] arr){
        return constructHelper(arr, 0, arr.length - 1);
    }

    public Node constructHelper(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo + hi) / 2;
        Node node = new Node(arr[mid]);
        node.left = constructHelper(arr, lo, mid - 1);
        node.right = constructHelper(arr, mid + 1, hi);
        node.height = getHeight(node);
        node.bal = getBal(node);

        return node;
    }

    public int getHeight(Node node){
        int lh = node.left != null? node.left.height: -1;
        int rh = node.right != null? node.right.height: -1;
        return Math.max(lh, rh) + 1;
    }

    public int getBal(Node node){
        int lh = node.left != null? node.left.height: -1;
        int rh = node.right != null? node.right.height: -1;
        return lh - rh;
    }
    
    public void display(Node root){
        if(root == null){
            return;
        }

        String str = " <- " + root.data + "[" + root.height + ", " + root.bal + "] -> ";
        String lstr = node.left == null? "." : node.left.data;
        String rstr = node.right == null? "." : node.right.data;
        System.out.println(lstr + str + rstr);
        display(root.left);
        display(root.right);
    }

    public void add(Node root, int val){
        return addHelper(root, val);   
    }

    public Node addHelper(Node node, int val){
        if(node == null){
            return new Node(val);
        }

        if(val == node.data){
            return node;
        } else if(val > node.data){
            node.right = addHelper(node.right, val);
        } else if(val < node.data){
            node.left = addHelper(node.left, val);
        }

        node.height = getHeight(node);
        node.bal = getBal(node);

        if(node.bal > 1){
            if(node.left.bal > 0){ // ll
                node = rightRotate(node);
            } else { // lr
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if(node.bal < -1){
            if(node.left.bal > 0){ // rl
                node.right = rightRotate(node.right);
                node = leftRotate(node);;
            } else { // rr
                node = leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node node){
        Node z = node;
        Node y = node.left;
        Node t3 = y.right;
        z.left = t3;
        y.right = z;

        z.height = getHeight(z);
        z.bal = getBal(z);
        y.height = getHeight(y);
        y.bal = getBal(y);

        return y;
    }

    public Node leftRotate(Node node){
        Node z = node;
        Node y = node.right;
        Node t2 = y.left;
        z.right = t2;
        y.left = z;

        z.height = getHeight(z);
        z.bal = getBal(z);
        y.height = getHeight(y);
        y.bal = getBal(y);

        return y;
    }

    public void remove(Node root, int val){
        remove(root, val);
    }

    public Node removeHelper(Node node, int val){
        if(node == null){
            return null;
        }

        if(val > node.data){
            node.right = removeHelper(node.right, val);
        } else if(val < node.data){
            node.left = removeHelper(node.left, val);
        } else {
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                node.left = removeHelper(node.left, lmax);
            } else if (node.left != null){
                return node.left;
            } else if(node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }

        node.height = getHeight(node);
        node.bal = getBal(node);

        if(node.bal > 1){
            if(node.left.bal > 0){ // ll
                node = rightRotate(node);
            } else { // lr
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if(node.bal < -1){
            if(node.left.bal > 0){ // rl
                node.right = rightRotate(node.right);
                node = leftRotate(node);;
            } else { // rr
                node = leftRotate(node);
            }
        }

        return node;
    }

    public int max(Node node){
        if(node.right != null){
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static void main(String[] args){
        System.out.println("Hello World");
    }
}