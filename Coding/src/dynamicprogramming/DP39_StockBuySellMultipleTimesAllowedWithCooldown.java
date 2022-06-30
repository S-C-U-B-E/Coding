package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////////////  RECURSIVE SOLUTION

//public class DP38_StockBuySellMultipleTimesAllowedWithCooldown {
//	public static void main(String args[]) {
//
//		int[] prices = { 7, 1, 5, 3, 6, 4 };
//		System.out.println(stockProfit(prices));
//	}
//
//	public static int stockProfit(int[] prices) {
//		int buyFlag = 1;
//		return maximizeProfit(prices, 0, buyFlag);
//	}
//
//	private static int maximizeProfit(int[] prices, int index, int buyFlag) {
//		
//		if(index == prices.length)return 0;
//		
//		int profit = 0;
//		
//		if(buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, buyFlag^1),
//					 0 + maximizeProfit(prices, index + 1, buyFlag));
//		}
//		else {
//			//since cooldown period as per question is 2, so after sell we will go to index of i+2th stock
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 2, buyFlag^1),
//					 0 + maximizeProfit(prices, index + 1, buyFlag));
//		}
//		
//		
//		return profit;
//	}
//}


//////////////////////////////////////////////////////////////  MEMOIZED SOLUTION

//public class DP38_StockBuySellMultipleTimesAllowedWithCooldown {
//	public static void main(String args[]) {
//
//		int[] prices = { 7, 1, 5, 3, 6, 4 };
//		System.out.println(stockProfit(prices));
//	}
//
//	public static int stockProfit(int[] prices) {
//		int buyFlag = 1;
//		int[][] dp = new int[prices.length][2];
//		for(int[] ar : dp)Arrays.fill(ar, -1);
//		
//		return maximizeProfit(prices, 0, buyFlag, dp);
//	}
//
//	private static int maximizeProfit(int[] prices, int index, int buyFlag, int[][] dp) {
//		
//		if(index >= prices.length)return 0;
//		
//		int profit = 0;
//		
//		if(dp[index][buyFlag] != -1)return dp[index][buyFlag];
//		
//		if(buyFlag == 1) {
//			profit = Math.max(-prices[index] + maximizeProfit(prices, index + 1, buyFlag^1, dp),
//					 0 + maximizeProfit(prices, index + 1, buyFlag, dp));
//		}
//		else {
//			//since cooldown period as per question is 2, so after sell we will go to index of i+2th stock
//			profit = Math.max(prices[index] + maximizeProfit(prices, index + 2, buyFlag^1, dp),
//					 0 + maximizeProfit(prices, index + 1, buyFlag, dp));
//		}
//		
//		
//		return dp[index][buyFlag] = profit;
//	}
//}

//////////////////////////////////////////////////////////////////////  TABULAR SOLUTION


public class DP39_StockBuySellMultipleTimesAllowedWithCooldown {
	public static void main(String args[]) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(stockProfit(prices));
	}

	public static int stockProfit(int[] prices) {
		int buyFlag = 1;
		int[][] dp = new int[prices.length+2][2];
		
		return maximizeProfit(prices, dp);
	}

	private static int maximizeProfit(int[] prices, int[][] dp) {
		
		
		int profit = 0;
		int n = prices.length;
		
		for(int index = n-1; index >= 0; index--) {
			for(int buyFlag = 1; buyFlag >= 0; buyFlag--) {
				
				if(buyFlag == 1) {
					profit = Math.max(-prices[index] + dp[index + 1][buyFlag^1],
							 0 + dp[index + 1][buyFlag]);
				}
				else {
					//since cooldown period as per question is 2, so after sell we will go to index of i+2th stock
					profit = Math.max(prices[index] + dp[index + 2][buyFlag^1],
							 0 + dp[index + 1][buyFlag]);
				}
				dp[index][buyFlag] = profit;
			}
		}
		
		
		return dp[0][1];
	}
}








