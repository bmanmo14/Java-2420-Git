package assignment07;

import assignment06.DoublyLinkedList;
import java.util.NoSuchElementException;

/**
 * Represents a generic stack (first in, last out).
 * 
 * @author Brandon Mouser & David Neil Ord
 * 
 * @param <E> -- the type of elements contained in the stack
 */
public class LinkedListStack<E> {

	private DoublyLinkedList<E> stack;
	
	/**
	 * Basic constructor for the LinkedListStack.
	 */
	public LinkedListStack() {
		stack = new DoublyLinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Determines whether or not a stack is empty.
	 * 
	 * @return boolean -- True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. 
	 * 
	 * @return E -- The item at the top of the stack.
	 * @throws -- Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException {
		checkSize();
		return stack.getFirst();
	}

	/**
	 * This function removes the first element in the stack and returns the item that was removed.
	 * 
	 * @return E -- The item removed from the stack.
	 * @throws -- Throws NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException {
		checkSize();
		return stack.removeFirst();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.addFirst(item);
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}
	
	/**
	 * This function checks if the stack is empty. This function is just used when peeking or popping.
	 * If the stack is empty, then the peek and pop function cannot be called.
	 * 
	 * @throws -- Throws NoSuchElementException if the stack is empty and peek or pop is called.
	 */
	private void checkSize() {
		if (stack.isEmpty()){
			throw new NoSuchElementException();
		}
	}
}