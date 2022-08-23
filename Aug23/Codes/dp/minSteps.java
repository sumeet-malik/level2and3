package dp;

import java.util.Arrays;

public class minSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
		Integer[] strg = new Integer[arr.length + 1];
		
		strg[strg.length - 1] = 0;
		for(int i = strg.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			
			for(int step = 1; step <= arr[i]; step++) {
				if(i + step < strg.length && strg[i + step] != null) {
					min = Math.min(min, strg[i + step]);
				}
			}
			
			if(min != Integer.MAX_VALUE) {
				strg[i] = min + 1;
			} else {
				strg[i] = null;
			}
		}
		
		System.out.println(Arrays.toString(strg));
		System.out.println(strg[0]);
	}
	
}
