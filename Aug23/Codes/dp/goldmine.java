package dp;

public class goldmine {
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
		
		for(int i = strg.length - 1; i >= 0; i--) {
			for(int j = strg[0].length - 1; j >= 0; j--) {
				if(i == strg.length - 1 && j == strg[0].length - 1) {
					strg[i][j] = prices[i][j];
				} else if(i == strg.length - 1) {
					strg[i][j] = strg[i][j + 1] + prices[i][j];
				} else if(j == strg[0].length - 1) {
					strg[i][j] = strg[i + 1][j] + prices[i][j];
				} else {
					strg[i][j] = Math.min(strg[i][j + 1], strg[i + 1][j]) + prices[i][j];
				}
			}
		}
		
		System.out.println(strg[0][0]);
	}
}
