package dynamicprogramming;
//REPEAT OF COINS ALLOWED

public class MinimumCoins {

	public static void main(String args[]) {

		int[] array = { 1, 2, 3 };
		int target = 7;
		int dp[][] = new int[array.length + 1][target + 1];
		int ans = minimumElements(array, target, array.length - 1, dp);

		System.out.println(ans);

	}

	public static int minimumElements(int num[], int x, int n, int[][] dp) {
		if (x == 0)
			return 0;
		if (x < 0)
			return Integer.MAX_VALUE;

		if (dp[n][x] != 0)
			return dp[n][x];
		int notPick = minimumElements(num, x, n - 1, dp);
		int pick = Integer.MAX_VALUE;
		if (num[n] <= x)
			pick = 1 + minimumElements(num, x - num[n], n, dp);

		return dp[n][x] = Math.min(pick, notPick);

	}
}
