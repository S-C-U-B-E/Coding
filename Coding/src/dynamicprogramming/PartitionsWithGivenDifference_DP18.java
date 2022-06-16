package dynamicprogramming;

//Same as DP17 but with a modified target
// S1 - S2 = D and S1 + S2 = TotalSum
// TotalSum - S2 - S2 = D
// TotalSum - D = 2 x S2
// 
// S2 = (TotalSum - D)/2 = target

//4 3
////1 0 8 5 1 4

public class PartitionsWithGivenDifference_DP18 {
		public static void main(String args[]) {
			
			int[] arr = {1,0,8,5,1,4};
			int diff = 17;
			
			int tot = 0;
			for(int i : arr)tot += i;
			
			if((tot-diff) < 0 || (tot - diff)%2 != 0)System.out.println(0);
			else {
				int target = (tot-diff)/2;
				int ans = findNumberOfSubsets(arr , target , arr.length-1);
				
				System.out.println(ans);
			}
		}

		private static int findNumberOfSubsets(int[] arr, int target, int index) {
//			if(target == 0)return 1;
//			if(target < 0)return 0;
			if(index == 0) {
				if(target == 0 && arr[index] == 0)return 2;
				if(target == 0 || target == arr[0])return 1;
				if(arr[index] == target)
					return 1;
				else return 0;
			}
			
			int pick =0;
			if(arr[index] <= target)pick = findNumberOfSubsets(arr, target-arr[index], index-1);
			int notPick = findNumberOfSubsets(arr, target, index-1);
			
			return (pick + notPick);
		}
	
}
