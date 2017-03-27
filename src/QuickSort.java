public class QuickSort {
	
	public static void sort(int[] array, boolean piv) {
		
        int length = array.length;
        quickSortPriv(array, 0, length - 1, piv);
    }
 
    
	 private static void quickSortPriv(int[] array, int lowerIndex, int higherIndex, boolean piv) {
         
	        int i = lowerIndex;
	        int j = higherIndex;
	        int pivot;
	        
	        if(piv)
	        	pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        else
	        	pivot = array[lowerIndex];
	        
	        while (i <= j) {
	            
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(array, i, j);
	                i++;
	                j--;
	            }
	        }
	        if (lowerIndex < j)
	            quickSortPriv(array, lowerIndex, j, piv);
	        if (i < higherIndex)
	            quickSortPriv(array, i, higherIndex, piv);
	    }
	 
	    private static void exchangeNumbers(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

}
