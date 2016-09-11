package assignment10;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class is a factory to create Chaining Hash Table data structure.
 * Includes several methods to add items to the data structure as well as a
 * method to test if something is in the data structure. Includes functionality
 * for sets of items.
 * 
 * @author Kale Thompson & Brandon Mouser
 *
 */
public class ChainingHashTable implements Set<String> {

	// List of data members contained in a Hash Table
	private LinkedList<String>[] storage;
	private HashFunctor functor;
	public int numOccupied;
	public int capacity;
	public int collisions;

	
	/**
	 * This is a constructor for a Chaining Hash Table, initializes each of the
	 * data members above to their default values.
	 * 
	 * @param int capacity -- The size you wish to make the array in the Hash Table
	 * @param HashFunctor functor -- The functor which contains the desired hash function you
	 * wish to use.
	 */
	@SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor) {
		if (!isPrime(capacity)) {
			this.capacity = nextPrime(capacity);
		} else {
			this.capacity = capacity;
		}
		this.storage = (LinkedList<String>[]) new LinkedList[capacity];
		this.functor = functor;
		this.numOccupied = 0;
		this.collisions = 0;
	}

	@Override
	public boolean add(String item) {
		boolean collision = true;
		int hashValue = functor.hash(item) % storage.length;
		// creates a new linked list if there is nothing at the specified value.
		if (storage[hashValue] == null) {
			storage[hashValue] = new LinkedList<String>();
			collision = false;
		}
		// checks to see if the item is already in the list.
		if (storage[hashValue].contains(item)) {
			return false;
		} else {
			storage[hashValue].add(item);
			if (collision) {
				collisions++;
			}
			numOccupied++;
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends String> items) {
		Iterator<? extends String> itr = items.iterator();
		boolean added = false;
		while (itr.hasNext()) {
			if (add(itr.next())) {
				added = true;
			}
		}
		return added;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		numOccupied = 0;
	}

	@Override
	public boolean contains(String item) {
		int hashValue = functor.hash(item) % capacity;
		if (storage[hashValue] == null) {
			return false;
		} else if (storage[hashValue].contains(item)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<? extends String> items) {
		Iterator<? extends String> itr = items.iterator();
		while (itr.hasNext()) {
			if (!contains(itr.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (numOccupied == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return numOccupied;
	}

	/**
	 * This is a private method used to compute the next prime number after the
	 * number passed in.
	 * 
	 * @param int num -- The starting number.
	 * @return int nextNum -- The next prime number after the starting number.
	 */
	private int nextPrime(int num) {
		int nextNum = num;
		boolean prime = true;
		while (true) {
			prime = true;
			nextNum++;
			for (int i = 2; i < nextNum; i++) {
				if (nextNum % i == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				return nextNum;
			}
		}
	}
	
	/**
	 * This function takes in a number and determines if the number is Prime or
	 * not. If the number is prime, the function returns true. Else, it returns
	 * false.
	 * 
	 * @param int num -- The number being checked to see if it is prime.
	 * @return boolean -- True if the number is prime, otherwise false.
	 */
	public boolean isPrime(int num) {
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
