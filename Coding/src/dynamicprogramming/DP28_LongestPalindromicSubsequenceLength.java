package dynamicprogramming;

import java.util.Arrays;

// THIS IS BY FAR THE BRILLIANT QUESTION I FOUND IN THE SERIES
// MAIN FACT: IF WE REVERSE THE INPUT STRING 'S', AND CALL IT 'T'
// WHATEVER THE PALINDROMIC SEQUENCE OF CHARACTERS WERE PRESENT IN 'S' 
// WILL ALSO BE PRESENT IN 'T' IN SAME FASHION, SINCE THEY WERE IN PALINDROMIC FASHION IN 'S'
// SO REVERSING THE ENTIRE STRING HAS NO EFFECT ON THAT PARTICULAR SET OF CHARATCERS

// PLUS, THEY WILL ALSO BE THE COMMON SUBSEQUENCE IN THE NEW STRING 'T'
// HENCE USING LCS -> DP25


public class DP28_LongestPalindromicSubsequenceLength {

	public static void main(String arasdda[]) {
		
		String s = "Shankha";
		String t = new String(new StringBuilder(s).reverse());
		
		System.out.println(s +" " + t);
		
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		System.out.println(lcs(s , t ,  s.length(), t.length(), dp));
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
	}
	
	public static int lcs(String s1, String s2, int s1length, int s2length, int[][] dp) {
		
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
