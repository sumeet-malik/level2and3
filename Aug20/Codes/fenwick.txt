class NumArray {
    class FenwickTree {
        int[] arr;
        FenwickTree(int[] nums){
            arr = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++){
                this.update(i + 1, nums[i]);
            }
        }
        
        private int rsb(int x){
            return x & (-x);
        }
        
        public int getSum(int pos){
            int res = 0;
            
            while(pos > 0){
                res += arr[pos];
                pos = pos - rsb(pos);
            }
            
            return res;
        }
        
        public void update(int pos, int val){
            while(pos < arr.length){
                arr[pos] += val;
                pos = pos + rsb(pos);
            }
        }
    }
    
    FenwickTree ft;
    int[] oarr;
    public NumArray(int[] nums) {
        ft = new FenwickTree(nums);
        oarr = nums;
    }
    
    public void update(int index, int val) {
        int delta = val - oarr[index]; 
        ft.update(index + 1, delta);
        oarr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int lpos = left + 1;
        int rpos = right + 1;
    
        int suml = ft.getSum(lpos - 1);
        int sumr = ft.getSum(rpos);
        return sumr - suml;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */