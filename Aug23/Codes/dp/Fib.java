package dp;

import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		int fn = fib(n);
		
//		int[] strg = new int[n + 1];
//		int fn = fibm(n, strg);
		int fn = fibt(n);
		System.out.println(fn);
		scn.close();
	}
	
	public static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);
		int fn = fnm1 + fnm2;
		
		System.out.println("Fib of " + n + " is " + fn);
		return fn;
	}
	
	public static int fibm(int n, int[] strg) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		if(strg[n] != 0) {
			return strg[n];
		}
		
		int fnm1 = fibm(n - 1, strg);
		int fnm2 = fibm(n - 2, strg);
		int fn = fnm1 + fnm2;
		
		System.out.println("Fib of " + n + " is " + fn);
		strg[n] = fn;
		return fn;
	}
	
	public static int fibt(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		
		return strg[n];
	}

}
