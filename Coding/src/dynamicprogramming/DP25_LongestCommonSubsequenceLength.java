package dynamicprogramming;

import java.util.Arrays;


///////////////////////////////////////////////////////////////////  RECURSIVE SOLUTION


//public class DP25_LongestCommonSubsequenceLength {
//	public static void main(String args[]) {
//	
//		String s1 = "abcghgjhz";
//		String s2 = "czef";
//		
//		System.out.println(lcs(s1 , s2 ,  s1.length()-1, s2.length()-1));
//		
//	}
//
//	private static int lcs(String s1, String s2, int s1length, int s2length) {
//		
//		if(s1length < 0 || s2length < 0)return 0;
//		
//		int match = 0;
//		if(s1.charAt(s1length) == s2.charAt(s2length))
//		match = 1  +  lcs(s1, s2, s1length-1, s2length-1);
//		
//		int notMatch = Math.max(lcs(s1, s2, s1length-1, s2length), lcs(s1, s2, s1length, s2length-1));
//		
//		return Math.max(match, notMatch);
//	}
//	
//}


///////////////////////////////////////////////////////////////////  MEMOIZED SOLUTION


//CHECK FOR THE INDEXES WHEN USING THE STORING TABLE, WILL HAVE AN EXTRA ROW AND COLUMN WHICH WILL BE THE BASE CASE
// IF, S1 HAS 0 LENGTH THEN NO COMMON SEQUENCE I.E. DP[0][0 -> S2.LENGTH] = 0 (1ST ROW ALL 0)
// SIMILARLY, IF S2 HAS 0 LENGTH THEN NO COMMON SEQUENCE I.E. DP[0 -> S1.LENGTH][0] = 0 (1ST COLUMN ALL 0)

//public class DP25_LongestCommonSubsequenceLength {
//	public static void main(String args[]) {
//	
//		String s1 = "abcghgjhz";
//		String s2 = "czef";
//		
//		int[][] dp = new int[s1.length()+1][s2.length()+1];
//		for(int i=1;i<=s1.length();i++) {
//			for(int j=1;j<=s2.length();j++) {
//				dp[i][j] = -1;
//			}
//		}
//		
//		System.out.println(lcs(s1 , s2 ,  s1.length(), s2.length(), dp));
//		
//		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
//	}
//
//	private static int lcs(String s1, String s2, int s1length, int s2length, int[][] dp) {
//		
//		if(s1length < 0 || s2length < 0)return 0;
//		
//		if(dp[s1length][s2length] != -1)return dp[s1length][s2length];
//		
//		int match = 0;
//		if(s1.charAt(s1length-1) == s2.charAt(s2length-1))
//		match = 1  +  lcs(s1, s2, s1length-1, s2length-1, dp);
//		
//		int notMatch = Math.max(lcs(s1, s2, s1length-1, s2length, dp), lcs(s1, s2, s1length, s2length-1, dp));
//		
//		return dp[s1length][s2length] = Math.max(match, notMatch);
//	}
//	
//}


///////////////////////////////////////////////////////////////////////////////   TABULAR SOLUTION


public class DP25_LongestCommonSubsequenceLength {
	public static void main(String args[]) {
	
		String s1 = "abc";
		String s2 = "cef";
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println(lcs(s1 , s2 ,  s1.length(), s2.length(), dp));
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
	}

	private static int lcs(String s1, String s2, int s1length, int s2length, int[][] dp) {
		
		//Base case :-
		//1st row and 1st column will be all 0
		
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				int match = 0;
				if(s1.charAt(i-1) == s2.charAt(j-1))
				match = 1  +  dp[i-1][j-1];
				
				int notMatch = Math.max(dp[i-1][j], dp[i][j-1]);
				
				dp[i][j] = Math.max(match, notMatch);
			}
		}
		
		
		return dp[s1length][s2length];
	}
	
}
