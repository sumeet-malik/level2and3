class Solution {
    class Node {
        int val;
        Node left;
        Node right;
        int start;
        int end;
    }
    
    Node construct(int ss, int se){
        if(ss == se){
            Node node = new Node();
            node.start = node.end = ss;
            node.val = 0;
            return node;
        }
        
        int mid = (ss + se) / 2;
        
        Node node = new Node();
        node.start = ss;
        node.end = se;
        node.left = construct(ss, mid);
        node.right = construct(mid + 1, se);
        node.val = Math.max(node.left.val, node.right.val);
        
        return node;
    }
    
    void update(Node node, int idx, int val){
        if(node.start == node.end){
            node.val = val;
            return;
        }
        
        int mid = (node.start + node.end) / 2;
        if(idx <= mid){
            update(node.left, idx, val);
        } else {
            update(node.right, idx, val);
        }
        
        node.val = Math.max(node.left.val, node.right.val);
    }
    
    int query(Node node, int qs, int qe){
        if(node.start > qe || node.end < qs){
            return 0;
        } else if (node.start >= qs && node.end <= qe) {
            return node.val;
        } else {
            int lval = query(node.left, qs, qe);
            int rval = query(node.right, qs, qe);
            return Math.max(lval, rval);
        }
    }
    
    public int lengthOfLIS(int[] nums, int k) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        Node root = construct(1, max);
        
        int res = 0;
        
        for(int num: nums){
            int qs = num - k >= 1? num - k: 1;
            int qe = num - 1;
            int len = query(root, qs, qe) + 1;
            update(root, num, len);
            res = Math.max(res, len);
        }
        
        return res;
    }
}