package assignment09;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TestPathFinder {

	public static void main(String[] args) throws FileNotFoundException {
		try (FileWriter fileOut = new FileWriter("PathFinderIncorrectTime.txt")) {
			long totalTime = 0;
		for(int i = 0; i < 10; i ++){	
			long startRun = System.nanoTime();
			PathFinder.solveMaze("bigMaze.txt", "bigMazeSolution.txt");
			long stopRun = System.nanoTime();
			totalTime += stopRun - startRun;
		}
		long averageRuntime = totalTime;
		fileOut.write(averageRuntime + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
