package dynamicprogramming;

import java.util.Arrays;

//////////////////////////////////////////////////////////////////////////     RECURSIVE SOLUTION

//public class DP23_UnboundedKnapsack {
//	public static void main(String args[]) {
//
//		int[] profit = {5,4,3,8};
//		int[] weight = {4,2,14,12};
//		int w = 10;
//		int n = weight.length;
//
//		System.out.println(solve(n, w, profit, weight));
//	}
//
//	public static int solve(int n, int w, int[] profit, int[] weight) {
//		if (n == 0) {
//			return (int) (w / weight[0]) * profit[0];
//		}
//
//		
//
//		int notPick = solve(n - 1, w, profit, weight);
//		int pick = 0;
//		if (weight[n - 1] <= w)
//			pick = profit[n - 1] + solve(n, w - weight[n - 1], profit, weight);
//
//		return  Math.max(pick, notPick);
//	}
//}

////////////////////////////////////////////////////////////////////////////  MEMOIZED SOLUTION

//public class DP23_UnboundedKnapsack {
//	public static void main(String args[]) {
//
//		int[] profit = {5,4,3,8};
//		int[] weight = {4,2,14,12};
//		int w = 10;
//		int n = weight.length;
//		
//		int[][] dp = new int[n][w + 1];
//		for (int ar[] : dp)
//			Arrays.fill(ar, -1);
//
//		System.out.println(solve(n, w, profit, weight, dp));
//	}
//
//	public static int solve(int n, int w, int[] profit, int[] weight, int[][] dp) {
//		if (n == 0) {
//			return (int) (w / weight[0]) * profit[0];
//		}
//
//		if (dp[n - 1][w] != -1)
//			return dp[n - 1][w];
//
//		int notPick = solve(n - 1, w, profit, weight, dp);
//		int pick = 0;
//		if (weight[n - 1] <= w)
//			pick = profit[n - 1] + solve(n, w - weight[n - 1], profit, weight, dp);
//
//		return dp[n - 1][w] = Math.max(pick, notPick);
//	}
//}

///////////////////////////////////////////////////////////////////////////////   TABULAR SOLUTION

public class DP23_UnboundedKnapsack {
	public static void main(String args[]) {

		int[] profit = { 7, 9, 1, 3, 10 };
		int[] weight = { 5, 5, 7, 7 , 7};
		int w = 13;
		int n = weight.length;

		int[][] dp = new int[n][w + 1];

		System.out.println(solve(n, w, profit, weight, dp));
	}

	public static int solve(int n, int w, int[] profit, int[] weight, int[][] dp) {

		for (int i = 0; i <= w; i++) {
				dp[0][i] = (int) (i / weight[0]) * profit[0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= w; j++) {

				int notPick = dp[i - 1][j];
				int pick = Integer.MIN_VALUE;
				if (weight[i] <= j)
					pick = profit[i] + dp[i][j - weight[i]];

				dp[i][j] = Math.max(pick, notPick);

			}
		}

		for(int ar[] : dp)System.out.println(Arrays.toString(ar));
        System.out.println();
		
		return dp[n - 1][w];
	}
}
