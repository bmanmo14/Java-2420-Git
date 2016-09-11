package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import assignment04.AnagramUtil;
/** Brandon Mouser and David Ord
 * This JUnit test file tests the functions made in the SortUtil class.
 * The tests in this file test:
 * quicksort()
 * mergesort()
 * insertionSort()
 * isSorted()
 * generateBestCase()
 * generateWorstCase()
 * generateAverageCase()
 * myComparator()
 * 
 * If any of these functions fail, the program will print an error message.
 * 
 * @author Brandon Mouser and David Ord
 *
 */
public class SortUtilTest {
	/**
	 * This Test tests the isSorted function to make sure isSorted returns true when the Array List is sorted
	 * and false if it not.
	 */
	@Test
	public void testIsSorted(){
		// Create new test Arrays with different sizes and different orders.
		ArrayList<Integer> testArray = SortUtil.generateBestCase(50);
		ArrayList<Integer> testArray2 = SortUtil.generateBestCase(100);
		ArrayList<Integer> testArray3 = SortUtil.generateWorstCase(50);
		ArrayList<Integer> testArray4 = SortUtil.generateWorstCase(100);
		// The Best Case Array should already be sorted.
		if(!SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("isSorted() failed.");
		}
		if(!SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("isSorted() failed.");
		}
		// The Worst Case Array List should not be sorted. If isSorted says it is, isSorted failed.
		if(SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		if(SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		
	}
	/**
	 * This Test tests the mergesort() function. If mergesort is called on an Array List and the Array List is not sorted
	 * after mergesort runs, mergesort failed.
	 */
	@Test
	public void testMergeSort() {
		// Create new test Arrays with different sizes and different orders.
		ArrayList<Integer> testArray = SortUtil.generateAverageCase(50);
		ArrayList<Integer> testArray2 = SortUtil.generateAverageCase(100);
		ArrayList<Integer> testArray3 = SortUtil.generateBestCase(50);
		ArrayList<Integer> testArray4 = SortUtil.generateBestCase(100);
		ArrayList<Integer> testArray5 = SortUtil.generateWorstCase(50);
		ArrayList<Integer> testArray6 = SortUtil.generateWorstCase(100);
		// Make sure that the Random Array is not sorted.
		if(SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		if(SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		// Now make sure that isSorted and BestCase functions are working.
		if(!SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("generateBestCase() failed.");
		}
		if(!SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("generateBestCase() failed.");
		}
		// Now make sure the Worst Case function is working. The Array List should not be sorted.
		if(SortUtil.isSorted(testArray5, SortUtil.myComparator())){
			System.err.println("generateWorstCase() failed.");
		}
		if(SortUtil.isSorted(testArray6, SortUtil.myComparator())){
			System.err.println("generatWorstCase() failed.");
		}
		// Now sort each Array using MergeSort.
		SortUtil.mergesort(testArray, SortUtil.myComparator());
		SortUtil.mergesort(testArray2, SortUtil.myComparator());
		SortUtil.mergesort(testArray3, SortUtil.myComparator());
		SortUtil.mergesort(testArray4, SortUtil.myComparator());
		SortUtil.mergesort(testArray5, SortUtil.myComparator());
		SortUtil.mergesort(testArray6, SortUtil.myComparator());
		// Now if the Array List is not sorted, Merge Sort failed.
		if(!SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		if(!SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		if(!SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		if(!SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		if(!SortUtil.isSorted(testArray5, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		if(!SortUtil.isSorted(testArray6, SortUtil.myComparator())){
			System.err.println("mergesort() failed.");
		}
		System.out.println(testArray.toString());
	}
	/**
	 * This function tests the quicksort() function. If quicksort is called on an Array List and the Array List is not
	 * sorted after quicksort is called, quicksort failed.
	 */
	@Test
	public void testQuickSort() {
		// Create new test Arrays with different sizes and different orders.
		ArrayList<Integer> testArray = SortUtil.generateAverageCase(75);
		ArrayList<Integer> testArray2 = SortUtil.generateAverageCase(150);
		ArrayList<Integer> testArray3 = SortUtil.generateWorstCase(75);
		ArrayList<Integer> testArray4 = SortUtil.generateWorstCase(150);
		
		// Make sure the AverageCase() and WorstCase() functions are not sorted.
		if(SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		if(SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("generateAverageCase() failed.");
		}
		if(SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("generateWorstCase() failed.");
		}
		if(SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("generateWorstCase() failed.");
		}
		// Now sort the Array Lists Using quicksort.
		SortUtil.quicksort(testArray, SortUtil.myComparator());
		SortUtil.quicksort(testArray2, SortUtil.myComparator());
		SortUtil.quicksort(testArray3, SortUtil.myComparator());
		SortUtil.quicksort(testArray4, SortUtil.myComparator());
		// Make sure that these Arrays are sorted!
		if(!SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("quicksort() failed.");
		}
		if(!SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("quicksort() failed.");
		}
		if(!SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("quicksort() failed.");
		}
		if(!SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("quicksort() failed.");
		}
	}
	/**
	 * This function tests the Insertion Sort that is used when the Insertion Threshold is low enough.
	 * After the unsorted Array Lists are sorted using Insertion Sort, they should be sorted.
	 * If not, Insertion Sort failed.
	 */
	@Test
	public void testInsertionSort(){
		// Create new test Arrays with different sizes and different orders.
		ArrayList<Integer> testArray = SortUtil.generateAverageCase(100);
		ArrayList<Integer> testArray2 = SortUtil.generateAverageCase(200);
		ArrayList<Integer> testArray3 = SortUtil.generateWorstCase(100);
		ArrayList<Integer> testArray4 = SortUtil.generateWorstCase(200);
		// Now sort these Array Lists using Insertion Sort.
		SortUtil.insertionSort(testArray, SortUtil.myComparator(), 0, testArray.size()-1);
		SortUtil.insertionSort(testArray2, SortUtil.myComparator(), 0, testArray2.size()-1);
		SortUtil.insertionSort(testArray3, SortUtil.myComparator(), 0, testArray3.size()-1);
		SortUtil.insertionSort(testArray4, SortUtil.myComparator(), 0, testArray4.size()-1);
		// If these Array Lists are not sorted, Insertion Sort failed.
		if(!SortUtil.isSorted(testArray, SortUtil.myComparator())){
			System.err.println("insertionSort() failed.");
		}
		if(!SortUtil.isSorted(testArray2, SortUtil.myComparator())){
			System.err.println("insertionSort() failed.");
		}
		if(!SortUtil.isSorted(testArray3, SortUtil.myComparator())){
			System.err.println("insertionSort() failed.");
		}
		if(!SortUtil.isSorted(testArray4, SortUtil.myComparator())){
			System.err.println("insertionSort() failed.");
		}
		
	}

}
