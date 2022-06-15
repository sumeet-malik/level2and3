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
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode curr = root;
        TreeNode n1 = null;
        TreeNode n2 = null;
        
        while(curr != null){
            if(curr.left == null){
                if(prev != null){
                    if(curr.val < prev.val){
                        if(n1 == null){
                            n1 = prev;
                        }

                        n2 = curr;
                    }    
                }
                
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    iop.right = curr; // making the thread
                    curr = curr.left;
                } else {
                    if(prev != null){
                        if(curr.val < prev.val){
                            if(n1 == null){
                                n1 = prev;
                            }
                            
                            n2 = curr;
                        }    
                    }
                    
                    prev = curr;
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}