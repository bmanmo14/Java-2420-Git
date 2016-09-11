package assignment10;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class is used to create a HashTable that resolves collisions by using
 * Quadratic Probing. This class implements Set<String> and includes
 * functionality to add a single item to the HashTable, add a list of items to
 * the HashTable, and to check if the HashTable contains a certain String or a
 * list of Strings.
 * 
 * @author Brandon Mouser and Kale Thompson
 */
public class QuadProbeHashTable implements Set<String> {

	public String[] array;
	public int capacity;
	public int probeNumber;
	public int count = 0;
	public HashFunctor functor;
	public int collisions;

	/**
	 * Constructs a hash table of the given capacity that uses the hashing
	 * function specified by the given functor.
	 * 
	 * @param int capacity -- The initial capacity. 
	 * 		  HashFunctor functor -- The functor used to generate String hashes.
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor) {
		if (!isPrime(capacity)) {
			this.capacity = nextPrime(capacity);
		} else {
			this.capacity = capacity;
		}
		this.functor = functor;
		array = new String[this.capacity];
		collisions = 0;
		probeNumber = 1;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean add(String item) {
		if (count + 1 >= capacity / 2) {
			resizeArray();
		}

		if (contains(item)) {
			return false;
		}

		int hash = functor.hash(item) % capacity;
		int originalHash = 0;
		probeNumber = 1;
		if (array[hash] == null) {
			array[hash] = item;
			count++;
			return true;
		} else {
			originalHash = hash;
			while (array[hash] != null) {
				hash = originalHash;
				hash += probeNumber * probeNumber;
				//hash = hash % capacity;
				if(hash >= capacity){
					hash = hash - capacity;
				}
				probeNumber++;
				collisions++;
			}
			array[hash] = item;
			count++;
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		Iterator<? extends String> itr = c.iterator();
		if(containsAll(c)){
			return false;
		}
		while (itr.hasNext()) {
			add(itr.next());
		}
		if (!containsAll(c)) {
			return false;
		}
		return true;
	}

	@Override
	public void clear() {
		array = new String[capacity];
		count = 0;

	}

	@Override
	public boolean contains(String item) {
		probeNumber = 1;
		int hash = functor.hash(item) % capacity;
		int originalHash = 0;
		originalHash = hash;
		while (array[hash] != null) {
			if (array[hash] == item) {
				return true;
			} else {
				hash = originalHash;
				hash += probeNumber * probeNumber;
				if(hash >= capacity){
					hash = hash - capacity;
				}
				//hash = hash % capacity;
				probeNumber++;
			}
		}
		return false;
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

	/**
	 * This is a private method used to compute the next prime number between
	 * the number that was passed in, and that number times 2. Bertrand's
	 * Postulate says that there is always one prime number P such that 
	 * number < P < number*2.
	 * 
	 * @param int num -- The starting number.
	 * @return int -- The next prime number after the starting number..
	 */
	public int nextPrime(int num) {
		int newPrime = 0;
		for (int i = num + 1; i < 2 * num; i++) {
			if (isPrime(i)) {
				newPrime = i;
				return newPrime;
			}
		}
		return newPrime;
	}

	/**
	 * This is a private method used by the add method to resize the array if
	 * the current array is half full. The old capacity is doubled and then the
	 * next prime after the capacity is doubled is the new size of the array.
	 */
	private void resizeArray() {
		int newSize = nextPrime(capacity * 2);
		String[] temp = new String[capacity];
		temp = array;
		array = new String[newSize];
		this.capacity = newSize;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				reHash(temp[i]);
			}
		}
	}

	/**
	 * This function just adds all of the items from the old HashTable to the
	 * new, larger HashTable after resizing has been done.
	 * 
	 * @param String item -- The string being added to the new array.
	 */
	private void reHash(String item) {
		int hash = functor.hash(item) % capacity;
		probeNumber = 1;
		if (array[hash] == null) {
			array[hash] = item;
			return;
		} else {
			while (array[hash] != null) {
				hash = functor.hash(item) % capacity;
				hash += probeNumber * probeNumber;
				hash = hash % capacity;
				probeNumber++;
			}
			array[hash] = item;
			return;
		}
	}

	/**
	 * This function just returns a String array of all of the items in the
	 * HashTable. Mostly used by us for debugging, but is good to have.
	 * 
	 * @return String[]-- The array of words in the Hash Table.
	 */
	public String[] toArray() {
		String[] toArray = new String[count];
		int counter = 0;
		for (int i = 0; i < capacity; i++) {
			if (array[i] != null) {
				toArray[counter] = array[i];
				counter++;
			}
		}
		return toArray;
	}
}
