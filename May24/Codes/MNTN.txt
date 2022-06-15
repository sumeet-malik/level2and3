class Solution {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSum_RTN(root);
        return max;
    }

    // it returns maximum root to node, but also calculates maximum node to node
    public int maxPathSum_RTN(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = maxPathSum_RTN(node.left);
        int right = maxPathSum_RTN(node.right);

        int left_dash = Math.max(0, left);
        int right_dash = Math.max(0, right);

        int sumFromLeftToRight = left_dash + node.val + right_dash;
        if(sumFromLeftToRight > max){
            max = sumFromLeftToRight;
        }

        return Math.max(left_dash, right_dash) + node.val;
    }
}