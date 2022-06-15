class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root.left != null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);

            int left_dash = Math.max(0, left);
            int right_dash = Math.max(0, right);

            return Math.max(left_dash, right_dash) + root.data;
        } else if(root.left != null){
            int left = maxPathSum(root.left);
            int left_dash = Math.max(0, left);

            return left_dash + root.data;
        } else if(root.right != null){
            int right = maxPathSum(root.right);
            int right_dash = Math.max(0, right);

            return right_dash + root.data;            
        } else {
            // leaf
            return root.data;
        }
    }
}

---------------------------------------------------------------
---------------------------------------------------------
class Solution
{
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root)
    {
        max = Integer.MIN_VALUE;
        travel(root, 0);
        return max;
    }
    
    public static void travel(Node node, int sum){
        if(node == null){
            return;
        }
        
        if(sum + node.data > max){
            max = sum + node.data;
        }
        
        travel(node.left, sum + node.data);
        travel(node.right, sum + node.data);
    }
    
    
}
----------------------------------------------------------------------
class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root == null){
            return 0;
        }
        
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int left_dash = Math.max(0, left);
        int right_dash = Math.max(0, right);

        return Math.max(left_dash, right_dash) + root.data;
    }
}