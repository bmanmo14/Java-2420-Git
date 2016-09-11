package assignment06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Brandon Mouser and David Ord
 * 
 * This DoublyLinkedList class implements List and creates a new Doubly Linked List that can store any type of item.
 * These lists are made from Nodes that store the item and a reference to the next Node and the Node before it, if there is one.
 * Because these Linked Lists are built from Nodes, the List can grow and shrink dynamically as needed.
 *
 * @author Brandon Mouser & David Neil Ord
 * @param <E> -- The type of the items that are being added to the list.
 */
public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

	/**
	 * This Node Class stores an item of any type, called data, and a reference to the
	 * next node, called next, and a reference to the previous Node, called prev. The Linked List is built from
	 * these Nodes.
	 */
	private class Node {
		public E data;
		public Node next;
		public Node prev;
	}

	private Node head;
	private Node tail;
	int count;
	
	/**
	 * This is the basic constructor for the DoublyLinkedList class. This constructor makes a new, empty Linked List.
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	/**
	 * This function adds an item to the very first spot in the Linked List.
	 * 
	 * @param E element -- The object to be added to the beginning of the list.
	 */
	@Override
	public void addFirst(E element) {
		Node temp = new Node();
		temp.data = element;
		temp.prev = null;
		
		if (count == 0) {
			temp.next = null;
			head = temp;
			tail = temp;
			tail.next = null;
			head.prev = null;
		}
		else if (count == 1) {
			tail.prev = temp;
			temp.next = tail;
			head = temp;
		}
		else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		count++;
	}

	/**
	 * Adds an item to the very last position in the Linked List.
	 * 
	 * @param E toAdd -- The object to be added to the end of the list.
	 */
	@Override
	public void addLast(E toAdd) {
		Node temp = new Node();
		temp.data = toAdd;
		temp.next = null;
		
		if (count ==0) {
			head = temp;
			tail = temp;
			head.prev = null;
			tail.next = null;
		}
		else if (count == 1) {
			temp.prev = head;
			head.next =  temp;
			tail = temp;
		}
		else {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		count++;
	}

	/**
	 * Adds an element to the index specified by the user, if the index exists.
	 * If the index exists, the element is placed at that position and the Linked List is shifted down to make
	 * room for the new element.
	 * 
	 * @param int index -- The place where the word will be inserted into the list, if the index exists.
	 * 		  E element -- The item that is being put in that position.
	 * @throws IndexOutOfBoundsException -- If the list does not extend to the given index.
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index > count || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			addFirst(element);
			return;
		}
		if(index == count){
			addLast(element);
			return;
		}
		
		Node tempAdd = new Node();
		Node temp;
		int iterCount = 0;
		if (index <= count / 2) {
			temp = head;
			iterCount = 0;
			while (iterCount < index-1) {
				temp = temp.next;
				iterCount++;
			}
			tempAdd.data = element;
			tempAdd.prev = temp;
			tempAdd.next = temp.next;
			temp.next = tempAdd;
			}
		else {
			temp = tail;
			iterCount = count - 1;
			while (iterCount >= index) {
				temp = temp.prev;
				iterCount--;
			}
			tempAdd.data = element;
			tempAdd.prev = temp;
			tempAdd.next = temp.next;
			temp.next = tempAdd;
			
			if (index == count - 1) {
				tempAdd.prev = tail;
				tail.next = tempAdd;
				tail = tempAdd;
			}
		}
		count++;
	}
	
	/**
	 * Gets and returns the item in the Linked List that is at the very first position.
	 * 
	 * @return E -- The item at the first position of the Linked List.
	 * @throws NoSuchElementException -- If the list is empty.
	 * 
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (head == null){
			throw new NoSuchElementException();
		}
		return head.data;
	}

	/**
	 * Gets and returns the item that is at the very last position of the Linked List.
	 * 
	 * @return E -- The item at the end of the Linked List.
	 * @throws NoSuchElementException -- If the list is empty.
	 * 
	 */
	@Override
	public E getLast() throws NoSuchElementException {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	/**
	 * Gets and returns the item at the index specified by the user, if the index exists.
	 * If the index exists, the item is returned to the user, otherwise an exception is thrown.
	 * 
	 * @param int index -- The index of the Linked List that the user wants to get the item from, if it exists.
	 * @return E -- The item at that specified index.
	 * @throws IndexOutOfBoundsException -- If the list does not extend to the given index.
	 * 
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node temp;
		temp = head;
		int iterCount = 0;
		while(iterCount < index) {
			temp = temp.next;
			iterCount++;
		}
		return temp.data;
	}
	
	/**
	 * Removes the first item from the list and then returns the first item in the Linked List to the user.
	 * 
	 * @return E -- The item at the first position in the Linked List.
	 * @throws NoSuchElementException -- If the list is empty.
	 * 
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		head = head.next;
		count--;
		return temp.data;
	}

	/**
	 * Removes the last item in the Linked List and returns the last item to the user.
	 * 
	 * @return E -- The item at the last position in the Linked List.
	 * @throws NoSuchElementException -- If the list is empty.
	 * 
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		Node temp = tail;
		tail = tail.prev;
		count--;
		return temp.data;
	}

	/**
	 * Removes and returns the element at the specified position in the list, if that position exists.
	 * 
	 * @param int index -- The index of the element to be removed.
	 * @return E -- The element at the specified position in the list.
	 * @throws IndexOutOfBoundsException -- If the list does not extend to the given index.
	 * 
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node temp = head;
		Node toRemove = new Node();
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} 
		else {
			if (index == 0) {
				removeFirst();
				return temp.data;
			} 
			else {
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				toRemove = temp.next;
				temp.next = temp.next.next;
			}
			count--;
		}
		return toRemove.data;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * 
	 * @param E element -- The element that is being searched for.
	 * @return int -- The first position in the Linked List where the element occurs, or -1 if the Linked List 
	 * 				  doesn't contain the element.
	 */
	@Override
	public int indexOf(E element) {
		Node temp = head;
		int indexCount = 0;
		while (temp != null) {
			if (temp.data.equals(element)) {
				return indexCount;
			}
			indexCount++;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * 
	 * @param E element -- The element that is being searched for in the list.
	 * @return int -- The position in the Linked List where the last occurrence of the element occurs, 
	 * 				  or -1 if the element is not in the Linked List.
	 */
	@Override
	public int lastIndexOf(E element) {
		Node temp = tail;
		int indexCount = count - 1;
		while (temp != null) {
			if (temp.data.equals(element)) {
				return indexCount;
			}
			indexCount--;
			temp = temp.prev;
		}
		return -1;
	}

	/**
	 * Returns the size of the Linked List.
	 * 
	 * @return int -- The number of items in the Linked List.
	 */
	@Override
	public int size() {
		return count;
	}
	
	/**
	 * Determines whether or not the List is empty or not.
	 * 
	 * @return boolean -- Returns true of the List is empty, otherwise returns false.
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Clears the Linked List so it is empty.
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}
	
	/**
	 * This function turns the Linked List into an Array of Objects.
	 * 
	 * @return Object[] -- An Array of all the elements contained in the Linked List.
	 */
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[count];
		
		Node temp = head;
		for (int i = 0; i < count; i++) {
			arr[i] = temp.data;
			temp = temp.next;
		}
		return arr;
	}
	
	/**
	 * This function turns the elements in the Linked List into a string of elements.
	 * Just like the .toString() function would do for an ArrayList<>,
	 * this function displays the elements of the Linked List in brackets with commas after each element.
	 * 
	 * @return String -- The words in the Linked List put into one string.
	 */
	public String toString() {
		Node temp = head;
		String toString = "";
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
				toString += (temp.data + ", ");
				temp = temp.next;
			}
			if (i == count - 1) {
				toString += (temp.data);
			}
		}
		toString = "[" + toString + "]";
		return toString;
	}
	
	/**
	 * This is just a basic iterator the user can use to traverse through the Linked List.
	 * The user can also remove the last element they saw in the Linked List.
	 * 
	 * @return Iterator<E> -- An iterator over the elements in this Linked List
	 * 
	 */
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;
			private Node current = null;
			private boolean hasNextCalled = false;

			
			/**
			 * Indicates if there is another item in the list.
			 * 
			 * @return boolean -- True if there is an item at the index.
			 * 						False, otherwise.
			 */
			public boolean hasNext() {
				if(index < count){
					return true;
				}
				return false;
			}

			/**
			 * Removes the last item returned by next.
			 * 
			 * @throws IllegalStateException -- If each call of remove is not preceded by a call to next().
			 * 										Or, remove is called twice on the same object.
			 */
			public void remove() throws IllegalStateException {
				if(hasNextCalled == false){
					throw new IllegalStateException();
				}
				else if(current != null){
					if(current == head){
						head = head.next;
					}
					else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
					}
				}
					hasNextCalled = false;
					count--;
					index--;
			}

			/**
			 * Returns the next item in the list, or the one indicated by hasNext()
			 * 
			 * @return E -- The item at that index.
			 * @throws NoSuchElementException -- If hasNext() returns false.
			 * 
			 */
			public E next() throws NoSuchElementException {
				if(hasNext() == false){
					throw new NoSuchElementException();
				}
				if(hasNext() == true){
					if(current == null){
						current = head;
						hasNextCalled = true;
						index++;
						return head.data;
					}
					else{
						current = current.next;
						hasNextCalled = true;
						index++;
					}
				}
				return current.data;
			}
		};
	}
}
