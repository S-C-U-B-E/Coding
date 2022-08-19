package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String args[]) {
		int[] arr = {25,22,86,65,1,0,-1,100};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
