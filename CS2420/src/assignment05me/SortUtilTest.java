package assignment05me;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import assignment04.AnagramUtil;

public class SortUtilTest {

	@Test
	public void testQuicksort() {
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		testArray.add(10);
		testArray.add(1);
		testArray.add(0);
		testArray.add(9);
		testArray.add(7);
		testArray.add(8);
		testArray.add(18);
		testArray.add(5);
		testArray.add(6);
		testArray.add(-3);
		testArray.add(18);
		testArray.add(15);
		
		ArrayList<Integer> worstCase = SortUtil.generateWorstCase(10);
		
		long startTime = System.currentTimeMillis();
		SortUtil.mergesort(worstCase, SortUtil.myComparator());
		long stopTime = System.currentTimeMillis();
		System.out.println(worstCase.toString());
	}

}
