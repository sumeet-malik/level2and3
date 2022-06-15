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
    class Pair {
        int nodes;
        int coins;

        Pair(int nodes, int coins){
            this.nodes = nodes;
            this.coins = coins;
        }
    }
    
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair(0, 0);    
        }
        
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        Pair mp = new Pair(0, 0);
        mp.nodes = lp.nodes + rp.nodes + 1; // size
        mp.coins = lp.coins + rp.coins + node.val; // sum
        moves += Math.abs(mp.nodes - mp.coins);
        
        return mp;
    }
}