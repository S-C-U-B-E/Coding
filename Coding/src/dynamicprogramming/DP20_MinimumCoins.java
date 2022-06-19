package dynamicprogramming;

import java.util.Arrays;
//REPEAT OF COINS ALLOWED

//////////////////////////////////////////////////////////////////   RECURSIVE SOLUTION

//public class DP20_MinimumCoins {
//
//	public static void main(String args[]) {
//
//		int[] array = { 1, 2, 3 };
//		int target = 7;
//		
//		int ans = minimumElements(array, target, array.length - 1);
//
//		System.out.println(ans);
//
//	}

//	public static int minimumElements(int num[], int x, int n) {
//		
//		if(n == 0){
//	        if(x%num[0] == 0) return x/num[0];
//	        else return (int)Math.pow(10,9);
//	    }
//
//		
//		int notPick = minimumElements(num, x, n - 1);
//		int pick = (int)Math.pow(10,9);
//		if (num[n] <= x)
//			pick = 1 + minimumElements(num, x - num[n], n);
//
//		return Math.min(pick, notPick);
//
//	}
//}

////////////////////////////////////////////////////////////////////    MEMOIZED SOLUTION

//public class DP20_MinimumCoins {
//	public static int MAX_VALUE = (int)Math.pow(10,9);
//	public static void main(String args[]) {
//
//		int[] array = { 1, 2, 3 };
//		int target = 7;
//		
//		int n = array.length;
//		int dp[][] = new int[n][target+1];
//        for(int i[] : dp)Arrays.fill(i, -1);
//		
//		int ans = minimumElements(array, target, n - 1, dp);
//
//		 if(ans >= MAX_VALUE)System.out.println(-1);
//	        else System.out.println(ans);
//
//	}
//
//
//   public static int minimumElements(int num[], int x, int n, int[][] dp) {
//       if(n == 0){
//        if(x%num[0] == 0) return x/num[0];
//        else return MAX_VALUE;
//    }
//
//       if(dp[n][x] != -1)return dp[n][x]; 
//       
//        int notPick = minimumElements(num, x, n - 1, dp);
//        int pick = MAX_VALUE;
//        if (num[n] <= x)
//            pick = 1 + minimumElements(num, x - num[n], n, dp);
//
//        return dp[n][x] = Math.min(pick, notPick);
//
//    }
//}

////////////////////////////////////////////////////////////////////////////    TABULAR SOLUTION

public class DP20_MinimumCoins {
	public static int MAX_VALUE = (int) Math.pow(10, 9);

	public static void main(String args[]) {

		int[] array = { 12, 1, 3 };
		int target = 4;

		int n = array.length;
		int dp[][] = new int[n][target + 1];

		int ans = minimumElements(array, target, array.length - 1, dp);

		if (ans >= MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static int minimumElements(int num[], int x, int n, int[][] dp) {

		for (int i = 0; i <= x; i++) {
			if (i % num[0] == 0)
				dp[0][i] = i / num[0];
			else
				dp[0][i] = MAX_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= x; j++) {

				int notPick = dp[i - 1][j];
				int pick = MAX_VALUE;
				if (num[i] <= j)
					pick = 1 + dp[i][j - num[i]];

				dp[i][j] = Math.min(pick, notPick);

			}
		}

		return dp[n][x];

	}
}
