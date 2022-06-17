package dynamicprogramming;

import java.util.Arrays;

///////////////////////////////////////////////////////////////     RECURSIVE SOLUTION

//public class DP19_Knapsack {
//	public static void main(String args[]) {
//		
//		int n = 4;
//		int[] obj = {1,2,4,5};
//		int[] val = {5,4,8,6};
//		int W = 5;
//		
//		int maxW = 0, currW = 0;
//		
//		System.out.println(maximumProfit(obj, val, n, W, maxW, currW));
//	}
//
//	private static int maximumProfit(int[] obj, int[] val, int n, int w, int maxW, int currW) {
//		
//		if(w == 0 || n == 0) {
//			maxW = Math.max(currW , maxW);
//			return maxW;
//		}
//		
//		int pick = Integer.MIN_VALUE;
//		if(obj[n-1] <= w)pick = val[n-1] + maximumProfit(obj, val, n-1, w-obj[n-1], maxW, currW);
//		int notPick =  maximumProfit(obj, val, n-1, w, maxW, currW);
//		
//		return Math.max(pick, notPick);
//	}
//}


/////////////////////////////////////////////////////////////     MEMOIZED SOLUTION


public class DP19_Knapsack {
	public static void main(String args[]) {
		
		int n = 4;
		int[] obj = {1,2,4,5};
		int[] val = {5,4,8,6};
		int W = 5;
		
		int maxW = 0, currW = 0;
		int[][] dp = new int[n][W+1];
		for(int ar[] : dp)Arrays.fill(ar, -1);
		
		System.out.println(maximumProfit(obj, val, n-1, W, maxW, currW, dp));
	}

	private static int maximumProfit(int[] obj, int[] val, int n, int w, int maxW, int currW, int[][] dp) {
		
		if(w == 0 || n == 0) {
			maxW = Math.max(currW , maxW);
			return maxW;
		}
		
		
		if(dp[n][w] != -1)return dp[n][w];
		
		int pick = Integer.MIN_VALUE;
		if(obj[n] <= w)pick = val[n] + maximumProfit(obj, val, n-1, w-obj[n], maxW, currW, dp);
		int notPick =  maximumProfit(obj, val, n-1, w, maxW, currW, dp);
		
		return dp[n][w] = Math.max(pick, notPick);
	}
}