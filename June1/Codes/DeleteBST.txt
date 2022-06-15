class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        } else if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if(root.left != null && root.right != null){
                int lmax = max(root.left);
                root.val = lmax;
                root.left = deleteNode(root.left, lmax);
                return root;
            } else if(root.left != null){
                return root.left;
            } else if(root.right != null){
                return root.right;
            } else {
                return null;
            }
        }
    }


    
}