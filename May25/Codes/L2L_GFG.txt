class Solution
{
    int max; //  maximum l 2 l
    int maxPathSum(Node root)
    { 
        max = Integer.MIN_VALUE;


        if(root.left != null && root.right != null){
            helper(root);
            return max;
        } else {
            // because this question on GFG considers root with one child as  a leaf
            int val = helper(root);
            return Math.max(val, max);
        }
    } 
    
    // it returns maximum root to leaf
    int helper(Node node){
      if(node.left != null && node.right != null){
          int left = helper(node.left);
          int right = helper(node.right);

          max = Math.max(max, left + node.data + right);

          return Math.max(left, right) + node.data;
      } else if(node.left != null){
          int left = helper(node.left);
          return node.data + left;
      } else if(node.right != null){
          int right = helper(node.right);
          return node.data + right;
      } else {
          return node.data;
      }
    }
}