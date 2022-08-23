package dp;

public class climbStairsVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
		int[] strg = new int[arr.length + 1];
		
		strg[strg.length - 1] = 1;
		for(int i = strg.length - 2; i >= 0; i--) {
			for(int step = 1; step <= arr[i]; step++) {
				if(i + step < strg.length) {
					strg[i] += strg[i + step];
				}
			}
		}
		
		System.out.println(strg[0]);
	}
	
}
