public class HeapSort {
	
	private static int[] array;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildHeap(int[] a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--)
            maxHeap(a,i);
    }
    
    public static void maxHeap(int[] a, int i){ 
    	
        left=2*i;
        right=2*i+1;
        
        if(left <= n && a[left] > a[i])
            largest=left;
        else largest=i;
        
        if(right <= n && a[right] > a[largest])
            largest=right;
        
        if(largest!=i){
            exchange(i,largest);
            maxHeap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t; 
        }
    
    public static void sort(int[] a0){
        array=a0;
        buildHeap(array);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxHeap(array, 0);
        }
    }
}
