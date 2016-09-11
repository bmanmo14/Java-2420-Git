/**
 * 
 */
package assignment_13;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class is what we will test your code on. If your BestPath
 * objects equal ours (using the .equals method given) then you will
 * pass the tests. Do no modify anything that is given (use it of
 * course but don't change names etc.)
 * 
 * @author CS2420 Teaching Staff - Spring 2016
 */
public class BestPath {
	
	/**
	 * This should contain the nodes between the origin and destination
	 * inclusive. For example if I want the path between SLC and MEM it
	 * should have SLC (index 0), MEM (index 1). If there are lay overs
	 * it should include them in between (turns out you can fly to Memphis
	 * from here directly).
	 */
	private ArrayList<String> path;
	
	/**
	 * Since some path costs are going to be doubles sometimes use a double
	 * when costs are integers cast to a double.
	 */
	private double pathLength;
	
	/**
	 * This is just a basic constructor for the BestPath class. This constructor takes in a LinkedList and the pathLength
	 * and gets the correct path form the LinkedList and sets the pathLength equal to _pathLength.
	 * @param LinkedList<String> _path -- The Path from the goal to the start Airport.
	 * @param double _pathLength -- The weight of this path based on the criteria provided by the user.
	 */
	public BestPath(LinkedList<String> _path, double _pathLength){
		path = new ArrayList<String>();
		while(!_path.isEmpty()){
			path.add(_path.poll());
		}
		this.pathLength = _pathLength;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BestPath) {
			BestPath other = (BestPath) o;
			return this.pathLength == other.pathLength && this.path.equals(other.path);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Path Length: " + pathLength + "\nPath: "+ this.path;
	}
}
