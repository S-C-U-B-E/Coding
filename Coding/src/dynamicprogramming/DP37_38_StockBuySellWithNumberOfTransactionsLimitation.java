package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////////////  RECURSIVE SOLUTION

//public class DP37_StockBuySellWithNumberOfTransactionsLimitation {
//	public static void main(String args[]) {
//		long[] prices = {3,3,5,0,0,3,1,4};
//		int limit = 2;
//		System.out.println(maximizeProfit(prices, 0, 1, limit)); // Initially buyFlag is 1 meaning we are to buy the
//																 // first stock at the beginning
//	}
//
//	private static long maximizeProfit(long[] prices, int index, int buyFlag, int limit) {
//		
//		if(limit == 0)return 0;
//		if(index == prices.length)return 0;
//		
//		long profit = 0;
//		
//		if(buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, 0 , limit),
//					0 + maximizeProfit(prices, index  + 1, buyFlag, limit));
//		}else {
//			
//			//Here we will decrease the limit by 1, meaning after the sell of the stock one transaction is complete
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 1, 1 , limit - 1),  
//					0 + maximizeProfit(prices, index  + 1, buyFlag, limit));
//		}
//		
//		return profit;
//	}
//
//}

////////////////////////////////////////////////////////////////////////  MEMOIZED SOLUTION

//Even this memoized solution is getting time limit exceeded in CodingNinjas :O

//public class DP37_StockBuySellWithNumberOfTransactionsLimitation {
//	public static void main(String args[]) {
//		long[] prices = {3,3,5,0,0,3,1,4};
//		int limit = 2;
//		long[][][] dp = new long[prices.length][2][limit+1];  
//		for(long[][]ar : dp) {
//			for(long[] arr : ar)Arrays.fill(arr, -1);
//		}
//		
//		System.out.println(maximizeProfit(prices, 0, 1, limit, dp)); // Initially buyFlag is 1 meaning we are to buy the
//																 // first stock at the beginning
//	}
//
//	private static long maximizeProfit(long[] prices, int index, int buyFlag, int limit, long[][][] dp) {
//		
//		if(limit == 0)return 0;
//		if(index == prices.length)return 0;
//		
//		long profit = 0;
//		
//		if(dp[index][buyFlag][limit] != -1)return dp[index][buyFlag][limit];
//		
//		if(buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, 0 , limit, dp),
//					0 + maximizeProfit(prices, index  + 1, buyFlag, limit, dp));
//		}else {
//			
//			//Here we will decrease the limit by 1, meaning after the sell of the stock one transaction is complete
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 1, 1 , limit - 1, dp),  
//					0 + maximizeProfit(prices, index  + 1, buyFlag, limit, dp));
//		}
//		
//		return dp[index][buyFlag][limit] = profit;
//	}
//
//}

/////////////////////////////////////////////////////////////////////  TABULAR SOLUTION

public class DP37_38_StockBuySellWithNumberOfTransactionsLimitation {
	public static void main(String args[]) {
		long[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int limit = 2;
		long[][][] dp = new long[prices.length + 1][2][limit+1];

		System.out.println(maximizeProfit(prices, dp)); // Initially buyFlag is 1 meaning we are to buy the
		// first stock at the beginning
	}

	private static long maximizeProfit(long[] prices, long[][][] dp) {

		for (int index = 0; index <= prices.length; index++) {
			for (int buyFlag = 0; buyFlag <= 1; buyFlag++) {
				dp[index][buyFlag][0] = 0;
			}
		}

		long profit = 0;

		for (int index = prices.length - 1; index >= 0; index--) {
			for (int buyFlag = 1; buyFlag >= 0; buyFlag--) { //notice how we go from 1 to 0, 1 being the flag where we buy a stock and then only 0, where we sell
				for (int limit = 1; limit <=2 ; limit++) {

					if (buyFlag == 1) {
						profit = Math.max(-prices[index] + dp[index + 1][0][limit],
								0 + dp[index + 1][buyFlag][limit] );
					} else {

						// Here we will decrease the limit by 1, meaning after the sell of the stock one
						// transaction is complete
						profit = Math.max(prices[index] + dp[index + 1][1][limit - 1],
								0 + dp[index + 1][buyFlag][limit]);
					}

					dp[index][buyFlag][limit] = profit;
				}
			}
		}
		
		 
		for(long[][]ar : dp) {
			for(long[] arr : ar)System.out.println(Arrays.toString(arr));
		}
		
		return dp[0][1][2];
		// what these indexes denotes (check the loop) & our dp array [prices.length + 1][2][limit+1]
		// 0 -> We have exhausted all our data ; last index (acc. to the loop we ran) of [prices.length + 1]
		// 1 -> We have bought the stock ; 1 denotes stok bought in  [2]
		// 2 -> Reached the limit given ; last index of [limit+1]

	}

}
