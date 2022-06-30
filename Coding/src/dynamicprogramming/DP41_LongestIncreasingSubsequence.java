package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////  RECURSIVE SOLUTION

//public class DP41_LongestIncreasingSubsequence {
//	public static void main(String args[]) {
//
//		int[] arr = {5, 4, 11, 1, 16,8};
//		System.out.println(longestIncreasingSubsequence(arr));
//		
//	}
//	
//	public static int longestIncreasingSubsequence(int arr[]) {
//		
//		return findLIS(arr , 0, -1);
//	}
//
//	private static int findLIS(int[] arr, int cur_index, int prev_index) {
//		
//		if(cur_index == arr.length)return 0;
//		
//		int len = 0;
//		
//		len = 0 + findLIS(arr, cur_index + 1 , prev_index);
//		
//		if(prev_index == -1 || arr[cur_index] > arr[prev_index])
//			len = Math.max(len, 1 + findLIS(arr, cur_index + 1, cur_index));
//		
//		return len;
//	}
//}

////////////////////////////////////////////////////////////////   MEMOIZED SOLUTION

//This will get a runtime error based on the constraint
//example: if the array length can go upto 10^5 then a 10^5 x 10^5 matrix will cause runtime error

//public class DP41_LongestIncreasingSubsequence {
//	public static void main(String args[]) {
//
//		int[] arr = {5, 4, 11, 1, 16,8};
//		System.out.println(longestIncreasingSubsequence(arr));
//		
//	}
//	
//	public static int longestIncreasingSubsequence(int arr[]) {
//		
//		int n = arr.length;
//		int[][] dp = new int[n][n+1];
//		
//		for(int[] ar : dp)Arrays.fill(ar, -1);
//		
//		return findLIS(arr , 0, -1, dp);
//	}
//
//	private static int findLIS(int[] arr, int cur_index, int prev_index, int[][] dp) {
//		
//		if(cur_index == arr.length)return 0;
//		
//		if(dp[cur_index][prev_index+1] != -1)return dp[cur_index][prev_index+1];
//		
//		int len = 0;
//		
//		len = 0 + findLIS(arr, cur_index + 1 , prev_index, dp);
//		
//		if(prev_index == -1 || arr[cur_index] > arr[prev_index])
//			len = Math.max(len, 1 + findLIS(arr, cur_index + 1, cur_index, dp));
//		
//		return dp[cur_index][prev_index+1] = len;
//	}
//}

////////////////////////////////////////////////////////////////  TABULAR SOLUTION

//Still an N^2 Solution, will give error for 10^5 input, Check DP42

public class DP41_LongestIncreasingSubsequence {
	public static void main(String args[]) {

		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(longestIncreasingSubsequence(arr));

	}

	public static int longestIncreasingSubsequence(int arr[]) {

		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];

		return findLIS(arr, dp);
	}

	private static int findLIS(int[] arr, int[][] dp) {

		// NOT FILLING UP FOR BASE CASES BCZ BASE CASE WILL HAVE VALUE OF 0 ONLY
		int n = arr.length;

		for (int cur_index = n - 1; cur_index >= 0; cur_index--) {
			for (int prev_index = cur_index - 1; prev_index >= -1; prev_index--) {
				/*
				 * since we dont have a -1 index for prev_index everywhere we use prev_index we
				 * will shit it with +1
				 */
				int len = 0;

				len = 0 + dp[cur_index + 1][prev_index + 1]; // Index shifted with +1 for prev_index

				if (prev_index == -1 || arr[cur_index] > arr[prev_index])
					// the -1 condition is alread handeled in above if statement
					// if we have also shifted the prev_index in above if statement
					// then for all the cases where prev_index is NOT -1, the logic itself will
					// alter

					len = Math.max(len, 1 + dp[cur_index + 1][cur_index + 1]);
				    // the column for prev_index has a shift of +1

				dp[cur_index][prev_index + 1] = len;
			}
		}

		return dp[0][-1 + 1]; // answer should be in -1, but with index shift we need to add +1
	}
}