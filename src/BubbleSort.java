public class BubbleSort {
	
	public static void sort(int[] array) {

		long n = array.length;
		int param;
		do{
			for(int i = 0; i < n-1; i++){
				if(array[i] > array[i+1]){
					param = array[i];
					array[i] = array[i+1];
					array[i+1] = param;					
				}
			}
			n--;
		}
		while(n > 1);
	}

}
