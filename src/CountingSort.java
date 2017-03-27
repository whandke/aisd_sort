public class CountingSort {
	
	public static void sort(int[] array, float interval){
		
		int n = array.length;
		
		int[] finalArray = new int[n];
		int[] countingArray = new int[(int)interval+1];
		
		for(int i = 0; i <= (int)interval; i++)
			countingArray[i] = 0;
		
		for(int i = 0; i < n; i++)
			countingArray[array[i]]++;
		
		for(int i = 1; i <= (int)interval; i++)
			countingArray[i] += countingArray[i-1];
		
		for(int i = n - 1; i >= 0; i--){
			finalArray[countingArray[array[i]]-1] = array[i];
			countingArray[array[i]] -= 1;
		}
		
		for(int i = 0; i < n; i++)
			array[i] = finalArray[i];
	}

}
