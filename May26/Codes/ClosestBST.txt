class Solution
{
    
    static int minD;
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
       minD = Integer.MAX_VALUE;
       travel(root, K);
       
       return minD;
    } 
    
    static void travel(Node node, int k){
        if(node == null){
            return;
        }
        
        int diff = Math.abs(node.data - k);
        if(diff < minD){
            minD = diff;
        }
        
        
        if(k > node.data){
            travel(node.right, k);
        } else if (k < node.data){
            travel(node.left, k);
        } else {
            return;
        }
    }
    
    
    
}

