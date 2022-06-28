package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////   RECURSIVE SOLUTION

//public class DP36_StockBuySellMultipleTimesAllowed {
//	public static void main(String args[]) {
//		int[] prices = { 7, 1, 4, 3, 5, 9 };
//
//		long maxPROFIT = maximizeProfit(prices, 0, 1);  
		//STARTING WITH 0TH INDEX, AND BUYING THE 1ST STOCK
		//RETURN THE MAX PROFIT

//		System.out.println(maxPROFIT);
//	}

// buyFlag = 1 -> Ready to BUY a stock
// buyFlag = 0 -> Ready to SELL a stock (you can not buy when the flab is set to
// 0)

//
//	static long maximizeProfit(int[] prices, int index, int buyFlag) {
//
//		if(index == prices.length)
//			return 0;
//		
//		long profit = 0;
//
//		if (buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, 0),
//					0 + maximizeProfit(prices, index + 1, buyFlag));
//		} else {
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 1, 1),
//					0 + maximizeProfit(prices, index + 1, buyFlag));
//		}
//
//		return profit;
//	}
//}

///////////////////////////////////////////////////////////////   MEMOIZED SOLUTION

//public class DP36_StockBuySellMultipleTimesAllowed {
//	public static void main(String args[]) {
//		long[] prices = { 7, 1, 4, 3, 5, 9 };
//		
//		long[][] dp = new long[prices.length][2];
//		for(long[] ar : dp)Arrays.fill(ar, -1);
//
//		long maxPROFIT = maximizeProfit(prices, 0, 1, dp);
//		System.out.println(maxPROFIT);
//	}
//
//	// buyFlag = 1 -> Ready to BUY a stock
//	// buyFlag = 0 -> Ready to SELL a stock (you can not buy when the flab is set to
//	// 0)
//
//	static long maximizeProfit(long[] prices, int index, int buyFlag, long[][] dp) {
//
//		if(index == prices.length)
//			return 0;
//		
//		if(dp[index][buyFlag] != -1)return dp[index][buyFlag];
//		
//		long profit = 0;
//
//		if (buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, 0, dp),
//					0 + maximizeProfit(prices, index + 1, buyFlag, dp));
//		} else {
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 1, 1, dp),
//					0 + maximizeProfit(prices, index + 1, buyFlag, dp));
//		}
//
//		return dp[index][buyFlag] = profit;
//	}
//}

///////////////////////////////////////////////////////////////  	TABULAR SOLUTION

public class DP36_StockBuySellMultipleTimesAllowed {
	public static void main(String args[]) {
		long[] prices = { 7, 1, 5, 3, 6, 4 };

		long[][] dp = new long[prices.length + 1][2];

		long maxPROFIT = maximizeProfit(prices, dp);
		System.out.println(maxPROFIT);

		dp = new long[prices.length + 1][2];

		maxPROFIT = maximizeProfit2(prices, dp);
		System.out.println(maxPROFIT);
	}

	// buyFlag = 1 -> Ready to BUY a stock
	// buyFlag = 0 -> Ready to SELL a stock (you can not buy when the flab is set to
	// 0)

	static long maximizeProfit(long[] prices, long[][] dp) {

		dp[prices.length][0] = dp[prices.length][1] = 0;

		long profit = 0;

		for (int index = prices.length - 1; index >= 0; index--) {
			for (int buyFlag = 1; buyFlag >= 0; buyFlag--) {
				// INNER-LOOP SHOULD BE BUY FIRST THEN SELL
				// SO ACCORDING TO IT, SEE IF THE 0 & 1 ARE SET
				// HERE LOOP STARTING FROM 1 THEN 0
				// MEANING, 1 SHOULD DEFINE "BUY"
				// 0 SHOULD DEFINE "SELL"
				if (buyFlag == 1) {
					profit = Math.max(-prices[index] + dp[index + 1][0], 0 + dp[index + 1][buyFlag]);
				}

				if (buyFlag == 0) {
					profit = Math.max(prices[index] + dp[index + 1][1], 0 + dp[index + 1][buyFlag]);
				}

				dp[index][buyFlag] = profit;
			}
		}

		for (long[] ar : dp)
			System.out.println(Arrays.toString(ar));
		return dp[0][1]; // RETURN ACCORDINGLY, NOTICE WE ARE NOT RETURNING [0][0]
	}

	// buyFlag = 0 -> Ready to BUY a stock
	// buyFlag = 1 -> Ready to SELL a stock (you can not buy when the flab is set to
	// 1)
	static long maximizeProfit2(long[] prices, long[][] dp) {

		dp[prices.length][0] = dp[prices.length][1] = 0;

		long profit = 0;

		for (int index = prices.length - 1; index >= 0; index--) {
			for (int buyFlag = 0; buyFlag <= 1; buyFlag++) {
				// INNER-LOOP SHOULD BE BUY FIRST THEN SELL
				// SO ACCORDING TO IT, SEE IF THE 0 & 1 ARE SET
				// HERE LOOP STARTING FRO 0 THEN 1
				// MEANING, 0 SHOULD DEFINE "BUY"
				// 1 SHOULD DEFINE "SELL"
				if (buyFlag == 0) {
					profit = Math.max(-prices[index] + dp[index + 1][1], 0 + dp[index + 1][buyFlag]);
				}

				if (buyFlag == 1) {
					profit = Math.max(prices[index] + dp[index + 1][0], 0 + dp[index + 1][buyFlag]);
				}

				dp[index][buyFlag] = profit;
			}
		}

		for (long[] ar : dp)
			System.out.println(Arrays.toString(ar));
		return dp[0][0];
	}
}