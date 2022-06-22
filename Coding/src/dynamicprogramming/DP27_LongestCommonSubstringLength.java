package dynamicprogramming;

import java.util.Arrays;


// USED THE LCS TABULAR SOLUTION FOR THIS ONE
// IN CASE OF NOT MATCH WE WILL HAVE 0, SINCE WE ARE ONLY LOOKING FOR CONSEQUITIVE SAME CHARACTERS
// THE ANSWER WILL BE THE MAXIMUM VALUE AMONG ALL THE CELLS IN THE DP ARRAY


public class DP27_LongestCommonSubstringLength {
	public static void main(String args[]) {

		String s1 = "abcasdaztfefe";
		String s2 = "czefe";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		System.out.println(lcs(s1, s2, s1.length(), s2.length(), dp));
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
	}

	private static int lcs(String s1, String s2, int s1length, int s2length, int[][] dp) {

		// Base case :-
		// 1st row and 1st column will be all 0
		int ans = 0;

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				int match = 0;
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					match = 1 + dp[i - 1][j - 1];

				int notMatch = 0;

				dp[i][j] = Math.max(match, notMatch);
				ans = Math.max(dp[i][j], ans);
			}
		}

//         for(int[] ar : dp)System.out.println(Arrays.toString(ar));
		return ans;
	}
}