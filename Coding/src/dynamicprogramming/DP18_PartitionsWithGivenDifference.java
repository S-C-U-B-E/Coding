package dynamicprogramming;

import java.util.Arrays;

//Thinsg to Note:->

//1. Same as DP17 but with a modified target
// S1 - S2 = D and S1 + S2 = TotalSum
// TotalSum - S2 - S2 = D
// TotalSum - D = 2 x S2
// 
// S2 = (TotalSum - D)/2 = target

//2. Add the base cases considering the array will have 0s. We will not stop the recursion when target becomes 0, rather we will 
//let it move towards index 0

//4 3
////1 0 8 5 1 4

//////////////////////////////////////////////////////   RECURSIVE SOLITION

//public class PartitionsWithGivenDifference_DP18 {
//	public static int mod = (int)(1e9+7); //10^9 not working
//		public static void main(String args[]) {
//			
//			int[] arr = {1,0,8,5,1,4};
//			int diff = 17;
//			
//			int tot = 0;
//			for(int i : arr)tot += i;
//			
//			if((tot-diff) < 0 || (tot - diff)%2 != 0)System.out.println(0);
//			else {
//				int target = (tot-diff)/2;
//				int ans = findNumberOfSubsets(arr , target , arr.length-1);
//				
//				System.out.println(ans);
//			}
//		}
//
//		private static int findNumberOfSubsets(int[] arr, int target, int index) {

//			if(index == 0) {
//				if(target == 0 && arr[index] == 0)return 2;
//				if(target == 0 || target == arr[0])return 1;
//				else return 0;
//			}
//			
//			int pick =0;
//			if(arr[index] <= target)pick = findNumberOfSubsets(arr, target-arr[index], index-1);
//			int notPick = findNumberOfSubsets(arr, target, index-1);
//			
//			return (pick + notPick)%mod;
//		}
//	
//}

//////////////////////////////////////////////////////	MEMOIZED SOLUTION

//public class PartitionsWithGivenDifference_DP18 {
//	public static int mod = (int)(1e9+7); //10^9 not working
//		public static void main(String args[]) {
//			
//			int[] arr = {1,0,8,5,1,4};
//			int diff = 17;
//			
//			int tot = 0;
//			for(int i : arr)tot += i;
//			
//			if((tot-diff) < 0 || (tot - diff)%2 != 0)System.out.println(0);
//			else {
//				int target = (tot-diff)/2;
//				int[][] dp = new int[arr.length][target+1];
//				for(int[] ar : dp)Arrays.fill(ar, -1);
//				
//				int ans = findNumberOfSubsets(arr , target , arr.length-1, dp);
//				
//				System.out.println(ans);
//			}
//		}
//
//		private static int findNumberOfSubsets(int[] arr, int target, int index, int[][] dp) {
////			if(target == 0)return 1;
////			if(target < 0)return 0;
//			if(index == 0) {
//				if(target == 0 && arr[index] == 0)return 2;
//				if(target == 0 || target == arr[index])return 1;
//				else return 0;
//			}
//			
//			if(dp[index][target] != -1)return dp[index][target];
//			
//			int pick =0;
//			if(arr[index] <= target)pick = findNumberOfSubsets(arr, target-arr[index], index-1, dp);
//			int notPick = findNumberOfSubsets(arr, target, index-1, dp);
//			
//			return dp[index][target] = (pick + notPick)%mod;
//		}
//	
//}

//////////////////////////////////////////////////////   TABULATION METHOD 

public class DP18_PartitionsWithGivenDifference {
	public static int mod = (int) (1e9 + 7); // 10^9 not working

	public static void main(String args[]) {

		int[] arr = { 3, 1, 1, 2, 1 };
		int diff = 0;

		int tot = 0;
		for (int i : arr)
			tot += i;

		if ((tot - diff) < 0 || (tot - diff) % 2 != 0)
			System.out.println(0);
		else {
			int target = (tot - diff) / 2;
			int[][] dp = new int[arr.length][target + 1];

			int ans = findNumberOfSubsets(arr, target, arr.length, dp);

			System.out.println(ans);
		}
	}

	private static int findNumberOfSubsets(int[] arr, int target, int index, int[][] dp) {

		// If at any position we have a 0, then picking and not picking it both should
		// be included,
		// Bcz picking and not-picking 0 doesn't alter the sum.. so for not-picking of

		if (arr[0] == 0)
			dp[0][0] = 2;
		else
			dp[0][0] = 1;

		if (arr[0] != 0 && arr[0] <= target)
			dp[0][arr[0]] = 1;

		for (int ind = 1; ind < index; ind++) {
			for (int tar = 0; tar <= target; tar++) {

				int pick = 0;
				if (arr[ind] <= tar)
					pick = dp[ind - 1][tar - arr[ind]];
				int notPick = dp[ind - 1][tar];

				dp[ind][tar] = (pick + notPick) % mod;
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println();

		return dp[index - 1][target];
	}

}
