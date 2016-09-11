package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import assign10.StringArrayList;

public class AnagramUtil {

	public static String sort(String unsorted) {
		char index = ' ';
		int j = 0;
		char[] charArray = new char[unsorted.length()];
		charArray = unsorted.toLowerCase().toCharArray();
		for (int i = 1; i < charArray.length; i++) {
			index = charArray[i];
			j = i;
			while (j > 0 && charArray[j - 1] > index) {
				charArray[j] = charArray[j - 1];
				j--;
			}
			charArray[j] = index;
		}
		String sorted = "";
		for (int i = 0; i < charArray.length; i++) {
			sorted += charArray[i];
		}
		return sorted;
	}

	public static <T> void insertionSort(T[] unsortedArray, Comparator<? super T> comparator) {
		T index = null;
		int j = 0;
			for (int i = 1; i < unsortedArray.length; i++) {
				index = unsortedArray[i];
				j = i;
				while (j > 0 && comparator.compare(index, unsortedArray[j - 1]) > 0) {
					unsortedArray[j] = unsortedArray[j - 1];
					j--;
				}
				unsortedArray[j] = index;
			}
		}

	public static boolean areAnagrams(String firstWord, String secondWord) {
		String firstSorted = sort(firstWord);
		String secondSorted = sort(secondWord);
		if (firstSorted.equals(secondSorted)) {
			return true;
		}
		return false;
	}

	public static String[] getLargestAnagramGroup(String[] words) {
		String[] temp = new String[words.length];
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			temp[i] = sort(words[i].toLowerCase());
		}
		insertionSort(temp, myComparator());
		ArrayList<Integer> position = new ArrayList<Integer>();
		for (int i = 0; i < temp.length - 1; i++) {
			int count = 0;
			for (int h = i + 1; h < temp.length; h++) {
				if (temp[i].compareTo(temp[h]) == 0) {
					count++;
				}
			}
			if (count > index) {
				index = count;
			}
			position.add(count);
		}
		String compareWord = "";
		for (int i = 0; i < position.size(); i++) {
			if (position.get(i) == index) {
				compareWord = temp[i];
			}
		}
		String[] isAnagram = new String[index + 1];
		int count = 0;
		for (int h = 0; h < words.length; h++) {
			if (compareWord.compareTo(sort(words[h])) == 0) {
				isAnagram[count] = words[h];
				count++;
			}
		}
		if(isAnagram.length == 1){
			String[] noAnagram = {};
			return noAnagram;
		}
		return isAnagram;
	}

	public static String[] getLargestAnagramGroup(String filename) {
		File bookFile = new File(filename);
		Scanner s = null;
		String[] emptyString = new String[0];

		try {
			s = new Scanner(bookFile);
		} catch (FileNotFoundException e) {
			return emptyString;
		}

		ArrayList<String> fileWords = new ArrayList<String>();
		while (s.hasNext()) {
			fileWords.add(s.next());
		}
		s.close();
		String[] temp = new String[fileWords.size()];
		for (int i = 0; i < fileWords.size(); i++) {
			temp[i] = fileWords.get(i);
		}
		String[] largestAnagram = getLargestAnagramGroup(temp);
		return largestAnagram;
	}

	/**
	 * This is the comparator used for sorting the array that is passed into the
	 * insertionSort method. This comparator can also be used in the test class
	 * to sort an array.
	 * 
	 * @return
	 */
	public static <T> Comparator<? super T> myComparator() {
		return new Comparator<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public int compare(T lhs, T rhs) {
				if (((Comparable<T>) lhs).compareTo(lhs) == 0) {
					return 0;
				}
				if (((Comparable<T>) rhs).compareTo(lhs) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		};
	}

	/**
	 * This function turns the array into a string for easy viewing.
	 * 
	 * @return String -- The set as a string.
	 */
	public static String toString(String[] arrayList) {
		String toString = "";
		for (int i = 0; i < arrayList.length; i++) {
			if (i < arrayList.length - 1) {
				toString += (arrayList[i] + ", ");
			}
			if (i == arrayList.length - 1) {
				toString += (arrayList[arrayList.length - 1]);
			}
		}
		toString = "[" + toString + "]";
		return toString;
	}
	
	
	
	
	public static String[] getLargestAnagramGroupJavaSort(String[] words) {
		String[] temp = new String[words.length];
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			temp[i] = sort(words[i].toLowerCase());
		}
		Arrays.sort(temp);
		ArrayList<Integer> position = new ArrayList<Integer>();
		for (int i = 0; i < temp.length - 1; i++) {
			int count = 0;
			for (int h = i + 1; h < temp.length; h++) {
				if (temp[i].compareTo(temp[h]) == 0) {
					count++;
				}
			}
			if (count > index) {
				index = count;
			}
			position.add(count);
		}
		String compareWord = "";
		for (int i = 0; i < position.size(); i++) {
			if (position.get(i) == index) {
				compareWord = temp[i];
			}
		}
		String[] isAnagram = new String[index + 1];
		int count = 0;
		for (int h = 0; h < words.length; h++) {
			if (compareWord.compareTo(sort(words[h])) == 0) {
				isAnagram[count] = words[h];
				count++;
			}
		}
		if(isAnagram.length == 1){
			String[] noAnagram = {};
			return noAnagram;
		}
		return isAnagram;
	}
}

