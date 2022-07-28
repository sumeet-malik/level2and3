class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        for(int i = 0; i < left.length; i++){
            if(i == 0){
                left[i] = height[i];
            } else {
                left[i] = Math.max(height[i], left[i - 1]);
            }
        }
        
        int[] right = new int[height.length];
        for(int i = right.length - 1; i >= 0; i--){
            if(i == right.length - 1){
                right[i] = height[i];
            } else {
                right[i] = Math.max(height[i], right[i + 1]);
            }
        }
        
        int val = 0;
        for(int i = 0; i < height.length; i++){
            val += Math.min(left[i], right[i]) - height[i];
        }
        return val;
    }
}