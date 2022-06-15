class Solution{
    public Tree cloneTree(Tree tree){
       // add code here.
       createDuplicates(tree);
       setRandoms(tree);
       Tree dup = removeDuplicates(tree);
       return dup;
     }
     
     public void createDuplicates(Tree node){
         if(node == null){
             return;
         }
         
         createDuplicates(node.left);
         createDuplicates(node.right);
         
         Tree duplicate = new Tree(node.data);
         duplicate.left = node.left;
         duplicate.right = null;
         node.left = duplicate;
     }
     
     public void setRandoms(Tree orig){
         if(orig == null){
             return;
         }
         
         setRandoms(orig.left.left);
         setRandoms(orig.right);
         
         if(orig.random != null){
            orig.left.random = orig.random.left;
         }
     }
     
     public Tree removeDuplicates(Tree node){
         if(node == null){
             return null;
         }
         
         Tree leftDup = removeDuplicates(node.left.left);
         Tree rightDup = removeDuplicates(node.right);
         
         Tree dup = node.left;
         node.left = node.left.left;
         dup.left = leftDup;
         dup.right = rightDup;
         
         
         return dup;
     }
}