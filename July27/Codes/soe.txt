class Solution {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        
        primes[0] = false;
        primes[1] = false;
        
        for(int tbl = 2; tbl * tbl <= n; tbl++){
            if(primes[tbl] == false){
                continue;
            }
            
            for(int ja = tbl; tbl * ja <= n; ja++){
                primes[tbl * ja] = false;
            }
        }
        
        int count = 0;
        for(int i = 0; i < primes.length - 1; i++){
            if(primes[i] == true){
                count++;
            }
        }
        
        return count;
    }
}