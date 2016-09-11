package assignment03;

import java.util.Random;

public class TestTime {

	private static final int ITER_COUNT = 1000;
	
	public static void main(String[] args) {  
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000){
		for(int exp = 10; exp <= 20; exp++) {
			int size = (int) Math.pow(2, exp);
			long totalTime = 0; for (int iter = 0; iter < ITER_COUNT; iter++) {
				BinarySearchSet<Integer> set = new BinarySearchSet<Integer>(); 
				for(int i = 0; i < size; i++) {
					set.add(i);
				} 
				int findElement = new Random().nextInt(size);
				long start = System.nanoTime(); 
				set.add(findElement); 
				long stop = System.nanoTime(); 
				totalTime += stop - start;
				set.remove(findElement);
			}
			double averageTime = totalTime / (double)ITER_COUNT; 
			System.out.println(size + "\t" + averageTime);
		}
		}
	}
}
