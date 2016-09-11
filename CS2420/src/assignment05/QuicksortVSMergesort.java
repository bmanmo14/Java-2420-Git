package assignment05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class QuicksortVSMergesort {
	private static final int ITERATION_COUNT = 8;
	public static void main(String[] args) {
		Comparator<Integer> dataComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		try (FileWriter fileOut = new FileWriter("QuickSortAverageCase.txt")) {
			for (int exp = 10; exp <= 16; exp++) {
				int sizeSet = (int) Math.pow(2, exp);
				ArrayList<Integer> averageCase = SortUtil.generateAverageCase(sizeSet);
				ArrayList<Integer> tempArray = new ArrayList<Integer>(sizeSet);
				for(int i = 0; i < sizeSet; i++){
					tempArray.add(averageCase.get(i));
				}
				long totalTimeRun = 0;
				for (int iter = 1; iter <= ITERATION_COUNT; iter++) {
					 
					ArrayList<Integer> worstCase = SortUtil.generateAverageCase(sizeSet);
					long startRun = System.currentTimeMillis();
					SortUtil.quicksort(worstCase, dataComparator);
					long stopRun = System.currentTimeMillis();
					tempArray.clear();
					for(int i = 0; i < sizeSet; i++){
						tempArray.add(averageCase.get(i));
					}
					totalTimeRun += stopRun - startRun;
					
				}
				// Prints time in microseconds
				double averageTime = totalTimeRun / (double) ITERATION_COUNT;
				System.out.println("SetSize: " + sizeSet + " AverageTimeRun: " + averageTime);
				fileOut.write(averageTime + "\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
