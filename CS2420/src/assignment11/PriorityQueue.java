package assignment11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This class represents a priority queue of generically-typed items. 
 * The queue is implemented as a min heap and the min heap is implemented implicitly as an array.
 * This class allows you to 
 * 
 * @author Brandon Mouser and Kale Thompson
 */
@SuppressWarnings("unchecked")
public class PriorityQueue<AnyType> {

	private int currentSize;

	private AnyType[] array;

	private Comparator<? super AnyType> comp;

	/**
	 * Constructs an empty priority queue. Orders elements according
	 * to their natural ordering (i.e., AnyType is expected to be Comparable)
	 * AnyType is not forced to be Comparable.
	 */
	public PriorityQueue() {
		currentSize = 0;
		comp = null;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * Construct an empty priority queue with a specified comparator.
	 * Orders elements according to the input Comparator (i.e., AnyType need not
	 * be Comparable).
	 * 
	 * @param _comp -- The comparator that will be used with the given data type.
	 */
	public PriorityQueue(Comparator<? super AnyType> _comp) {
		currentSize = 0;
		comp = _comp;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * This function returns the number of elements in the Priority Queue.
	 * 
	 * @return int -- The number of items in this Priority Queue.
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * This function simply empties the Priority Queue.
	 */
	public void clear() {
		currentSize = 0;
		array = (AnyType[]) new Object[10];
	}
	
	/**
	 * This function returns an integer of the location of the left hand child of a given parent.
	 * 
	 * @param i -- The location of the parent whose left hand child is being searched for.
	 * @return int -- The location of the left hand child of the given parent.
	 */
	private int leftChildIndex(int i){
		return (i*2) + 1;
	}
	
	/**
	 * This function returns an integer of the location of the right hand child of a given parent.
	 * 
	 * @param i -- The location of the parent whose right hand child is being searched for.
	 * @return int -- The location of the right hand child of the given parent.
	 */
	private int rightChildIndex(int i){
		return (i*2) + 2;
	}
	
	/**
	 * This function returns an integer of the location of the parent of an item in the Priority Queue
	 * at the given index i.
	 * 
	 * @param int i -- The location of the child.
	 * @return int -- The location of the parent of the given child.
	 */
	private int parentIndex(int i){
		return (i-1) / 2;
	}

	/**
	 * This function finds and returns the smallest item in the Priority Queue, which should just
	 * be the very first item in the array.
	 * 
	 * @return AnyType -- The minimum item in this priority queue.
	 * @throws NoSuchElementException if this priority queue is empty.
	 */
	public AnyType findMin() throws NoSuchElementException {
		if(currentSize == 0){
			throw new NoSuchElementException();
		}
		return array[0];
	}


	/**
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @return AnyType -- The smallest item that was removed from this Priority Queue.
	 * @throws NoSuchElementException if this priority queue is empty.
	 */
	public AnyType deleteMin() throws NoSuchElementException {
		if(currentSize == 0){
			throw new NoSuchElementException();
		}
		AnyType minItem = array[0];
		if(currentSize == 1){
			array[0] = null;
			currentSize--;
			return minItem;
		}
		array[0] = array[currentSize - 1]; 
		array[currentSize - 1] = null;
		currentSize = currentSize - 1;
		percolateDown();
		return minItem;
		
	}
	
	/**
	 * This function is used by the deleteMin() function to replace the smallest item in the Priority
	 * Queue with the next smallest, and adjust the Priority Queue accordingly.
	 */
	private void percolateDown() {
		/*AnyType temp = array[0];
		for (int i = 0; i < currentSize; i++) {
			if (leftChildIndex(i) < currentSize) {
				if (rightChildIndex(i) < currentSize) {
					if (compare(temp, array[leftChildIndex(i)]) == 1 && compare(temp, array[rightChildIndex(i)]) == 1) {
						if (compare(array[leftChildIndex(i)], array[rightChildIndex(i)]) == 1) {
							array[i] = array[rightChildIndex(i)];
							array[rightChildIndex(i)] = temp;
							i = (i * 2) + 1;
						} else {
							array[i] = array[leftChildIndex(i)];
							array[leftChildIndex(i)] = temp;
							i = (i * 2);
						}
					}
				} else if (compare(temp, array[leftChildIndex(i)]) == 1) {
					array[i] = array[leftChildIndex(i)];
					array[leftChildIndex(i)] = temp;
					i = (i * 2);
				} else if ((i * 2) + 2 < currentSize && compare(temp, array[rightChildIndex(i)]) == 1) {
					array[i] = array[rightChildIndex(i)];
					array[rightChildIndex(i)] = temp;
					i = (i * 2) + 1;
				}
			}
		}
		*/
		int i = 0;
		AnyType leftOfCurrent;
		AnyType rightOfCurrent;
		while (true) {
			AnyType current = array[i];
			if(leftChildIndex(i) < array.length){
				leftOfCurrent  = array[leftChildIndex(i)];
			}
			else{
				leftOfCurrent = null;
			}
			if(rightChildIndex(i) < array.length){
				rightOfCurrent  = array[rightChildIndex(i)];
			}
			else{
				rightOfCurrent = null;
			}
			
			if (leftOfCurrent == null || rightOfCurrent == null) {
				if (leftOfCurrent == null && rightOfCurrent == null) {
					break;
				} else if (rightOfCurrent == null && leftOfCurrent != null) {
					if(compare(current, leftOfCurrent) > 1){
						array[i] = leftOfCurrent;
						array[leftChildIndex(i)] = current;
						break;
					}
				} else if (leftOfCurrent == null && rightOfCurrent != null) {
					if(compare(current, rightOfCurrent) > 1){
						array[i] = rightOfCurrent;
						array[rightChildIndex(i)] = current;
						break;
					}
				}
				break;
			}
			if (compare(current, leftOfCurrent) < 1 && compare(current, rightOfCurrent) < 1) {
				break;
			}
			int value = compare(leftOfCurrent, rightOfCurrent);
			if (value < 1) {
				array[i] = leftOfCurrent;
				array[leftChildIndex(i)] = current;
				i = leftChildIndex(i);
			} else {
				array[i] = rightOfCurrent;
				array[rightChildIndex(i)] = current;
				i = rightChildIndex(i);
			}
		}
		return;
	}
	
	/**
	 * This function is used by the add() method to place the item being added to the Priority Queue
	 * in the correct place in the tree. If the item being added is smaller than its parent,
	 * the item is percolated up until the parents is smaller than its child(ren).
	 */
	private void percolateUp() {
		int i = currentSize - 1;
		while(true){
			AnyType current = array[i];
			AnyType parent = array[parentIndex(i)];
			if(compare(current, parent) == 0){
				break;
			}
			if(compare(current, parent) < 1){
				array[i] = parent;
				array[parentIndex(i)] = current;
				i = parentIndex(i);
			} else {
				break;
			}
		}
		return;
	}
	


	/**
	 * This function adds the desired item to the Priority Queue.
	 * (Runs in logarithmic time.) Can sometimes terminate early.
	 * 
	 * @param x -- The item to be inserted.
	 */
	public void add(AnyType x) {
		if(currentSize == 0){
			array[currentSize] = x;
			currentSize++;
			return;
		}
		if(currentSize == array.length){
			AnyType[] temp = (AnyType[]) new Object[array.length * 2];
			for(int i = 0; i < array.length; i++){
				temp[i] = array[i];
			}
			array = temp;
		}
		array[currentSize] = x;
		currentSize++;
		percolateUp();
		return;
	}

	/**
	 * This function generates a DOT file that is used to visualize the Priority Queue.
	 * Mostly just used for debugging purposes.
	 */
	public void generateDotFile(String filename) {
		try(PrintWriter out = new PrintWriter(filename)) {
			out.println("digraph Heap {\n\tnode [shape=record]\n");

			for(int i = 0; i < currentSize; i++) {
				out.println("\tnode" + i + " [label = \"<f0> |<f1> " + array[i] + "|<f2> \"]");
				if(((i*2) + 1) < currentSize)
					out.println("\tnode" + i + ":f0 -> node" + ((i*2) + 1) + ":f1");
				if(((i*2) + 2) < currentSize)
					out.println("\tnode" + i + ":f2 -> node" + ((i*2) + 2) + ":f1");
			}
			out.println("}");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Internal method for comparing lhs and rhs using Comparator if provided by the
	 * user at construction time, or Comparable, if no Comparator was provided.
	 * 
	 * @param AnyType lhs -- The left hand item that is being compared to the right hand item.
	 * 		  AnyType rhs -- The right hand item that is being compared with the left hand item.
	 * 
	 * @return int -- if leftObject < rightObject, returns number < 0. 
	 * 				  if leftObject > rightObject, returns number > 0. 
	 * 				  if leftObject == rightObject, returns number 0.
	 */
	private int compare(AnyType lhs, AnyType rhs) {
		if (comp == null) {
			return ((Comparable<? super AnyType>) lhs).compareTo(rhs);
		}
		return comp.compare(lhs, rhs);
	}



	/**
	 * This just creates and returns an array of the items in the Priority Queue.
	 * 
	 * @return Object[] -- An array of the items in the Priority Queue.
	 */
	public Object[] toArray() {    
		Object[] ret = new Object[currentSize];
		for(int i = 0; i < currentSize; i++) {
			ret[i] = array[i];
		}
		return ret;
	}
}