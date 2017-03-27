public class SelectionSort {
	public static void sort (int[] array)
	{
		 for (int i = 0; i < array.length - 1; i++)
	        {
	            int ind = i;
	            for (int j = i + 1; j < array.length; j++)
	                if (array[j] < array[ind])
	                    ind = j;
	      
	            int min = array[ind]; 
	            array[ind] = array[i];
	            array[i] = min;
	           
	        }       
	}

}
