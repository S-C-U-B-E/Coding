package dynamicprogramming;

import java.util.Arrays;

//////////////////////////////////////////////////////  My Recursive Solution

//public class DP32_DistinctSubsequences {
//	//static int ans = 0;
//	public static void main(String args[]) {
//	
//		String s = "abgbaggg";
//		String t = "bag";
//		
//		System.out.println(numberOfDistinctSubsequences(s , t, s.length(), t.length(), 0));
//		
//	}
//
//	private static int numberOfDistinctSubsequences(String s, String t, int i, int j, int ans) {
//		
//		if(j == 0)return 1;
//		
//		
//		for( ; i>0; i--) {
//			if(t.charAt(j-1) == s.charAt(i-1)) {
//				if(j != 0)ans += numberOfDistinctSubsequences(s, t, i-1, j-1, 0);
//			}
//		}
//		
//		return ans;
//	}
//}

////////////////////////////////////////////////////////////// Studied Recursive Solution

//public class DP32_DistinctSubsequences {
//
//	public static void main(String args[]) {
//	
//		String s = "abgbaggg";
//		String t = "bag";
//		
//		System.out.println(numberOfDistinctSubsequences(s , t, s.length()-1, t.length()-1));
//		
//	}
//
//	private static int numberOfDistinctSubsequences(String s, String t, int i, int j) {
//		
//		if(i < 0 ) {
//			return 0;
//		}else if(j < 0) {
//			return 1;
//		}
//		
//		if(s.charAt(i) == t.charAt(j)) {
//			return numberOfDistinctSubsequences(s, t, i-1, j-1) +
//					numberOfDistinctSubsequences(s, t, i-1, j);
//		}else {
//			return numberOfDistinctSubsequences(s, t, i-1, j);
//		}
//		
//	}
//}


/////////////////////////////////////////////////////////////////////  MEMOIZED SOLUTION


//public class DP32_DistinctSubsequences {
//	static int prime = (int)(Math.pow(10,9)+7);
//	public static void main(String args[]) {
//	
//		String s = "brootgroot";
//		String t = "brt";
//		
//		int[][] dp = new int[s.length()][t.length()];
//		for(int[] ar : dp)Arrays.fill(ar, -1);
//		
//		System.out.println(numberOfDistinctSubsequences(s , t, s.length()-1, t.length()-1, dp));
//		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
//		
//	}
//
//	private static int numberOfDistinctSubsequences(String s, String t, int i, int j, int[][] dp) {
//		
//
//		if(j < 0) {
//			return 1;
//		}
//		if(i < 0 ) {
//			return 0;
//		}
//		
//		
//		if(dp[i][j] != -1)return dp[i][j];
//		
//		if(s.charAt(i) == t.charAt(j)) {
//			return dp[i][j] = (numberOfDistinctSubsequences(s, t, i-1, j-1, dp) +
//					numberOfDistinctSubsequences(s, t, i-1, j, dp)) % prime;
//		}else {
//			return dp[i][j] = numberOfDistinctSubsequences(s, t, i-1, j, dp);
//		}
//		
//	}
//}



//////////////////////////////////////////////////////////////////////////  TABULAR SOLUTION


public class DP32_DistinctSubsequences {
	static int prime = (int)(Math.pow(10,9)+7);
	public static void main(String args[]) {
	
		String s = "brootgroot";
		String t = "brt";
		
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		System.out.println(numberOfDistinctSubsequences(s , t, s.length(), t.length(), dp));
		for(int[] ar : dp)System.out.println(Arrays.toString(ar));
		
	}

	private static int numberOfDistinctSubsequences(String s, String t, int n, int m, int[][] dp) {

	    for(int i=0;i<n+1;i++){
	        dp[i][0]=1;
	    }
	    for(int i=1;i<m+1;i++){
	        dp[0][i]=0;
	    }
		
		
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<m+1;j++){
	            
	            if(s.charAt(i-1)== t.charAt(j-1))
	                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%prime;
	            else
	                dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    
	    return dp[n][m];
	}
}







