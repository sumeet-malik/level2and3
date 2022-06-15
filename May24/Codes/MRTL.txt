class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root.left != null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            return Math.max(left, right) + root.data;
        } else if(root.left != null){
            int left = maxPathSum(root.left);
            return left + root.data;
        } else if(root.right != null){
            int right = maxPathSum(root.right);
            return right + root.data;            
        } else {
            // leaf
            return root.data;
        }
    }
}

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
        
        if(node.left == null && node.right == null){
            sum = sum + node.data;
            if(sum > max){
                max = sum;
            }
            return;
        }
        
        travel(node.left, sum + node.data);
        travel(node.right, sum + node.data);
    }
    
    
}