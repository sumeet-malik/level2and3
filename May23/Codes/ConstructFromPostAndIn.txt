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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode retVal = buildTreeRec(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return retVal;
    }
    
    public TreeNode buildTreeRec(int[] inorder, int[] postorder, int postlo, int posthi, int inlo, int inhi){
        if(postlo > posthi || inlo > inhi){
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        int idx = inlo;
        while(idx <= inhi){
            if(inorder[idx] == postorder[posthi]){
                break;
            }
            idx++;
        }
        
        int rhs = inhi - idx;
        
        node.val = postorder[posthi];
        node.left = buildTreeRec(inorder, postorder, postlo, posthi - rhs - 1, inlo, idx - 1);
        node.right = buildTreeRec(inorder, postorder, posthi - rhs, posthi - 1, idx + 1, inhi);
        
        return node;
    }
}