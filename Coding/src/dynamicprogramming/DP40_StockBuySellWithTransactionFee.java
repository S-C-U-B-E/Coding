package dynamicprogramming;

// Just copy pasted the buy & sell stock multiple time s allowed and deducted the fee at the sell phase 

public class DP40_StockBuySellWithTransactionFee {
	public static void main(String args[]) {

		int[] prices = {1,3,2,8,4,9};
		int fee = 2;
		System.out.println(stockProfit(prices.length, fee, prices));
	}

	public static int stockProfit(int n, int fee, int[] prices) {
		int buyFlag = 1;
		int[][] dp = new int[prices.length+2][2];
		
		return maximizeProfit(prices, fee,  dp);
	}

	private static int maximizeProfit(int[] prices, int fee, int[][] dp) {
		
		
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
					//just deducted the fee while the sale is being made
					profit = Math.max(prices[index] -fee  + dp[index + 1][buyFlag^1],
							 0 + dp[index + 1][buyFlag]);
				}
				dp[index][buyFlag] = profit;
			}
		}
		
		
		return dp[0][1];
	}
}
