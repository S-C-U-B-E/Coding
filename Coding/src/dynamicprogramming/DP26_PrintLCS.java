package dynamicprogramming;

import java.util.Arrays;

//HERE WE WILL USE THE TABULAR SOL. OF DP25 I.E THE LCS SOL.


public class DP26_PrintLCS {
	public static void main(String args[]) {
	
		String s1 = "abcasdaztfefe";
		String s2 = "czef";
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println(lcs(s1 , s2 ,  s1.length(), s2.length(), dp));
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
		
		StringBuilder sb = new StringBuilder();
		
		int i = s1.length();
		int j = s2.length();
		
		while(i > 0 && j > 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;j--;
			}else {
				if(dp[i-1][j] >= dp[i][j-1])
					i--;
				else j--;
			}
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