package assignment05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class MergeSortTimingWorst {

	private static final int ITERATION_COUNT = 8;
	private static final ArrayList<Integer> avg1 = SortUtil.generateAverageCase(1024);
	private static final ArrayList<Integer> avg2 = SortUtil.generateAverageCase(2048);
	private static final ArrayList<Integer> avg3 = SortUtil.generateAverageCase(4096);
	private static final ArrayList<Integer> avg4 = SortUtil.generateAverageCase(8192);
	private static final ArrayList<Integer> avg5 = SortUtil.generateAverageCase(16384);
	private static final ArrayList<Integer> avg6 = SortUtil.generateAverageCase(32768);
	public static void main(String[] args) {

		Comparator<Integer> dataComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		long startTime = System.nanoTime();
		while(System.nanoTime() - startTime < 1000000000);
		
		try (FileWriter fileOut = new FileWriter("mergeSortAverage.txt")) {
					long startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg1, dataComparator);
					long stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg2, dataComparator);
					stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg3, dataComparator);
					stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg4, dataComparator);
					stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg5, dataComparator);
					stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					startRun = System.currentTimeMillis();
					SortUtil.mergesort(avg6, dataComparator);
					stopRun = System.currentTimeMillis();
					fileOut.write(stopRun - startRun + "\n");
					
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
