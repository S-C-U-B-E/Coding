package searching;

//THIS BINARY SEARCH IS NEEDED FOR DP43_LISBinarySearchTechnique
//SO THIS WILL RETURN EITHER THE INDEX OF THE NUMBER WE ARE  LOOKING FOR
//OR THE INDEX OF THE NEXT GREATER ELEMENT IN THE ARRAY

public class BinarySearch {
	public static void main(String args[]) {
		int[] sortedArray = { 5, 6, 10, 12, 17};
		int target = 13;
		int index = customBinarySearch(sortedArray, target);
		
		//System.out.println("Index : " + index+ " Element -> " +sortedArray[index]);
	}

	public static int customBinarySearch(int[] sortedArray, int target) {
		
		int index = 0;
		int lo = 0;
		int hi = sortedArray.length-1;
		
		while(lo <= hi) {
			int mid = lo + (hi -  lo)/2;
			index = mid;
			//System.out.println(index);
			
			if(sortedArray[mid] == target) {
				return mid; //IF FOUND GOOD
			}else {
				if(target > sortedArray[mid])lo = mid + 1;
				else hi = mid - 1;
			}
		}
		
		// IF NOT FOUND , RETURN THE LAST INDEX WE REACHED OUT TO
		return index;
	}

}
