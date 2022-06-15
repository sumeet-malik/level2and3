class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode pre = curr.left;
                
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                
                if(pre.right == null){
                    retVal.add(curr.val);

                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            } else {
                retVal.add(curr.val);
                curr = curr.right;
            }
        }
        
        return retVal;
    }
}

/*
apka left hai?
    Yes
        left ke right most ka right aapko point kar rha hai?
            Yes
                left ke rightmost ka right khud se htao
                right jao
            No
                print karo
                left ke rightmost ka right khud pe point karao
                left jao
    No
        print karo, right ko jao