class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> retVal = new ArrayList<>();
      
      if (root == null) {
            return retVal;
      }
      
      ArrayDeque<Node> queue = new ArrayDeque<>();
      queue.addLast(root);
      
      while(queue.size() > 0){
          int sz = queue.size();
          
          for(int i = 0; i < sz; i++){
              Node temp = queue.removeFirst();
              
              if(i == sz){
                  retVal.add(temp.data);
              }
              
              if(temp.left != null){
                  queue.addLast(temp.left);
              }
              
              if(temp.right != null){
                  queue.addLast(temp.right);
              }
          }
      }
      
      return retVal;
    }
}