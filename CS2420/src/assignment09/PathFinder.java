package assignment09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** This class contains a single public method solveMaze(). This class also contains several private methods to help compute
 * the shortest path from a starting point in a maze to a specified goal. The class uses Linked Lists,queues, and a 
 * breadth first search to compute the path.  
 * 
 * @author Kale Thompson & Brandon Mouser
 *
 */
public class PathFinder {
	
	// Creates global variables that can be accessed by all private methods within the class
	public static Node graph[][];
	public static int rows;
	public static int columns;
	public static Node start;
	public static Node goal;
	

	/** This method will read a maze from a file with the given input name, and output the solved maze to a file with 
	 * the given output name. Solved maze will contain '.' denoting the shortest path between the start and the goal.
	 * @param inputFile
	 * @param outputFile
	 * @throws FileNotFoundException 
	 */
	public static void solveMaze(String inputFile, String outputFile) throws FileNotFoundException{
		File mazeFileIn = new File(inputFile);
		File mazeFileOut = new File(outputFile);
		readIn(mazeFileIn);
		setNeighbors();
		findPath();
		breadthFirstSearch();
		readOut(mazeFileOut);	
	}
	
	/** Reads in a file that contains the maze that needs to be solved. Creates a 2-D array with the same dimensions as the 
	 * maze, and places nodes in the 2-D array whose data elements correspond to the data in the maze.
	 * 
	 * @param inputFile
	 * @throws FileNotFoundException 
	 */
	public static void readIn(File inputFile) throws FileNotFoundException{
		try {
			Scanner file = new Scanner(inputFile);
			String[] dimensions = file.nextLine().split(" ");
			rows = Integer.parseInt(dimensions[0]);
			columns = Integer.parseInt(dimensions[1]);
			graph = new Node[rows][columns];
			for(int rowIndex = 0; rowIndex < rows; rowIndex++){
				String line = file.nextLine();
				for(int columnIndex = 0; columnIndex < columns; columnIndex++){
					Node element = new Node();
					element.data = line.charAt(columnIndex);
					graph[rowIndex][columnIndex] = element;
				}
			}
			file.close();
		} catch(FileNotFoundException e){
			throw e;
		}	
	}
	
	/** Prints the solved maze to the specified file. Places a character '.' in each open space that is part of the shortest
	 * path between the start and the end.
	 * 
	 * @param outputFile
	 */
	private static void readOut(File outputFile){
		try(PrintWriter output = new PrintWriter(new FileWriter(outputFile))){
			output.println(rows + " " + columns);
			for (int rowIndex = 0; rowIndex < rows; rowIndex++){
				for (int columnIndex = 0; columnIndex < columns; columnIndex++){
					output.print(graph[rowIndex][columnIndex].data);
				}
				output.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** This function sets the neighbors of all nodes within the 2-D array. Checks to make sure that the node is not
	 * on the boundary of the 2-D array and sets the neighbors to the nodes above, left, right, and below the current 
	 * node.
	 * @param: NONE
	 * @return: NONE
	 */
	private static void setNeighbors(){
		for (int rowIndex = 0; rowIndex < rows; rowIndex++){
			for (int columnIndex = 0; columnIndex < columns; columnIndex++){
				Node temp = new Node();
				temp = graph[rowIndex][columnIndex];
				// Checks to see if the current column in the last column, if last we know nothing is to the right.
				if(columnIndex < columns - 1){
					temp.neighbors.add(graph[rowIndex][columnIndex + 1]);
				}
				// Checks to see if we are at the bottom row, if bottom we know nothing is below.
				if(rowIndex < rows - 1){
					temp.neighbors.add(graph[rowIndex + 1][columnIndex]);
				}
				// Checks to see if we are at the first row, if first we know nothing is above.
				if(rowIndex > 0){
					temp.neighbors.add(graph[rowIndex - 1][columnIndex]);
				}
				// Checks to see if if the current column is 0, if 0 then we know nothing is to the left.
				if(columnIndex > 0){
					// Adds the item above the current node to the LinkedList neighbors of our temp node.
					temp.neighbors.add(graph[rowIndex][columnIndex - 1]);
				}
				// Temp node now contains all neighbors so we set the actual node at that index equal to temp.
				graph[rowIndex][columnIndex] = temp;
			}
		}
	}
	
	/** Finds the two nodes that contain the data for the Start of the Graph and Goal of the graph.
	 * Saves the data to the corresponding global variables.
	 * 
	 */
	private static void findPath(){
		for (int rowIndex = 0; rowIndex < rows; rowIndex++){
			for (int columnIndex = 0; columnIndex < columns; columnIndex++){
				if(graph[rowIndex][columnIndex].data == 'S'){
					start = graph[rowIndex][columnIndex];
				}
				else if(graph[rowIndex][columnIndex].data == 'G'){
					goal = graph[rowIndex][columnIndex];
				}
			}
		}
	}
	
	/** Computes a BreadthFirstSearch to find the shortest path between the start node and goal node. Uses a queue and starts at the 
	 * Start node. If the current node does not equal the goal node, the neighbors of the current node will be added to the
	 * queue. Then removes the next element in the queue and repeats the same process.
	 * 
	 */
	private static void breadthFirstSearch(){
		Queue<Node> mazeQueue = new LinkedList<Node>();
		start.visited = true;
		mazeQueue.add(start);
		while(!mazeQueue.isEmpty()){
			Node current = mazeQueue.remove();
			if(current.equals(goal)){
				current = current.prev;
				returnToStart(current);
				return;
			}
			for(int index = 0; index < current.neighbors.size(); index++){
				Node next = current.neighbors.get(index);
				if((!next.visited) && next.data != 'X'){
					next.visited = true;
					next.prev = current;
					mazeQueue.add(next);
				}
			}
		}
	}
	
	/** Replaces the data at all elements within the shortest path with a '.'.
	 * 
	 * @param current
	 */
	private static void returnToStart(Node current){
		while(current.data != 'S'){
			current.data = '.';
			current = current.prev;
		}
		return;
	}
	
	public static String nodeArrayToString(){
		String nodeToString = "";
		for(int row = 0; row < rows; row++){
			for(int column = 0; column < columns; column++){
				nodeToString += graph[row][column].data + ", ";
			}
		}
		return nodeToString;
	}

	
	public static void main(String[] args){
	}
}
