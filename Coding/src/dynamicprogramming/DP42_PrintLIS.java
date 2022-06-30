package dynamicprogramming;

import java.util.Arrays;

public class DP42_PrintLIS {
	public static void main(String args[]) {
		int[] arr = { 5, 4, 11, 1, 16, 8, 0, 19, 21, 2, 1, 4, 8, 23 };
		System.out.println("Icreasing subsequence -> " + longestIncreasingSubsequence(arr));
	}

	public static String longestIncreasingSubsequence(int arr[]) {

		return findLIS(arr);
	}

	// Here we will keep a track of the numbers
	private static String findLIS(int[] arr) {

		// length array -> keep the lenghts of increasing subsequence uptil current
		// index
		// backtrack array -> to track the LIS
		int N = arr.length;

		int[] length = new int[N];
		Arrays.fill(length, 1); // Every element in itself is the LIS hence 1

		int[] backTrack = new int[N];

		int longestLength = -1;
		int longestLengthIndex = 0;

		for (int cur_index = 0; cur_index < N; cur_index++) {
			int temp = length[cur_index];
			int prevLength = length[cur_index]; // Just to keep track if the value is changing, then we can update the
												// backtrack & length array

			int temp2 = longestLength; // To keep track of the largest length value and the index where it occurs
			System.out.println(cur_index + " temp: " + temp + " :-> ");

			for (int prev_index = 0; prev_index < cur_index; prev_index++) {
				if (arr[prev_index] < arr[cur_index]) {

					length[cur_index] = Math.max(length[cur_index], temp + length[prev_index]);

					if (prevLength != length[cur_index]) {
						prevLength = length[cur_index];
						backTrack[cur_index] = prev_index;

						longestLength = Math.max(longestLength, length[cur_index]);
						if (temp2 != longestLength) {
							temp2 = longestLength;
							longestLengthIndex = cur_index;
						}
					}

					System.out.println(Arrays.toString(length));
					System.out.println(Arrays.toString(backTrack));
					System.out.println();
				}
			}
		}

		System.out.println(longestLength + " " + longestLengthIndex);

		int[] LISPattern = new int[longestLength];
		int ind = longestLength - 1;

		while (longestLengthIndex >= 0) {

			LISPattern[ind] = arr[longestLengthIndex];
			ind--;

			if (longestLengthIndex == 0)
				break;
			longestLengthIndex = backTrack[longestLengthIndex];

		}

		return Arrays.toString(LISPattern);
	}
}
