package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String args[]) {
		int[] arr = {25,22,86,65,1,0,-1,100};
		
		for(int i=0;i<arr.length;i++) {
			int min = Integer.MAX_VALUE;
			int index = i;
			for(int j=i; j<arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			
			if(index > i) {
				int temp = arr[i];
				arr[i] = min;
				arr[index] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
