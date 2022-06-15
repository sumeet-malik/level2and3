class Solution {
    Node prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
    }
}