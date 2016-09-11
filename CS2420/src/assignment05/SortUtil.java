package assignment05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/** Brandon Mouser and David Ord
 * This program takes in an Array List and a Comparator to sort the Array List using either Merge Sort or Quick Sort.
 * This program was tested to run with max efficiency by choosing a pivot that allows Quicksort to run with max efficiency,
 * and by choosing an Insertion Threshold that allows MergeSort to run with max efficiency.
 * Once the unsorted part of the Array List is small enough, the Array List is passed form either Quicksort or Mergesort
 * to Insertion Sort to finish sorting the array. This switch allows runtime to be significantly smaller because Insertion Sort 
 * is fastest on small lists.
 * 
 * @author Brandon Mouser and David Ord
 *
 */
public class SortUtil {

	/**
	 * This function takes in an ArrayList and a Comparator for that ArrayList and sorts them using the
	 * Merge-Sort algorithm. This function passes the array to another mergesort function for the 
	 * actual sorting.
	 * 
	 * @param ArrayList<T> listToSort -- The array that is being sorted.
	 * @param Comparator<? super T> dataComparator -- The comparator that the ArrayList uses to compare objects.
	 */
	public static <T> void mergesort(ArrayList<T> listToSort, Comparator<? super T> dataComparator) {
		
		if (listToSort.size() == 0 || listToSort.size() == 1) {
			return;
		}
		
		ArrayList<T> tmpArrayList = new ArrayList<T>();
		mergeSort(listToSort, tmpArrayList, 0, listToSort.size() - 1, dataComparator);
	}
	
	/**
	 * This function is the other mergesort function that the first mergesort function passes to.
	 * This is a recursive method. The array is sorted by continuously calling this function until the array is sorted in
	 * two different arrays. Then the sorted array is passed to the merge function to put the entire sorted ArrayList together.
	 * During the recursion, if the right and left limits subtracted from each other are less than half the size of the array,
	 * the array is finished sorting by the insertionSort method.
	 * The insertion sort threshold is the size of the array divided by two because this is the fastest sorting 
	 * threshold that we could find with our tests.
	 * 
	 * @param ArrayList<T> listToSort-- The array that is being sorted.
	 * @param ArrayList<T> tempList-- The temporary list that the sorted array is being stored in.
	 * @param int left-- The left bound of the array.
	 * @param int right-- The right bound of the array.
	 * @param Comparator<? super T> dataComparator-- The comparator that is used to compare objects in the array.
	 */
	private static <T> void mergeSort(ArrayList<T> listToSort, ArrayList<T> tempList, int left, int right,
			Comparator<? super T> dataComparator) {
		
		if (right - left <= listToSort.size()/2) {
			insertionSort(listToSort, dataComparator, left, right);
			return;
		}
		
		if (left < right){
		 	int center = (left + right) / 2;
			mergeSort(listToSort, tempList, left, center, dataComparator);
			mergeSort(listToSort, tempList, center + 1, right, dataComparator);
			merge(listToSort, tempList, left, center + 1, right, dataComparator);
		}
	}
	
	/**
	 * This function is the merge function that puts the sorted array from the temp array into the 
	 * original array. Once the mergesort function is complete, this merge function runs to put the
	 * finished sorted array list into its proper place in the original array list.
	 * 
	 * @param ArrayList<T> listToSort-- The list that is now sorted, and elements are being put into the correct place.
	 * @param ArrayList<T> tempList-- The Array List that has the finished sorted array in it.
	 * @param int leftInd-- The very left bound of the array. (Start of the first half of the Array List)
	 * @param int rightPos-- The right position of the middle. (The start of the second half of the Array List)
	 * @param int rightEnd-- The very right position of the array. (The end of the second half of the Array List)
	 * @param Comparator<? super T> dataComparator -- The comparator used to compare objects in the Array List.
	 */
	private static <T> void merge(ArrayList<T> listToSort, ArrayList<T> tempList, int leftInd, int rightPos, int rightEnd,
			Comparator<? super T> dataComparator) {

		int leftEnd = rightPos - 1;
		int tempInd = leftInd;
		int numElements = rightEnd - leftInd + 1;

		while (leftInd <= leftEnd && rightPos <= rightEnd) {
			if (dataComparator.compare(listToSort.get(leftInd), listToSort.get(rightPos)) <= 0) {
				tempList.add(tempInd, listToSort.get(leftInd));
				tempInd++;
				leftInd++;
			} 
			else {
				tempList.add(tempInd, listToSort.get(rightPos));
				tempInd++;
				rightPos++;
			}
		}

		while (leftInd <= leftEnd) {
			tempList.add(tempInd, listToSort.get(leftInd));
			tempInd++;
			leftInd++;
		}

		while (rightPos <= rightEnd) {
			tempList.add(tempInd, listToSort.get(rightPos));
			tempInd++;
			rightPos++;
		}

		for (int i = 0; i < numElements; i++, rightEnd--) {
			listToSort.set(rightEnd, tempList.get(rightEnd));
		}

	}
	
