package dynamicprogramming;

//BUY ONCE AND SELL ONCE

public class DP35_StockBuySellOnceOnly {
	public static void main(String args[]) {
		int[] prices = {7,1,4,3,5,9};
		
		int SP = 0;
		int maxPROFIT = 0;
		int minCP = prices[0];
		
		for(int i=1; i<prices.length; i++) {
			
			SP = prices[i];
			int PROFIT = SP - minCP;
			maxPROFIT = Math.max(maxPROFIT, PROFIT);
			minCP = Math.min(prices[i], minCP);
		}
		
		System.out.println(maxPROFIT);
	}
}
