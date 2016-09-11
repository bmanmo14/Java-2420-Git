package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class SortUtilTester {

	ArrayList<Integer> referenceList = new ArrayList<Integer>();
	ArrayList<Integer> listToSort = new ArrayList<Integer>();
	ArrayList<Integer> randomLarge;
	ArrayList<Integer> randomSmall;
	
	@Before
	public void setupTestLists() {
		for (int i = 5; i > 0; i--) {
			listToSort.add(i);
		}
		for (int i = 1; i <=5; i++) {
			referenceList.add(i);
		}
		randomLarge = SortUtil.generateAverageCase(50);
		randomSmall = SortUtil.generateAverageCase(10);
	}
	
	@Test
	public void mergeSortMethodYieldsASortedList() {
		SortUtil.mergesort(listToSort, dataComparator);
		assertArrayEquals(referenceList.toArray(new Integer[referenceList.size()]), listToSort.toArray(new Integer[listToSort.size()]));
		SortUtil.mergesort(randomLarge, dataComparator);
		assertTrue(SortUtil.isSorted(randomLarge, dataComparator));
	}
	
	@Test
	public void quickSortMethodYieldsASortedList() {
		SortUtil.quicksort(randomSmall, dataComparator);
		
		assertTrue(SortUtil.isSorted(randomSmall, dataComparator));
	}
	
	Comparator<Integer> dataComparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
}
