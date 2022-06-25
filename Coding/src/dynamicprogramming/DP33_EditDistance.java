package dynamicprogramming;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////  RECURSIVE SOLUTION

//public class DP33_EditDistance {
//
//	//CONVERTING S TO T
//	
//	public static void main(String args[]) {
//		String s = "horse";
//		String t = "ros";
//		
//		System.out.println(editDistance(s, t, s.length(), t.length()));
//	}
//
//	private static int editDistance(String s, String t, int i, int j) {
//
//		if(i < 0) {
//			return j+1;
//		}
//		
//		if(j < 0) {
//			return i+1;
//		}
//		
//		
//		if(s.charAt(i-1) == t.charAt(j-1)) {
//			return 0 + editDistance(s, t, i-1, j-1);
//		}else {
//			int deleteOption = 1 + editDistance(s, t, i-1, j); //Moving forward on S
//			int insertOption = 1 + editDistance(s, t, i, j-1); //Moving forward on T
//			int replaceOption = 1 + editDistance(s, t, i-1, j-1); //Moving forward on BOTH
//			
//			return Math.min(deleteOption, Math.min(insertOption, replaceOption) );
//		}
//		
//	}
//	
//	
//}

////////////////////////////////////////////////////////////////  MEMOIZED SOLUTION

//public class DP33_EditDistance {
//
//	//CONVERTING S TO T
//	
//	public static void main(String args[]) {
//		String s = "horse";
//		String t = "ros";
//		
//		int[][] dp = new int[s.length()][t.length()];
//		for(int[] ar : dp)Arrays.fill(ar, -1);
//		
//		System.out.println(editDistance(s, t, s.length()-1, t.length()-1, dp));
//	}
//
//	private static int editDistance(String s, String t, int i, int j, int[][] dp) {
//
//		if(i < 0) {
//			return j+1;
//		}
//		
//		if(j < 0) {
//			return i+1;
//		}
//		
//		if(dp[i][j] != -1)return dp[i][j];
//		
//		if(s.charAt(i) == t.charAt(j)) {
//			return dp[i][j] = 0 + editDistance(s, t, i-1, j-1, dp);
//		}else {
//			int deleteOption = 1 + editDistance(s, t, i-1, j, dp); //Moving forward on S
//			int insertOption = 1 + editDistance(s, t, i, j-1, dp); //Moving forward on T
//			int replaceOption = 1 + editDistance(s, t, i-1, j-1, dp); //Moving forward on BOTH
//			
//			return dp[i][j] = Math.min(deleteOption, Math.min(insertOption, replaceOption) );
//		}
//		
//	}
//	
//	
//}

///////////////////////////////////////////////////////////////////////////////  TABULAR METHOD

public class DP33_EditDistance {

	// CONVERTING S TO T

	public static void main(String args[]) {
		String s = "horse";
		String t = "ros";

		int[][] dp = new int[s.length()+1][t.length()+1];

		System.out.println(editDistance(s, t, s.length(), t.length(), dp));
		
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
		
	}

	private static int editDistance(String s, String t, int i, int j, int[][] dp) {


		for(int v=0; v<=i; v++) {
			dp[v][0] = v;
		}

		for(int v=0; v<=j; v++) {
			dp[0][v] = v;
		}

		
		for(int v=1; v<=i; v++) {
			for(int w=1; w<=j; w++) {
				if (s.charAt(v-1) == t.charAt(w-1)) {
					 dp[v][w] = 0 + dp[v - 1][w - 1];
				} else {
					int deleteOption = 1 + dp[v - 1][w]; // Moving forward on S
					int insertOption = 1 + dp[v][w - 1]; // Moving forward on T
					int replaceOption = 1 + dp[v - 1][w - 1]; // Moving forward on BOTH

					dp[v][w] = Math.min(deleteOption, Math.min(insertOption, replaceOption));
				}
			}
		}

		return dp[i][j];

	}


}
