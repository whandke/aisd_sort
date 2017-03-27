public class Sort {
	
	public static void selectionSort (int[] array)
	{
		long starts = Timer.set();
		
		SelectionSort.sort(array);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));	        
	}
	
	public static void insertionSort(int[] array) {
		
		long starts = Timer.set();
		
		InsertionSort.sort(array);
	     
	     long ends = Timer.set();
	     Timer.printTime(Timer.timeElapsed(starts, ends));
	}
	
	public static void bubbleSort(int[] array) {
		
		long starts = Timer.set();
		
		BubbleSort.sort(array);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));
	}
	
	public static void heapSort(int[] array){
		
		long starts = Timer.set();
		
		HeapSort.sort(array);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));		
	}
	
	public static void mergeSort(int[] array){
		
		long starts = Timer.set();
		
		MergeSort.sort(array);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));
	}
	
	public static void quickSort(int[] array, boolean piv){
		
		long starts = Timer.set();
		
		QuickSort.sort(array, piv);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));
	}	
	
	public static void countingSort(int[] array, float interval){
		
		long starts = Timer.set();
		
		CountingSort.sort(array, interval);
		
		long ends = Timer.set();
		Timer.printTime(Timer.timeElapsed(starts, ends));
	}
	

	
	
}
