class Solution {
    Node prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        Node ol = root.left;
        Node or = root.right;

        if(prev != null){
            prev.left = null;
            prev.right = root;
        }
        prev = root;

        flatten(ol);
        flatten(or);
    }
}