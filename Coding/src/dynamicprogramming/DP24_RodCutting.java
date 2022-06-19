package dynamicprogramming;

import java.util.Arrays;

//////////////////////////////////////////////////////////////// RECURSIVE SOLUTION


//public class DP24_RodCutting {
//	public static void main(String args[]){
//		
//		int[] price = {3, 5 ,8 ,9, 10, 17, 17, 20};
//		int n = 8;
//		int len = n;
//        
//        System.out.println(solve(price , n, len));
//	}
//    
//	public static int solve(int[] price , int n, int len) {
//		
//		if(n == 0) {
//			return len * price[0];
//		}
//		
//		int notPick = solve(price , n-1,  len);
//		int pick = Integer.MIN_VALUE;
//		int lenToSell = n+1;
//		if(lenToSell <= len)pick = price[n] + solve(price , n , len-lenToSell);
//		
//		return Math.max(pick, notPick);
//	}
//    
//}


///////////////////////////////////////////////////////////////////   MEMOIZED SOLUTION


public class DP24_RodCutting {
	public static void main(String args[]){
		
		int[] price = {3, 5 ,8 ,9, 10, 17, 17, 20};
		int n = 8;
		int len = n;
        
		int[][] dp = new int[n][len+1];
		for(int ar[] : dp)Arrays.fill(ar, -1);
		
        System.out.println(solve(price , n, len, dp));
	}
    
	public static int solve(int[] price , int n, int len, int[][] dp) {
		
		if(n == 0) {
			return len * price[0];
		}
		
		if(dp[n-1][len] != -1)return dp[n-1][len];
		
		int notPick = solve(price , n-1,  len, dp);
		int pick = Integer.MIN_VALUE;
		int lenToSell = n+1;
		if(lenToSell <= len)pick = price[n] + solve(price , n , len-lenToSell, dp);
		
		return dp[n-1][len] = Math.max(pick, notPick);
	}
    
}


/////////////////////////////////////////////////////////////////  TABULAR SOLUTION
//
//public class DP24_RodCutting {
//	public static void main(String args[]){
//		
//		int[] price = {2,5,7,8,10};
//		int n = 5;
//		
//        int w = n;
//		int[][] dp = new int[n][n+1];
//        
//         for (int i = 0; i <= n; i++) {
//                dp[0][i] = i*price[0];
//           }
//        
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j <= w; j++) {
//
//                int notPick = dp[i - 1][j];
//                int pick = 0;
//                int len = i+1;
//                if (len <= j)
//                    pick = price[i] + dp[i][j - len];
//
//                dp[i][j] = Math.max(pick, notPick);
//
//            }
//        }
//        
//        System.out.println(dp[n - 1][n]);
//	}
//    
//    
//}
