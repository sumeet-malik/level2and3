class Solution {
    Integer[] ans;
    
    class Pair {
        int val;
        int idx;
        
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        ans = new Integer[nums.length];
        Arrays.fill(ans, 0);
        
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            pairs[i] = new Pair(nums[i], i);
        }
        mergeSort(pairs, 0, pairs.length - 1);
        
        return Arrays.asList(ans);
    }
    
    Pair[] mergeSort(Pair[] arr, int lo, int hi){
        if(lo == hi){
            Pair[] barr = new Pair[1];
            barr[0] = new Pair(arr[lo].val, arr[lo].idx);
            return barr;
        }
        
        int mid = (lo + hi) / 2;
        
        Pair[] sfhalf = mergeSort(arr, lo, mid);
        Pair[] sshalf = mergeSort(arr, mid + 1, hi);
        Pair[] sarr = mergeTwoSortedArrays(sfhalf, sshalf);
        return sarr;
    }
    
    Pair[] mergeTwoSortedArrays(Pair[] one, Pair[] two){
        Pair[] res = new Pair[one.length  + two.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < one.length && j < two.length){
            if(one[i].val > two[j].val){
                res[k] = one[i];
                ans[one[i].idx] += two.length - j;
                
                k++;
                i++;   
            } else {
                res[k] = two[j];
                k++;
                j++;
            }
        }
        
        while(i < one.length){
            res[k] = one[i];
            k++;
            i++;
        }
        
        while(j < two.length){
            res[k] = two[j];
            k++;
            j++;            
        }
        
        return res;
    }
}