	/**
	 * This function is the Insertion Sort method that is used when the right and left bounds of the Array List
	 * subtracted from each other are less than or equal to half the size of the Array List.
	 * 
	 * @param ArrayList<T> listToSort-- The unsorted Array List that is being sorted.
	 * @param Comparator<? super T> dataComparator-- The Comparator that is being used to compare the objects in the Array List.
	 * @param int leftEnd -- The left Bound where the Insertion Sort begins sorting.
	 * @param int rightEnd -- The end of the Array List where the Insertion Sort stops sorting.
	 */
	public static <T> void insertionSort(ArrayList<T> listToSort, Comparator<? super T> dataComparator, 
			int leftEnd, int rightEnd) {
		
		for (int i = leftEnd; i <= rightEnd; i++) {
			T current = listToSort.get(i);
			for (int j = i - 1; j >= 0; j--) {
				if (dataComparator.compare(current, listToSort.get(j)) <= 0) {
					listToSort.set(j + 1,  listToSort.get(j));
					listToSort.set(j, current);
				} 
				else {
					break;
				}
			}
		}
	}
	
	/**
	 * This function takes in an Array List and a Comparator to sort the Array List using the Quick Sort Algorithm.
	 * This function just passes on the Array List to the actual quickSort function that does the sorting.
	 * 
	 * @param ArrayList<T> listToSort-- The Array List that is being sorted.
	 * @param Comparator<? super T> dataComparator-- The comparator that compares the objects in the Array List.
	 */
	public static <T> void quicksort(ArrayList<T> listToSort, Comparator<? super T> dataComparator) {
		quickSort(listToSort, dataComparator, 0, listToSort.size() - 1);
	}
	
	/**
	 * This function uses the Quicksort algorithm to sort the Array List. This quickSort function uses recursion to keep 
	 * calling on itself until the start and end are the same, then the Array List is sorted.
	 * During the recursion, if the end and start limits subtracted from each other are less than half the size of the array,
	 * the array is finished sorting by the insertionSort method.
	 * The pivot that is used to sort the array is taken from the end-1 place in the Array List.
	 * 
	 * @param ArrayList<T> listToSort -- The Array List that is being sorted.
	 * @param Comparator<? super T> dataComparator -- The Comparator that is used to compare the objects in the Array List.
	 * @param int start -- The start position where the unsorted Array List starts.
	 * @param int end -- The end position where the unsorted Array List ends.
	 */
	private static <T> void quickSort(ArrayList<T> listToSort, Comparator<? super T> dataComparator, int start, int end) {
		if(end - start <= listToSort.size()/2) {
			insertionSort(listToSort, dataComparator, start, end);
		}
		else {
			int midPoint = (start + end) / 2;
			if (dataComparator.compare(listToSort.get(midPoint), listToSort.get(start)) < 0) {
				swapReferences(listToSort, start, midPoint);
			}
			if (dataComparator.compare(listToSort.get(end), listToSort.get(start)) < 0) {
				swapReferences(listToSort, start, end);
			}
			if (dataComparator.compare(listToSort.get(end), listToSort.get(midPoint)) < 0) {
				swapReferences(listToSort, midPoint, end);
			}
			
			swapReferences(listToSort, midPoint, end - 1);
			T pivot = listToSort.get(end-1);
			
			int i, j;
			for (i = start, j = end -1; ; ) {
				while (dataComparator.compare(listToSort.get( ++i), pivot) < 0)
					;
				while (dataComparator.compare(pivot, listToSort.get( --j)) < 0) 
					;
				if (i >= j) {
					break;
				}
				swapReferences(listToSort, i, j);
			}
			
			swapReferences(listToSort, i, end - 1);
			quickSort(listToSort, dataComparator, start, i - 1);
			quickSort(listToSort, dataComparator, i + 1, end);	
		}
	}
	
