package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////   RECURSIVE SOLUTION

//public class DP34_WildCardMatching {
//	public static void main(String args[]) {
//		
//		String s1 = "e*ay";
//		String s2 = "earay";
//		
//		System.out.println(matcher(s1, s2, s1.length()-1, s2.length()-1));
//	}
//
//	private static boolean matcher(String s1, String s2, int s1l, int s2l) {
//		
//		if(s1l < 0 && s2l < 0)return true;
//		if(s1l < 0 && s2l >= 0)return false;
//		if(s2l < 0 && s1l >= 0) {
//			for(int i=s1l; i>=0; i--) {
//				if(s1.charAt(i) != '*')return false;
//			}
//			
//			return true;
//		}
//		
//		if(s1.charAt(s1l) == s2.charAt(s2l) || s1.charAt(s1l) == '?' )
//			return matcher(s1, s2, s1l-1, s2l-1);
//		else if(s1.charAt(s1l) == '*') {
//			return matcher(s1, s2, s1l-1, s2l) || matcher(s1, s2, s1l, s2l-1);
//		}else {
//			return false;
//		}
//		
//	}
//}


/////////////////////////////////////////////////////////////////////// MEMOIZED SOLUTION


public class DP34_WildCardMatching {
	public static void main(String args[]) {
		
		String s1 = "e*ay";
		String s2 = "earay";
		
		Boolean dp[][] = new Boolean[s1.length()][s2.length()];
		for(Boolean[] ar : dp)Arrays.fill(ar, null);
		
		System.out.println(matcher(s1, s2, s1.length()-1, s2.length()-1, dp));
	}

	private static boolean matcher(String s1, String s2, int s1l, int s2l, Boolean[][] dp) {
		
		if(s1l < 0 && s2l < 0)return true;
		if(s1l < 0 && s2l >= 0)return false;
		if(s2l < 0 && s1l >= 0) {
			for(int i=s1l; i>=0; i--) {
				if(s1.charAt(i) != '*')return false;
			}
			
			return true;
		}
		
		if(dp[s1l][s2l] != null)return dp[s1l][s2l];
		
		if(s1.charAt(s1l) == s2.charAt(s2l) || s1.charAt(s1l) == '?' )
			return dp[s1l][s2l] = matcher(s1, s2, s1l-1, s2l-1, dp);
		else if(s1.charAt(s1l) == '*') {
			return dp[s1l][s2l] = matcher(s1, s2, s1l-1, s2l, dp) || matcher(s1, s2, s1l, s2l-1, dp);
		}else {
			return dp[s1l][s2l] = false;
		}
		
	}
}



