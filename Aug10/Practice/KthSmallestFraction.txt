class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        while(lo < hi){
            double mid = (lo + hi) / 2;
            int p = 0;
            int q = 1;
            
            int count = 0;
            int j = 0;
            for(int i = 0; i < arr.length; i++){
                while(j < arr.length && arr[i] * 1.0 / arr[j] > mid){
                    j++;
                }
                
                if(j == arr.length){
                    break;
                }
            
                count += (arr.length - j);   
                if(p * arr[j] < q * arr[i]){
                    p = arr[i];
                    q = arr[j];
                }
            }
            
            
            if(count < k){
                lo = mid;
            } else if(count > k){
                hi = mid;
            } else {
                return new int[]{p, q};
            }
        }
        
        return null;
    }
}