class Solution {
    int index = 0;
    public TreeNode bstFromPostorder(int[] postorder) {
        index = postorder.length - 1;
        return construct(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode construct(int[] post, int min, int max){
        if(index == post.length){
            return null;
        } else if(post[index] > min && post[index] < max){
            TreeNode node = new TreeNode();
            
            node.val = post[index];
            index--;
            
            node.right = construct(post, node.val, max);
            node.left = construct(post, min, node.val);
            
            return node;
        } else {
            return null;
        }
    }
    
}