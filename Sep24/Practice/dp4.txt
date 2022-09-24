class Solution {
    class Node {
        Node[] children = new Node[2];
        int count = 0;
    }
    
    void insert(int num){
        Node temp = root;
        for(int i = 15; i >= 0; i--){
            int nbit = (num & (1 << i)) == 0? 0: 1;
            if(temp.children[nbit] == null){
                temp.children[nbit] = new Node();
            }
            temp = temp.children[nbit];
            temp.count++;
        } 
    }
    
    int helper(int num, int k){
        int countSmaller = 0;
        
        Node temp = root;
        for(int i = 15; i >= 0; i--){
            int kbit = (k & (1 << i)) == 0? 0: 1;
            int nbit = (num & (1 << i)) == 0? 0: 1;
            
            if(kbit == 1){
                if(temp.children[nbit] != null){
                    countSmaller += temp.children[nbit].count;
                }
                
                nbit = Math.abs(nbit - 1);
            } 
            
            if(temp.children[nbit] == null){
                break;
            } else {
                temp = temp.children[nbit];
            }
        }  
        
        return countSmaller;
    }
    
    Node root = new Node();
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        
        for(int num: nums){
            res += helper(num, high + 1) - helper(num, low);
            insert(num);
        }
        
        return res;
    }
}