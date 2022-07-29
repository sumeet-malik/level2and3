class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]){
                return 1;
            } else if(a[0] == b[0]){
                return 0;
            } else {
                return -1;
            }
        });
        
        int count = 0;
        int end = Integer.MAX_VALUE;
        for(int[] p: points){
            if(p[0] > end){
                count++;
                end = p[1];
            } else {
                end = Math.min(end, p[1]);
            }
        }
        
        return count + 1;
    }
}