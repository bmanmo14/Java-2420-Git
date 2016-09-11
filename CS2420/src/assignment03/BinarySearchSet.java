package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates a BinarySearchSet of type E. Has various functions to
 * operate on a list of type E (a generic type). Additionally, objects in the
 * list can be sorted by their natural order of by a user defined comparator.
 * 
 * @author Brandon Mouser & Kale Thompson
 * 
 * @param <E>
 */

public class BinarySearchSet<E> implements SortedSet<E>, Iterable<E> {

	private E[] array;
	private int count;
	private Comparator<? super E> comp;

	/**
	 * Constructor for a generic list that will be sorted by natural order. Has
	 * an array to hold the objects that can grow dynamically, an integer to
	 * keep track of the number of elements. The comparator is set to null
	 * because the elements will be sorted with natural ordering.
	 */
	@SuppressWarnings("unchecked")
	public BinarySearchSet() {
		this.array = (E[]) new Object[10];
		count = 0;
		comp = null;
	}

	/**
	 * Constructor for a generic list that will be sorted with respect to the
	 * passed in comparator. Aspects of the basic constructor however, the
	 * comparator is set to the passed in parameter.
	 * 
	 * @param comparator
	 *            (Refers to how the list should be sorted).
	 */
	@SuppressWarnings("unchecked")
	public BinarySearchSet(Comparator<? super E> comparator) {
		this.comp = comparator;
		this.array = (E[]) new Object[10];
		count = 0;
	}

	@Override
	public Comparator<? super E> comparator() {
		return comp;
	}

	@Override
	public E first() throws NoSuchElementException {
		E first = array[0];
		return first;
	}

	@Override
	public E last() throws NoSuchElementException {
		E last = array[count - 1];
		return last;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean add(E element) {

		int low = 0;
		if (count == array.length) {
			E[] newArray = (E[]) new Object[array.length * 2];
			for (int j = 0; j < array.length; j++) {
				newArray[j] = array[j];
			}
			array = newArray;
		}

		if (count != 0) {
			if (this.contains(element)) {
				return false;
			}
			low = binarySearch(element);
			for (int i = count; i > low; i--) {
				array[i] = array[i - 1];
			}
			array[low] = element;
			count++;
			return true;
		}
		if (count == 0) {
			array[0] = element;
			count++;
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		int checkCount = 0;
		Iterator<E> itr = (Iterator<E>) elements.iterator();
		while (itr.hasNext()) {
			add(itr.next());
			checkCount++;
		}
		if (checkCount == elements.size()) {
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		E[] newArray = (E[]) new Object[10];
		array = newArray;
		count = 0;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object element) {
		if (count == 0) {
			return false;
		}
		int location = binarySearch((E) element);
		if (location == count) {
			if (myCompare(array[location - 1], (E) element) == 0) {
				return true;
			}
			return false;
		}

		if (location < count) {
			if (myCompare(array[location], (E) element) == 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> elements) {
		@SuppressWarnings("unchecked")
		Iterator<E> itr = (Iterator<E>) elements.iterator();
		int checkCount = 0;
		while (itr.hasNext()) {
			if (contains(itr.next())) {
				checkCount++;
			}
		}
		if (checkCount == elements.size()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;
			private boolean hasNextCalled = false;
			
			public boolean hasNext() {
				if (index < size()) {
					return true;
				}
				return false;
			}

			public void remove() {
				for (int i = index; i < size(); i++) {
					array[i - 1] = array[i];
				}
				index--;
			}

			public E next() {
				E next = array[index];
				index++;
				return next;

			}
		};
	}

	@Override
	public boolean remove(Object element) {
		@SuppressWarnings("unchecked")
		int remove_index = binarySearch((E) element);
		if (remove_index == count - 1) {
			array[count - 1] = null;
			count--;
		} else {
			for (int i = remove_index; i < size(); i++) {
				array[i] = array[i + 1];
			}
			count--;
		}
		if (contains(element) == false) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeAll(Collection<?> elements) {
		Iterator<E> itr = (Iterator<E>) elements.iterator();
		while (itr.hasNext()) {
			E nextElement = itr.next();
			if (contains(nextElement)) {
				remove(nextElement);
			}
		}
		if (!(containsAll(elements))) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[count];
		for (int i = 0; i <= count - 1; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	/**
	 * This function turns the set into a string for easy viewing.
	 * 
	 * @return String -- The set as a string.
	 */
	public String toString() {
		String toString = "";
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
				toString += (array[i] + ", ");
			}
			if (i == count - 1) {
				toString += (array[count - 1]);
			}
		}
		toString = "[" + toString + "]";
		return toString;
	}

	/**
	 * This method will search a list via a Binary Search. This means in looks
	 * at the middle element of the list and compares it to the passed in
	 * parameter. It continues to narrow the search based on the relationship of
	 * the middle element and the parameter. This method will either return the
	 * location of the element (if the list contains the element), or the
	 * location that it should be placed within the list.
	 * 
	 * @param element
	 *            (The element that you wish to know the location of if it
	 *            exists).
	 * @return The location of the element within the list, or the location of
	 *         where the element should be placed.
	 */
	public int binarySearch(E element) {
		int high = count - 1;
		int low = 0;

		while ((high >= low)) {
			int middle = low + (high - low) / 2;
			if (myCompare(array[middle], element) == 0) {
				return middle;
			} else if ((myCompare(array[middle], element) < 0)) {
				low = middle + 1;
			} else if ((myCompare(array[middle], element) > 0)) {
				high = middle - 1;
			}

		}
		return low;
	}

	/**
	 * This function compares two elements to find which one is bigger.
	 * 
	 * @param leftObject -- The left hand side object that is being compared
	 * @param rightObject -- The right hand side object that is being compared.
	 * @return int -- if leftObject < rightObject, returns number < 0. 
	 * 				  if leftObject > rightObject, returns number > 0. 
	 * 				  if leftObject == rightObject, returns number 0.
	 */
	@SuppressWarnings({ "unchecked" })
	private int myCompare(E leftObject, E rightObject) {
		// Uses compareTo because no comparator was specified.
		if (comp == null) {
			int result = ((Comparable<E>) leftObject).compareTo(rightObject);
			return result;
		} else {
			// Uses the compare method associated with the comparator passedinto the function.
			int resultComp = (comp.compare(leftObject, rightObject));
			return resultComp;
		}
	}
}
