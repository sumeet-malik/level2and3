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
    
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, root.val, sum, map);
    }
    
    public int helper(TreeNode node, int psum, int tar, HashMap<Integer, Integer> map){
        int ans = 0;
        
        if(map.containsKey(psum - tar) == true){
            ans += map.get(psum - tar);
        }
        
        if(map.containsKey(psum) == false){
            map.put(psum, 1);
        } else {
            map.put(psum, map.get(psum) + 1);
        }
        
        
        if(node.left != null){
            int left = helper(node.left, psum + node.left.val, tar, map);
            ans += left;
        }
        
        if(node.right != null){
            int right = helper(node.right, psum + node.right.val, tar, map);
            ans += right;
        }
        
        
        if(map.get(psum) == 1){
            map.remove(psum);
        } else {
            map.put(psum, map.get(psum) - 1);
        }

         return ans;
    }

}