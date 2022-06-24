package dynamicprogramming;

import java.util.Arrays;


// ANSWER = LENGTH OF THE ORIGINAL STRING - THE LONGEST PALINDROMIC SUBSEQUENCE


public class DP29_MinimumInsertionsToMakeStringPalindrome {
	public static void main(String args[]) {

		String s = "Shankha";
		String t = new String(new StringBuilder(s).reverse());

		System.out.println(s + " " + t);

		int[][] dp = new int[s.length() + 1][t.length() + 1];

		System.out.println(s.length() - lcs(s, t, s.length(), t.length(), dp));

		for (int[] ar : dp)
			System.out.println(Arrays.toString(ar));
	}

	public static int lcs(String s1, String s2, int s1length, int s2length, int[][] dp) {

		// Base case :-
		// 1st row and 1st column will be all 0

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				int match = 0;
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					match = 1 + dp[i - 1][j - 1];

				int notMatch = Math.max(dp[i - 1][j], dp[i][j - 1]);

				dp[i][j] = Math.max(match, notMatch);
			}
		}

		return dp[s1length][s2length];
	}
}
