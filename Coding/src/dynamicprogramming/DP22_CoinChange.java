package dynamicprogramming;

import java.util.Arrays;

//////////////////////////////////////////////////////////////////////////    RECURSIVE  METHOD
//
//public class DP22_CoinChange {
//
//	public static void main(String args[]) {
//
//		int[] array = { 1, 2, 3 };
//		int target = 4;
//
//		int n = array.length;
//
//		int ans = minimumElements(array, target, array.length-1);
//
//		System.out.println(ans);
//	}
//
//	public static int minimumElements(int num[], int x, int n) {
//
//		if (n == 0) {
//			if (x % num[0] == 0)
//				return 1;
//			else return 0;
//		}
//
//		int notPick = minimumElements(num, x, n - 1);
//		int pick = 0;
//		if (num[n] <= x)
//			pick = minimumElements(num, x - num[n], n);
//
//		return pick + notPick;
//
//	}
//
//}

////////////////////////////////////////////////////////////////////////RECURSIVE  METHOD

public class DP22_CoinChange {

	public static void main(String args[]) {

		int[] array = { 1, 2, 3 };
		int target = 4;
		int n = array.length;
		
		int[][] dp = new int[n][target+1];
		for(int[] ar : dp)Arrays.fill(ar, -1);

		int ans = minimumElements(array, target, array.length - 1, dp);

		System.out.println(ans);
	}

	public static int minimumElements(int num[], int x, int n, int[][] dp) {

		if (n == 0) {
			if (x % num[0] == 0)
				return 1;
			else
				return 0;
		}

		if(dp[n][x] != -1)return dp[n][x];
		
		int notPick = minimumElements(num, x, n - 1, dp);
		int pick = 0;
		if (num[n] <= x)
			pick = minimumElements(num, x - num[n], n, dp);

		return dp[n][x] = pick + notPick;

	}

}

/////////////////////////////////////////////////////////////////////////  TABULAR METHOD

//public class DP22_CoinChange {
//
//
//	public static void main(String args[]){
//       
//		int[] array = {1, 2, 3};
//		int target = 7;
//		
//		int n = array.length;
//        int dp[][] = new int[n][target + 1];
//
//        int ans = minimumElements(array, target, array.length, dp);
//
//        System.out.println(ans);
//	}
//	
//    
//    public static int minimumElements(int num[], int x, int n, int[][] dp) {
//
//        for (int i = 0; i <= x; i++) {
//            if (i % num[0] == 0)
//                dp[0][i] = 1;
//        }
//
//        for (int i = 1; i<n; i++) {
//            for (int j = 0; j <= x; j++) {
//
//                int notPick = dp[i - 1][j];
//                int pick = 0;
//                if (num[i] <= j)
//                    pick = dp[i][j - num[i]];
//
//                dp[i][j] = pick + notPick;
//
//            }
//        }
//
//        for(int ar[] : dp)System.out.println(Arrays.toString(ar));
//        System.out.println();
//        
//        return dp[n-1][x];
//
//    }
//
//}
//
