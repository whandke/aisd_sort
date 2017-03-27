import java.text.DecimalFormat;

public class Timer {
	public static long set(){
		return System.nanoTime();
	}
	
	public static double timeElapsed(long start, long end){
		return (end - start)/1000000000d;
	}
	
	public static void printTime(double time){
		DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(4);
        System.out.print(df.format(time));
	}

}