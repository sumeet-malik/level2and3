class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode construct(int[] pre, int min, int max){
        if(index == pre.length){
            return null;
        } else if(pre[index] > min && pre[index] < max){
            TreeNode node = new TreeNode();
            
            node.val = pre[index];
            index++;
            
            node.left = construct(pre, min, node.val);
            node.right = construct(pre, node.val, max);
            
            return node;
        } else {
            return null;
        }
    }
    
}