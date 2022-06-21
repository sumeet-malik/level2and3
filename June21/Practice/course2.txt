class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        
        int[] in = new int[numCourses];
        for(int[] edge: prerequisites){
            in[edge[1]]++;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int course = 0; course < numCourses; course++){
            if(in[course] == 0){
                queue.add(course);
            }
        }
        
        int idx = ans.length - 1;
        while(queue.size() > 0){
            int course = queue.remove();
            ans[idx--] = course;
            
            for(int[] edge: prerequisites){
                if(edge[0] == course){
                    in[edge[1]]--;
                    
                    if(in[edge[1]] == 0){
                        queue.add(edge[1]);
                    }
                }
            }
        }
        
        if(idx != -1){
            return new int[]{};
        }
        
        return ans;
    }
}