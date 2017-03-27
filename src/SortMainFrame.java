import java.util.Scanner;

public class SortMainFrame {	
	
	@SuppressWarnings("unused")
	private static void printArray(int[] array){
		int n = array.length;
		System.out.print("\n");
		for(int i = 0; i < n; i++){
			System.out.print(String.valueOf(array[i]) + " ");
		}
		System.out.print("\n");
	}
	
	public static void sort(int max, int repeats, int step, boolean excel, boolean[] sortType, int arrayType, float range){
		
		int[] a1, a2, a3, a4, a5, a6, a7, a8;
		
		boolean recur = false;
		
		int maximum = max;
		
		String[] sortTypeNames = {
				"Select",
				"Insert",
				"Bubble",
				"Heap",
				"Merge",
				"Quick1",
				"Quick2",
				"Count"	};
		
		if(excel){
			POut.beginTableRow();
			System.out.print("Nr");
			
			for(int i = 0; i < 8; i++){
				if(sortType[i]){
					POut.separatorTableRow();
					System.out.print(sortTypeNames[i]);
				}
			}			
			POut.endTableRow();		
		}
		
		for(int i = 1; i <= repeats; i++){
			int[] array = new int[maximum];
			
			switch(arrayType){
				case 1:
					ArrayGenerator.random(array, maximum, range);
					break;
				case 2:
					ArrayGenerator.rising(array, maximum);
					break;
				case 3:
					ArrayGenerator.vShape(array, maximum);
					break;
				case 4:
					ArrayGenerator.aShape(array, maximum);
					break;
			}
			
			//printArray(array);
						
			a1 = array.clone();
			a2 = array.clone();
			a3 = array.clone();
			a4 = array.clone();
			a5 = array.clone();
			a6 = array.clone();
			a7 = array.clone();
			a8 = array.clone();
		
			if(excel)
				POut.beginTableRow();
			
			System.out.print(String.valueOf(i));
			
//### SELECTION SORT
			if(sortType[0]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.selectionSort(a1);
			}
//### INSERTION SORT
			if(sortType[1]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.insertionSort(a2);
			}
//### BUBBLE SORT
			if(sortType[2]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.bubbleSort(a3);	
			}
//### HEAP SORT
			if(sortType[3]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.heapSort(a4);	
			}
//### MERGE SORT
			if(sortType[4]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.mergeSort(a5);
			}
//### QUICK SORT 1
			if(sortType[5]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				try{
					Sort.quickSort(a6, false);
				} catch(StackOverflowError e){
					recur = true;
					System.out.print("Err");
				};
			}
//### QUICK SORT 2
			if(sortType[6]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				try{
					Sort.quickSort(a7, true);
				} catch(StackOverflowError e){
					recur = true;
					System.out.print("Err");
				};
			}
//### COUNTING SORT
			if(sortType[7]){
				if(excel)
					POut.separatorTableRow();
				else POut.space();
				Sort.countingSort(a8, maximum * range);
			}
			if(excel)
				POut.endTableRow();
			else POut.newLine();
			
			maximum += step;
		}
		
		if(recur)
			System.out.println("\nQuick sort hit maximum recursion depth, hence the error.");
	}
	
	public static void main(String[] args){
		
		int max, repeats, step = 0;
		float range = 1;
		boolean excel;
		boolean loop = false;
		Scanner scan = new Scanner(System.in);
		int arrayType = 0;
		boolean[] sortType = new boolean[8];
		String[] sortTypeNames = {
				"Selection Sort",
				"Insertion Sort",
				"Bubble Sort",
				"Heap Sort",
				"Merge Sort",
				"Quick Sort 1 (first elem pivot)",
				"Quick Sort 2 (half array pivot)",
				"Counting Sort"	};
		String input;
		
		System.out.println("Sorting Algorithms Analytics Program");
		System.out.println("created by Wojciech Handke and Filip Gapczynski\n");
		System.out.println("Please, resize your terminal to be as wide as possible, thank you.\n");
		
		do{
			System.out.println("Select algorithms to be used in next analysis:");
			
			System.out.print("\tAll (y/n): ");
			input = scan.next();
			
			if(input.equals("n")){
				for(int i = 0; i < 8; i++){
					System.out.print("\t" + sortTypeNames[i] + " (y/n): ");
					input = scan.next();
					if(input.equals("y"))
						sortType[i] = true;
					else sortType[i] = false;					
				}
			}
			else for (int i = 0; i < 8; i++)
				sortType[i] = true;
			
			boolean error1 = false;
			do{
				error1 = false;
				System.out.print("\nSelect type of array to be sorted (random/rising/v-shape/A-shape): ");
				input = scan.next();
				if(input.equals("random"))
					arrayType = 1;
				else if(input.equals("rising"))
					arrayType = 2;
				else if(input.equals("v-shape"))
					arrayType = 3;
				else if(input.equals("A-shape"))
					arrayType = 4;
				else error1 = true;
			}
			while(error1);
			
			System.out.print("Set size of first instance: ");
			max = scan.nextInt();
			
			System.out.print("Set number of instances: ");
			repeats = scan.nextInt();
			
			if(repeats != 1){
				System.out.print("Set step size: ");
				step = scan.nextInt();
			}
			
			if(arrayType == 1){
				System.out.print("Set X for elements in array (range of generated elments is [1, X * InstanceSize]; Use comma as decimal separator): ");
				range = scan.nextFloat();
			}
			
			System.out.print("Do you want your results to be ready for Excel? (y/n): ");
			input = scan.next();
			if(input.equals("n"))
				excel = true;
			else excel = false;
			
			System.out.println("Starting...\n");
			
			sort(max, repeats, step, excel, sortType, arrayType, range);
			
			System.out.println("\nFinished!");
			
			System.out.print("\n\nDo you wish to start again? (y/n): ");
			input = scan.next();
			if(input.equals("y"))
				loop = true;
			else loop = false;
			

		}
		while(loop);
		
		scan.close();
	}
}