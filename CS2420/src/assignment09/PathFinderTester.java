package assignment09;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * This JUnit test file tests the PathFinder class to make sure the path found is indeed the shortest
 * path and the function writes the correct data to the file.
 * The mazes tested in this class include all of the mazes from the maze zip file given to us online,
 * and it tests all of the mazes in that file except for the Demo Maze. The Demo Maze isn't tested because
 * although our program found the shortest length to the goal, there are multiple shortest lengths and 
 * our program found a different path than the solution given.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class PathFinderTester {

	@Test
	public void testSolveMaze() throws FileNotFoundException {
		// Each of these code blocks test a different maze.
		// Big Maze
		PathFinder.solveMaze("bigMaze.txt", "bigMazeSolution.txt");
		// Create a new String that is our solution to the maze as one string.
		String ourBigMazeSol = PathFinder.nodeArrayToString();
		// Read in the correct solution.
		PathFinder.readIn(new File("bigMazeSol.txt"));
		// Create a new String that is the correct solution to the maze.
		String correctBigMazeSol = PathFinder.nodeArrayToString();
		// These two Strings should be equal, if not, the PathFinder.solveMaze failed.
		assertEquals(ourBigMazeSol, correctBigMazeSol);
		// Repeat for multiple maze files. 
		
		// Classic Maze.
		PathFinder.solveMaze("classic.txt", "classicMazeSolution.txt");
		String ourClassicMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("classicSol.txt"));
		String correctClassicMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourClassicMazeSol, correctClassicMazeSol);
		
		// Medium Maze
		PathFinder.solveMaze("mediumMaze.txt", "mediumMazeSolution.txt");
		String ourMediumMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("mediumMazeSol.txt"));
		String correctMediumMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourMediumMazeSol, correctMediumMazeSol);
		
		// Random Maze
		PathFinder.solveMaze("randomMaze.txt", "randomMazeSolution.txt");
		String ourRandomMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("randomMazeSol.txt"));
		String correctRandomMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourRandomMazeSol, correctRandomMazeSol);
		
		// Straight Maze
		PathFinder.solveMaze("straight.txt", "straightMazeSolution.txt");
		String ourStraightMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("straightSol.txt"));
		String correctStraightMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourStraightMazeSol, correctStraightMazeSol);
		
		// Tiny Maze
		PathFinder.solveMaze("tinyMaze.txt", "tinyMazeSolution.txt");
		String ourTinyMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("tinyMazeSol.txt"));
		String correctTinyMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourTinyMazeSol, correctTinyMazeSol);
		
		// Tiny Open Maze
		PathFinder.solveMaze("tinyOpen.txt", "tinyOpenMazeSolution.txt");
		String ourTinyOpenMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("tinyOpenSol.txt"));
		String correctTinyOpenMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourTinyOpenMazeSol, correctTinyOpenMazeSol);
		
		// Turn Maze
		PathFinder.solveMaze("turn.txt", "turnMazeSolution.txt");
		String ourTurnMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("turnSol.txt"));
		String correctTurnMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourTurnMazeSol, correctTurnMazeSol);
		
		// Unsolvable Maze
		PathFinder.solveMaze("unsolvable.txt", "unsolvableMazeSolution.txt");
		String ourUnsolvableMazeSol = PathFinder.nodeArrayToString();
		PathFinder.readIn(new File("unsolvableSol.txt"));
		String correctUnsolvableMazeSol = PathFinder.nodeArrayToString();
		assertEquals(ourUnsolvableMazeSol, correctUnsolvableMazeSol);
	}
	
	@Test (expected = FileNotFoundException.class)
	public void testFileNotFound() throws FileNotFoundException{
		// Try to solve a maze that doesn't exist
		PathFinder.solveMaze("doesNotExist.txt", "doesNotExistSolution.txt");
		// This should throw a File Not Found Exception.
	}

}
