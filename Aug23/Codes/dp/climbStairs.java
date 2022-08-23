package dp;

public class climbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] strg = new int[n + 1];
//		int paths = climbStairs(n, strg);
		int paths = climbStairsTab(n);
		System.out.println(paths);
	}
	
	public static int climbStairs(int n, int[] strg) {
		if(n == 0) {
			return 1;
		} else if(n < 0) {
			return 0;
		}
		
		if(strg[n] != 0) {
			return strg[n];
		}
		
		int pfnm1 = climbStairs(n - 1, strg);
		int pfnm2 = climbStairs(n - 2, strg);
		int pfnm3 = climbStairs(n - 3, strg);
		int pfn = pfnm1 + pfnm2 + pfnm3;
		
		strg[n] = pfn;
		return pfn;
	}
	
	public static int climbStairsTab(int n) {
		int[] strg = new int[n + 1];
		
		strg[0] = 1;
		for(int i = 1; i <= n; i++) {
			if(i >= 3) {
				strg[i] = strg[i - 1] + strg[i - 2] + strg[i - 3];
			} else if(i == 2) {
				strg[i] = strg[i - 1] + strg[i - 2];
			} else if(i == 1) {
				strg[i] = strg[i - 1];
			}
		}
		
		return strg[n];
	}

}
