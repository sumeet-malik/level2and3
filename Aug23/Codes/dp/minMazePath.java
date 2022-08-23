package dp;

public class minMazePath {
	public static void main(String[] args) {
		int[][] prices = {
				{0, 1, 4, 2, 8, 2},
				{4, 3, 6, 5, 0, 4},
				{1, 2, 4, 1, 4, 6},
				{2, 0, 7, 3, 2, 2},
				{3, 1, 5, 9, 2, 4},
				{2, 7, 0, 8, 5, 1}
		};
		int[][] strg = new int[prices.length][prices[0].length];
		
		int m = strg.length;
		int n = strg[0].length;
		
		for(int j = n - 1; j >= 0; j--) {
			for(int i = 0; i < m; i++) {
				if(j == n - 1) {
					strg[i][j] = prices[i][j];
				} else if(i == 0) {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j + 1]) + prices[i][j];
				} else if(i == m - 1) {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i - 1][j + 1]) + prices[i][j];
				} else {
					strg[i][j] = Math.max(strg[i][j + 1], 
										  Math.max(strg[i + 1][j + 1], strg[i - 1][j + 1])) + prices[i][j];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < m; i++) {
			max = Math.max(max, strg[i][0]);
		}
		System.out.println(max);
	}
}
