package assignment04;

/**
 * Brandon Mouser
 * 
 * This is the code I used to generate the numbers for the graphs. I tested three different functions in this program.
 * The numbers generated from these functions are the runtime of the function as the size of whatever the function is doing
 * grows.
 */

import java.util.Random;

public class AnagramTestTime {
	private static Random rand;
	private static final int ITER_COUNT = 18;
	public static void main(String[] args) {
		rand = new Random(); 
		rand.setSeed(System.currentTimeMillis());
		double[] runTime = new double[ITER_COUNT];
		
		System.out.println("AreAnagrams Function:");
		for(int i = 10; i< ITER_COUNT; i++){
			double exp = i;
			int N = (int) Math.pow(2, exp);
			runTime[i-10] = testAreAnagrams(N);
			System.out.println(N + "     " + runTime[i-10]);
			if(i == ITER_COUNT - 1){
				System.out.println();
			}
		}
		System.out.println("Get Largest Function:");
		System.out.println();
		for(int i = 10; i< ITER_COUNT; i++){
			double exp = i;
			int N = (int) Math.pow(2, exp);
			runTime[i-10] = testGetLargestTime(N,10);
			System.out.println(N + "     " + runTime[i-10]);
			if(i == ITER_COUNT - 1){
				System.out.println();
			}
		}
		System.out.println("Get Largest Using JAVA SORT Function:");
		System.out.println();
		for(int i = 10; i< ITER_COUNT; i++){
			double exp = i;
			int N = (int) Math.pow(2, exp);
			runTime[i-10] = testGetLargestJavaTime(N,10);
			System.out.println(N + "     " + runTime[i-10]);
			if(i == ITER_COUNT - 1){
				System.out.println();
			}
		}
		
		
	}
	
	public static String randomString(int length) {
		String retval = ""; 
		for(int i = 0; i < length; i++) {
			retval += (char)('a' + (rand.nextInt(26)));
		} 
		return retval;
		}
	

	public static double testAreAnagrams(int count){
		String wordOne = randomString(count);
		String wordTwo = randomString(count);
		long startTime = System.currentTimeMillis();
		AnagramUtil.areAnagrams(wordOne, wordTwo);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		double time = totalTime/1000.0;
		return time;
		
	}
	public static double testGetLargestTime( int N, int wordLength){
		String[] words = new String[N];
		for(int i = 0; i < N; i++){
			String word = randomString(wordLength);
			words[i] = word;
		}
		long startTime = System.currentTimeMillis();
		AnagramUtil.getLargestAnagramGroup(words);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		double time = totalTime/1000.0;
		return time;
	}
	public static double testGetLargestJavaTime( int N, int wordLength){
		String[] words = new String[N];
		for(int i = 0; i < N; i++){
			String word = randomString(wordLength);
			words[i] = word;
		}
		long startTime = System.currentTimeMillis();
		AnagramUtil.getLargestAnagramGroupJavaSort(words);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		double time = totalTime/1000.0;
		return time;
	}
}
