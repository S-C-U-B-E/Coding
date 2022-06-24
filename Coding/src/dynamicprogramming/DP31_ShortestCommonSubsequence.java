package dynamicprogramming;

import java.util.Arrays;


public class DP31_ShortestCommonSubsequence {
	public static void main(String args[]) {
	
		String s1 = "brute";
		String s2 = "groot";
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println(lcs(s1 , s2 ,  s1.length(), s2.length(), dp));
		printShortestCommonSupersequence(dp, s1, s2);
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
	}

	
	private static void printShortestCommonSupersequence(int[][] dp ,String s ,String t) {
		int n = s.length();
		int m = t.length();
		
		StringBuilder sb = new StringBuilder();
		
		while(n>0 && m>0) {
			if(s.charAt(n-1) == t.charAt(m-1))
				{
				sb.append(s.charAt(n-1));
				n--;
				m--;
				}else {
				if(dp[n-1][m] >= dp[n][m-1]) {
					sb.append(s.charAt(n-1));
					n--;
				}else {
					sb.append(t.charAt(m-1));
					m--;
				}
			}
		}
		
		while(n>0) {
			sb.append(s.charAt(n-1));
			n--;
		}
		
		while(m>0) {
			sb.append(t.charAt(m-1));
			m--;
		}
		
		System.out.println(sb.reverse());
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
