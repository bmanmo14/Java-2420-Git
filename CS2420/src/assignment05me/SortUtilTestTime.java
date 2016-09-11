package assignment05me;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SortUtilTestTime {
	
	private static Random rand;
	private static final int ITER_COUNT = 16;
	
	public static void main(String[] args) {
		try {
			FileWriter write = new FileWriter(new File("mergesort70.txt"));
		
		
		rand = new Random(); 
		rand.setSeed(System.currentTimeMillis());
		double[] runTime = new double[ITER_COUNT];
		
		write.write("BestCase Function:" + "\n");
		for(int i = 10; i< ITER_COUNT; i++){
			double exp = i;
			int N = (int) Math.pow(2, exp);
			runTime[i-10] = bestCase(N);
			write.write(N + "\t" + runTime[i-10] + "\n");
			if(i == ITER_COUNT - 1){
				System.out.println();
			}
		}
		write.write("WorstCase Function:" + "\n");
		for(int i = 10; i< ITER_COUNT; i++){
			double exp = i;
			int N = (int) Math.pow(2, exp);
			runTime[i-10] = worstCase(N);
			write.write(N + "\t" + runTime[i-10] + "\n");
			if(i == ITER_COUNT - 1){
				System.out.println();
			}
		}
		write.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
		
		public static double bestCase(int count){
			ArrayList<Integer> testTime = SortUtil.generateBestCase(count);
			long startTime = System.currentTimeMillis();
			SortUtil.mergesort(testTime, SortUtil.myComparator());
			long endTime = System.currentTimeMillis();
			long totalTime = (endTime - startTime);
			return totalTime;
		}
		public static double worstCase(int count){
			ArrayList<Integer> testTime = SortUtil.generateWorstCase(count);
			long startTime = System.currentTimeMillis();
			SortUtil.mergesort(testTime, SortUtil.myComparator());
			long endTime = System.currentTimeMillis();
			long totalTime = (endTime - startTime);
			return totalTime;
		}
}
