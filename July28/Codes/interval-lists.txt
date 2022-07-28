class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            
            if(lo <= hi){
                list.add(new int[]{lo, hi});
            }
            
            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}