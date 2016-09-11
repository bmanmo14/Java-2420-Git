package assignment10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestTimeChain {

	public static void main(String[] args) {
		int sizeSet = 10;
		try (FileWriter mediocreTime = new FileWriter("MediocreChainTime.txt")) {
			try (FileWriter goodTime = new FileWriter("GoodChainTime.txt")) {
				try (FileWriter badTime = new FileWriter("BadChainTime.txt")) {
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
						long totalMediocreTime = 0;
						long totalBadTime = 0;
						long totalGoodTime = 0;
						ChainingHashTable goodFunctor = new ChainingHashTable(sizeSet, new GoodHashFunctor());
						ChainingHashTable badFunctor = new ChainingHashTable(sizeSet, new BadHashFunctor());
						ChainingHashTable mediocreFunctor = new ChainingHashTable(sizeSet, new MediocreHashFunctor());
						
						for(int i = 0; i < sizeSet; i++){
							String wordToAdd = words.get(i);
							long startRun = System.nanoTime();
							badFunctor.add(wordToAdd);
							long stopRun = System.nanoTime();
							totalBadTime += stopRun - startRun;
						}
						for(int i = 0; i < sizeSet; i++){
							String wordToAdd = words.get(i);
							long startRun = System.nanoTime();
							mediocreFunctor.add(wordToAdd);
							long stopRun = System.nanoTime();
							totalMediocreTime += stopRun - startRun;
						}
						for(int i = 0; i < sizeSet; i++){
							String wordToAdd = words.get(i);
							long startRun = System.nanoTime();
							goodFunctor.add(wordToAdd);
							long stopRun = System.nanoTime();
							totalGoodTime += stopRun - startRun;
						}
						
						double averageGoodRuntime = totalGoodTime / (double)sizeSet;
						double averageBadRuntime = totalBadTime / (double)sizeSet;
						double averageMediocreRuntime = totalMediocreTime / (double)sizeSet;
						
						// Records the final data to the appropriate files.
						goodTime.write(averageGoodRuntime + "\n");
						mediocreTime.write(averageMediocreRuntime + "\n");
						badTime.write(averageBadRuntime + "\n");
						// Increments the number of items to be added in the next experiment.
						sizeSet+= 10;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		} catch (IOException d) {
			d.printStackTrace();
		}
	}
}
