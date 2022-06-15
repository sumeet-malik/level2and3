/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            int val = inorder[i];
            map.put(val, i);
        }
        
        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length - 1, preorder, map);
        return root;
    }
    
    public TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] pre, HashMap<Integer, Integer> map){
        if(pre_lo > pre_hi || in_lo > in_hi){
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        node.val = pre[pre_lo];
        
        int index = map.getOrDefault(pre[pre_lo], 0);
        int lhs = index - in_lo;
        
        node.left = construct(pre_lo + 1, pre_lo + lhs, in_lo, index - 1, pre, map);
        node.right = construct(pre_lo + lhs + 1, pre_hi, index + 1, in_hi, pre, map);
        
        return node;
    }
}