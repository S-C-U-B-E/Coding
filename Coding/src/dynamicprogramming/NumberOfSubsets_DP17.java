package dynamicprogramming;
import java.util.Arrays;

//Number of Subsets possible such that he sum of the numbers of a subset equals target sum.
//array = {1,2,2,3}  target = 3 
//ans -> 3  {1,2} {3} {1,2}

////////////////////////////////////////////////////////  RECURSIVE SOLITION

//public class NumberOfSubsets_DP17 {
//	public static void main(String args[]) {
//		
//		int[] arr = {1,2,2,3};
//		int target = 3;
//		
//		int ans = findNumberOfSubsets(arr , target , arr.length-1);
//		
//		System.out.println(ans);
//	}
//
//	private static int findNumberOfSubsets(int[] arr, int target, int index) {
//		if(target == 0)return 1;
//		if(target < 0)return 0;
//		if(index == 0) {
//			if(arr[index] == target)
//				return 1;
//			else return 0;
//		}
//		
//		int pick = findNumberOfSubsets(arr, target-arr[index], index-1);
//		int notPick = findNumberOfSubsets(arr, target, index-1);
//		
//		return (pick + notPick);
//	}
//}



////////////////////////////////////////////////////////         MEMOIZED SOLITION

//public class NumberOfSubsets_DP17 {
//	public static void main(String args[]) {
//
//		int[] arr = { 1, 2, 2, 3 };
//		int target = 3;
//		int dp[][] = new int[arr.length][target + 1];
//		for (int[] temp : dp) {
//			Arrays.fill(temp, -1);
//		}
//
//		int ans = findNumberOfSubsets(arr, target, arr.length - 1, dp);
//
//		System.out.println(ans);
//	}
//
//	private static int findNumberOfSubsets(int[] arr, int target, int index, int[][] dp) {
//		if (target == 0)
//			return 1;
//		if (target < 0)
//			return 0;
//		if (index == 0) {
//			if (arr[index] == target)
//				return 1;
//			else
//				return 0;
//		}
//
//		if (dp[index][target] != -1)
//			return dp[index][target];
//
//		int pick = findNumberOfSubsets(arr, target - arr[index], index - 1, dp);
//		int notPick = findNumberOfSubsets(arr, target, index - 1, dp);
//
//		return dp[index][target] = pick + notPick;
//	}
//}




/////////////////////////////////////////////////////////////////////////     TABULAR SOLUTION


public class NumberOfSubsets_DP17 {
	public static void main(String args[]) {

		int[] arr = { 1, 2, 2, 1};
		int target = 4;
		int dp[][] = new int[arr.length][target + 1];


		int ans = findNumberOfSubsets(arr, target, arr.length, dp);

		System.out.println(ans);
	}

	private static int findNumberOfSubsets(int[] arr, int target, int index, int[][] dp) {
//		if (target == 0)
//			return 1;
		for(int i=0; i<index ; i++) {
			dp[i][0] = 1;
		}
//		if (target < 0)
//			return 0;
		
//		if (index == 0) {
//			if (arr[index] == target)
//				return 1;
//			else
//				return 0;
//		}
		
		if(arr[0] <= target)dp[0][arr[0]] = 1;
		

//		if (dp[index][target] != -1)
//			return dp[index][target];
		
		for(int ind=1; ind<index; ind++) {
			for(int tar=0; tar<=target;tar++) {
				int pick = 0;
				if(arr[ind] <= tar)
					pick = dp[ind-1][tar - arr[ind]];
				int notPick = dp[ind-1][tar];
				
				dp[ind][tar] = pick + notPick;
			}
		}

		

		return dp[index-1][target];
	}
}
