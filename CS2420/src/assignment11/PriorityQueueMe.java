package assignment11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items. 
 * The queue is implemented as a min heap. 
 * The min heap is implemented implicitly as an array.
 * 
 * @author 
 */
@SuppressWarnings("unchecked")
public class PriorityQueueMe<AnyType> {

	private int currentSize;

	private AnyType[] array;

	private Comparator<? super AnyType> cmp;
	
	private int arraySize = 10;

	/**
	 * Constructs an empty priority queue. Orders elements according
	 * to their natural ordering (i.e., AnyType is expected to be Comparable)
	 * AnyType is not forced to be Comparable.
	 */
	
	public PriorityQueueMe() {
		currentSize = 0;
		cmp = null;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * Construct an empty priority queue with a specified comparator.
	 * Orders elements according to the input Comparator (i.e., AnyType need not
	 * be Comparable).
	 */
	public PriorityQueueMe(Comparator<? super AnyType> c) {
		currentSize = 0;
		cmp = c;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * @return the number of items in this priority queue.
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Makes this priority queue empty.
	 */
	public void clear() {
		currentSize = 0;
		array = (AnyType[]) new Object[10];
	}

	/**
	 * @return the minimum item in this priority queue.
	 * @throws NoSuchElementException if this priority queue is empty.
	 * 
	 * (Runs in constant time.)
	 */
	public AnyType findMin() throws NoSuchElementException {
		if(array.length == 0){
			throw new NoSuchElementException();
		}
		return array[0];
	}


	/**
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @throws NoSuchElementException if this priority queue is empty.
	 * 
	 * (Runs in logarithmic time.)
	 */
	public AnyType deleteMin() throws NoSuchElementException {
		// if the heap is empty, throw a NoSuchElementException
		if(array.length == 0){
			throw new NoSuchElementException();
		}
		// store the minimum item so that it may be returned at the end
		AnyType minimum = array[0];
		
		// replace the item at minIndex with the last item in the tree
		AnyType lastItem = array[currentSize - 1];
		array[currentSize-1] = null;
		array[0] = lastItem;
		currentSize--;
		percolateDown();
		return minimum;
	}

	/**
	 * This function is used by the deleteMin() function to replace the smallest item in the Priority
	 * Queue with the next smallest, and adjust the Priority Queue accordingly.
	 */
	public void percolateDown() {
		AnyType temp = array[0];
		for (int i = 0; i < currentSize; i++) {
			if ((i * 2) + 1 < currentSize) {
				if ((i * 2) + 2 < currentSize) {
					if (compare(temp, array[(i * 2) + 1]) == 1 && compare(temp, array[(i * 2) + 2]) == 1) {
						if (compare(array[(i * 2) + 1], array[(i * 2) + 2]) == 1) {
							array[i] = array[(i * 2) + 2];
							array[(i * 2) + 2] = temp;
							i = (i * 2) + 1;
						} else {
							array[i] = array[(i * 2) + 1];
							array[(i * 2) + 1] = temp;
							i = (i * 2);
						}
					}
				} else if (compare(temp, array[(i * 2) + 1]) == 1) {
					array[i] = array[(i * 2) + 1];
					array[(i * 2) + 1] = temp;
					i = (i * 2);
				} else if ((i * 2) + 2 < currentSize && compare(temp, array[(i * 2) + 2]) == 1) {
					array[i] = array[(i * 2) + 2];
					array[(i * 2) + 2] = temp;
					i = (i * 2);
				}
			}
		}
	}
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
	}
	/**
	 * This function adds the desired item to the Priority Queue.
	 * (Runs in logarithmic time.) Can sometimes terminate early.
	 * 
	 * @param x -- The item to be inserted.
	 */
	public void add(AnyType x) {
		if(currentSize == arraySize -1 ){
			resizeArray();
		}
		array[currentSize] = x;
		currentSize++;
		percolateUp();
	}
	
	/**
	 * This function is used by the add() method to place the item being added tot he Priority Queue
	 * in the correct place in the tree. If the item being added is smaller than its parent,
	 * the item is percolated up until both parents are smaller than the item.
	 */
	public void percolateUp(){
		if(currentSize == 1){
			return;
		}
		for(int i = currentSize-1; i > 0; i--){
			AnyType temp = array[i];
			if(compare(array[(i-1)/2], temp) == 1){
				array[i] = array[(i-1)/2];
				array[(i-1)/2] = temp;
			}
		}
	}
	
	public void resizeArray(){
		arraySize = arraySize*2;
		AnyType[] temp = (AnyType[]) new Object[arraySize];
		
		for(int i = 0; i < (arraySize/2); i++){
			if(array[i] != null){
				temp[i] = array[i];
			}
		}
		array = temp;
	}

	/**
	 * Generates a DOT file for visualizing the binary heap.
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
	 */
	@SuppressWarnings("unused")
	private int compare(AnyType lhs, AnyType rhs) {
		if (cmp == null) {
			return ((Comparable<? super AnyType>) lhs).compareTo(rhs); // safe to ignore warning
		}
		// We won't test your code on non-Comparable types if we didn't supply a Comparator
		return cmp.compare(lhs, rhs);
	}



	//LEAVE IN for grading purposes
	public Object[] toArray() {    
		Object[] ret = new Object[currentSize];
		for(int i = 0; i < currentSize; i++) {
			ret[i] = array[i];
		}
		return ret;
	}
}