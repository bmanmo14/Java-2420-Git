package assignment05me;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtil {
	
	public static int insertionThreshold = 70;
	
	/**
	 * 
	 * @param unsorted
	 * @param comparator
	 */
	public static <T> void mergesort(ArrayList<T> unsorted, Comparator<? super T> comparator){
		ArrayList<T> tmpArrayList = new ArrayList<T>();
		mergeSort(unsorted, tmpArrayList, 0, unsorted.size()-1, comparator);
	}
	
	/**
	 * 
	 * @param unsorted
	 * @param tmpArray
	 * @param left
	 * @param right
	 * @param comparator
	 */
	private static <T> void mergeSort(ArrayList<T> unsorted, ArrayList<T> tmpArray, int left, int right, Comparator<? super T> comparator){
		
		if (right-left <= insertionThreshold) {
			insertionSort(unsorted, comparator, left, right);
		}
		if(left < right){
			int center = (left + right)/2;
			mergeSort(unsorted, tmpArray, left, center, comparator);
			mergeSort(unsorted, tmpArray, center +1, right, comparator);
			merge(unsorted, tmpArray, left, center+1, right, comparator);
		}
	}
	
	/**
	 * 
	 * @param unsorted
	 * @param tmpArray
	 * @param left
	 * @param right
	 * @param rightEnd
	 * @param comparator
	 */
	private static <T> void merge(ArrayList<T> unsorted, ArrayList<T> tmpArray, int left, int right, int rightEnd, Comparator<? super T> comparator){
		
		int leftEnd = right -1;
		int tmpPos = left;
		int numElements = rightEnd - left +1;
		while(left <= leftEnd && right <= rightEnd){
			if(comparator.compare(unsorted.get(left), unsorted.get(right)) <= 0){
				tmpArray.add(tmpPos++, unsorted.get(left++));
			}
			else {
				tmpArray.add(tmpPos++, unsorted.get(right++));
			}
		}
			while(left <= leftEnd){
				tmpArray.add(tmpPos++, unsorted.get(left++));
		}
			while(right <= rightEnd){
				tmpArray.add(tmpPos++, unsorted.get(right++));
			}
			for(int i = 0; i < numElements; i++, rightEnd--){
				unsorted.set(rightEnd, tmpArray.get(rightEnd));
			}
	}
	
	/**
	 * 
	 * @param toSort
	 * @param dataComparator
	 * @param left
	 * @param right
	 */
	private static <T> void insertionSort(ArrayList<T> toSort, Comparator<? super T> dataComparator, int left, int right) {
		T index = null;
		int j = 0;
		for (int i = left+1; i < right; i++) {
			index = toSort.get(i);
			j = i;
			while (j > 0 && dataComparator.compare(index, toSort.get(j - 1)) > 0) {
				toSort.set(j, toSort.get(j - 1));
				j--;
			}
			toSort.set(j, index);
		}
	}
	
	/**
	 * 
	 * @param listToSort
	 * @param dataComparator
	 */
	public static <T> void quicksort(ArrayList<T> listToSort, Comparator<? super T> dataComparator){
		quicksort(listToSort, 0, listToSort.size()-1, dataComparator);
	}
	
	private static <T> void quicksort(ArrayList<T> toSort, int low, int high, Comparator<? super T> dataComparator){
		if(low >= high){
			return;
		}
		
		else{
		int center = (low+high)/2;
		if(dataComparator.compare(toSort.get(low), toSort.get(center)) > 0){
			swap(toSort, low,center);
		}
		if(dataComparator.compare(toSort.get(low), toSort.get(high)) > 0){
			swap(toSort, low, high);
		}
		if(dataComparator.compare(toSort.get(center), toSort.get(high)) > 0){
			swap(toSort, center, high);
		}
		
		swap(toSort, center, high-1);
		T pivot = toSort.get(high-1);
		
		int lowEnd = low;
		int highEnd = high-1;
		while(lowEnd < highEnd){
			while(dataComparator.compare(toSort.get(++lowEnd), pivot) < 0);
				while(highEnd > 0 && dataComparator.compare(toSort.get(--highEnd), pivot) > 0);
					if(lowEnd >= highEnd){
						break;
					}
					else{
						swap(toSort, lowEnd, highEnd);
					}
		}		
		swap(toSort, lowEnd, high-1);
		quicksort(toSort, low, lowEnd-1, dataComparator);
		quicksort(toSort, lowEnd+1, high, dataComparator);
		}
	}
	
	public static <T> void swap(ArrayList<T> toSort, int low,int high){
		T temp = toSort.get(low);
		toSort.set(low, toSort.get(high));
		toSort.set(high, temp);
	}
	
	public static ArrayList<Integer> generateBestCase(int size){
		ArrayList<Integer> bestCase = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++){
			bestCase.add(i);
		}
		return bestCase;
	}
	
	public static ArrayList<Integer> generateAverageCase(int size){
		ArrayList<Integer> bestCase = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++){
			bestCase.add(i);
		}
		Collections.shuffle(bestCase);
		return bestCase;
	}
	
	public static ArrayList<Integer> generateWorstCase(int size){
		ArrayList<Integer> worstCase = new ArrayList<Integer>();
		for(int i = size; i >=1; i--){
			worstCase.add(i);
		}
		return worstCase;
	}
	
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
