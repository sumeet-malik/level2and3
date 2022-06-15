class Solution {
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
    
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        
        
        helper(node.right);
        
        node.val = node.val + sum;
        sum = node.val;
        
        helper(node.left);
    }
}