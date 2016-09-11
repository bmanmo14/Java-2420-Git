package assignment11;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class PriorityQueueTiming {
	public static int ITERCOUNT = 1000000;

	public static void main(String[] args){
		Random rand = new Random();
	try (FileWriter priorityQueue = new FileWriter("PriorityQueueTime.txt")) {
	for(int index1 = 10; index1 <= 25; index1++){
		PriorityQueue<Integer> tester = new PriorityQueue<Integer>();
		int N = (int)Math.pow(2, index1);
		for(int index2 = 0; index2 < N; index2++){
			tester.add(index2);
		}
		// ------------ FINDMIN()
		long findMinRunTime = 0;
		for(int index3 = 0; index3 < ITERCOUNT; index3++){
			long startTime = System.nanoTime();
			tester.findMin();
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			findMinRunTime = findMinRunTime + runTime;
		}
		findMinRunTime = findMinRunTime / ITERCOUNT;
		// ------------- ADD() & DELETEMIN()
		long addRunTime = 0;
		long deleteMinRunTime = 0;
		
		for(int index4 = 0; index4 < ITERCOUNT; index4++){
			int randNum = rand.nextInt(100000);
			long startTime = System.nanoTime();
			tester.add(randNum);
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			addRunTime = addRunTime + runTime;
			long startTime2 = System.nanoTime();
			tester.deleteMin();
			long endTime2 = System.nanoTime();
			long runTime2 = endTime2 - startTime2;
			deleteMinRunTime = deleteMinRunTime + runTime2;
		}
		addRunTime = addRunTime / ITERCOUNT;
		deleteMinRunTime = deleteMinRunTime / ITERCOUNT;
		priorityQueue.write(deleteMinRunTime + "\n");
	}
	} catch (IOException d) {
		d.printStackTrace();
	}
	}
}
