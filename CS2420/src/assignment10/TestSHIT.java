package assignment10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSHIT {

	public static void main(String[] args) {
		int sizeSet = 10;
		try (FileWriter quadTiming = new FileWriter("QuadTiming.txt")) {
			try (FileWriter chainingTiming = new FileWriter("ChainingTiming.txt")) {
			for (int exp = 0; exp < 100; exp++) {
			File bookFile = new File("dictionary.txt");
			Scanner s = null;
			try {
				s = new Scanner(bookFile);
			} 
			catch (FileNotFoundException e) {
				throw e;
			}
			ArrayList<String> words = new ArrayList<String>();
			while(s.hasNext()){
				for(int i = 0; i< sizeSet; i++){
					words.add(s.next());
				}
				break;
			}
			s.close();
				// Initializes the value of all timing variables.
				//long totalQuadProbe = 0;
				//long totalChaining = 0;

				QuadProbeHashTable quad = new QuadProbeHashTable(sizeSet, new GoodHashFunctor());
				ChainingHashTable chaining = new ChainingHashTable(sizeSet, new GoodHashFunctor());
				/*
				for(int i = 0; i < sizeSet; i++){
					String wordToAdd = words.get(i);
					long startRun = System.nanoTime();
					chaining.add(wordToAdd);
					long stopRun = System.nanoTime();
					totalChaining += stopRun - startRun;
				}
				for(int i = 0; i < sizeSet; i++){
					String wordToAdd = words.get(i);
					long startRun = System.nanoTime();
					quad.add(wordToAdd);
					long stopRun = System.nanoTime();
					totalQuadProbe += stopRun - startRun;
				}
				
				double averageChaining = totalChaining / (double)sizeSet;
				double averageQuad = totalQuadProbe / (double)sizeSet;
				*/
				
				for(int i = 0; i < sizeSet; i++){
					String wordToAdd = words.get(i);
					chaining.add(wordToAdd);
				}
				for(int i = 0; i < sizeSet; i++){
					String wordToAdd = words.get(i);
					quad.add(wordToAdd);
				}
				quadTiming.write(sizeSet + "\t" + quad.collisions + "\n");
				chainingTiming.write(sizeSet + "\t" + chaining.collisions + "\n");
				sizeSet+= 10;
		}
} catch (IOException e) {
	e.printStackTrace();
}

	} catch (IOException e1) {
		e1.printStackTrace();
	}
}
}

