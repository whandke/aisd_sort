import java.util.Random;

public class ArrayGenerator {
	
	public static void random(int[] array, int maximum, float range){			
		for( int j = 0; j < maximum; j++){
			Random rn = new Random();
			float n = range * maximum;
			int a = rn.nextInt((int)n) + 1;
			array[j] = + a;
		}
	}

	public static void rising(int[] array, int maximum){
		for(int i = 0; i < maximum; i++)
			array[i] = i + 1;
	}
	
	public static void vShape(int[] array, int maximum){
		int lenght = maximum /2;
		for(int i = 0; i < lenght; i++)
			array[i] = lenght - i;
		for(int i = 0; i < lenght; i++)
			array[i + lenght] = i + 1;
	}
	
	public static void aShape(int[] array, int maximum){
		int lenght = maximum /2;
		for(int i = 0; i < lenght; i++)
			array[i + lenght] = lenght - i;
		for(int i = 0; i < lenght; i++)
			array[i] = i + 1;
	}

}