	/**
	 * This function is just a swap function that swaps the two elements at the positions passed in.
	 * 
	 * @param ArrayList<T> listToSort -- The Array List that is being sorted.
	 * @param start -- The place where the item is being swapped.
	 * @param end -- The other place where the item is being swapped.
	 */
	private static <T> void swapReferences(ArrayList<T> listToSort, int start, int end) {
		T temp = listToSort.get(start);
		listToSort.set(start, listToSort.get(end));
		listToSort.set(end, temp);
	}

	/**
	 * This function just creates and returns an Array List in sorted order of the given size to use for Best Case testing.
	 * 
	 * @param int size-- The size of the Array List that is being created.
	 * @return ArrayList<Integer> -- The Array List from 1 - size in sorted order.
	 */
	public static ArrayList<Integer> generateBestCase(int size) {
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++) {
			sortedList.add(i);
		}
		return sortedList;
	}
	
	/**
	 * This function creates an Array List from 1 - size in random order to be used for testing.
	 * 
	 * @param int size -- The size of the Array List that is being created.
	 * @return ArrayList<Integer> -- The Array List from 1 - size in random order.
	 */
	public static ArrayList<Integer> generateAverageCase(int size) {
		
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++) {
			randomList.add(i);
		}
		Collections.shuffle(randomList);
		return randomList;
	}
	
	/**
	 * This function creates an Array List in descending order from size - 1.
	 * 
	 * @param int size -- The size of the Array List that is being created.
	 * @return ArrayList<Integer> -- An Array List in descending order from size to 1.
	 */
	public static ArrayList<Integer> generateWorstCase(int size) {
		ArrayList<Integer> backwardSort = new ArrayList<Integer>();
		for (int i = size; i >= 1; i--) {
			backwardSort.add(i);
		}
		return backwardSort;
	}

	/**
	 * This function is used for testing. It checks to see if an Array List is actually sorted.
	 * @param ArrayList<Integer> list-- The Array List that we are checking if it is sorted or not.
	 * @return boolean - True if the Array List is sorted, false otherwise.
	 */
	public static <T> boolean isSorted(ArrayList<T> list, Comparator<? super T> dataComparator){
		for (int i = 0; i < list.size() - 1; i++) {
			if (dataComparator.compare(list.get(i), list.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method was used when testing the pivot in the quicksort function. The function sorts the array and gets the median
	 * object in the Array List to be used as the pivot in the quicksort function.
	 * 
	 * @param ArrayList<Integer> list -- The Array List that we are getting the median element from.
	 * @param Comparator<? super T> dataComparator -- The Comparator that is used to compare the objects in the Array List.
	 * 
	 * @return T - The object at the Median of the Array List.
	 */
	private static <T> T getMedian(ArrayList<T> list, Comparator<? super T> dataComparator) {
		ArrayList<T> temp = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i));
		}
		temp.sort(dataComparator);
		return temp.get(temp.size() / 2);
		
	}
	/**
	 * This is a default comparator that can be used to sort objects in this class.
	 * 
	 * @return Comparator<T>() -- A Comparator that tells functions how to compare objects in these Array Lists.
	 */
	public static <T> Comparator<? super T> myComparator() {
		return new Comparator<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public int compare(T lhs, T rhs) {
				if (((Comparable<T>) lhs).compareTo(rhs) == 0) {
					return 0;
				}
				if (((Comparable<T>) lhs).compareTo(rhs) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		};
	}
}
