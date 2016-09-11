package assignment05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class QuickSortTimingBest {

	private static final int ITERATION_COUNT = 500;
	
	
	public static void main(String[] args) {
		Comparator<Integer> dataComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		long startTime = System.nanoTime();
		while(System.nanoTime() - startTime < 1000000000);
		
		try (FileWriter fileOut = new FileWriter("quickSortExperimentBestCase.tsv")) {
			for (int exp = 8; exp <= 20; exp++) {
				int sizeSet = (int) Math.pow(2, exp);
				
				
				long totalTimeRun = 0;
				for (int iter = 0; iter <= ITERATION_COUNT; iter++) {
					 
					ArrayList<Integer> bestCase = SortUtil.generateBestCase(sizeSet);
					
					long startRun = System.nanoTime();
					SortUtil.quicksort(bestCase, dataComparator);
					long stopRun = System.nanoTime();
					totalTimeRun += stopRun - startRun;
					
				}
				// Prints time in microseconds
				double averageTime = totalTimeRun / (double) ITERATION_COUNT;
				System.out.println("SetSize: " + sizeSet + " AverageTimeRun: " + averageTime / 1000);
				fileOut.write(sizeSet + "\t" + averageTime / 1000 + "\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
