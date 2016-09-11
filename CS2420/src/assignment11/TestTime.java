package assignment11;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestTime {

	public static void main(String[] args) {
			int sizeSet = 1000;
			try (FileWriter priorityQueue = new FileWriter("PriorityQueueTime.txt")) {
				for (int exp = 0; exp < 100; exp++) {
							long totalRuntime = 0;
							Random rand = new Random();
							PriorityQueue<Integer> test = new PriorityQueue<Integer>();
							for(int i = 0; i <= sizeSet; i++){
								long startRun = System.nanoTime();
								test.add(rand.nextInt(sizeSet));
								long stopRun = System.nanoTime();
								totalRuntime += stopRun - startRun;
							}
							
							double averageRuntime = totalRuntime / (double)sizeSet;

							priorityQueue.write(sizeSet + "\t" + averageRuntime + "\n");
							sizeSet+= 1000;
					}
			} catch (IOException d) {
				d.printStackTrace();
			}
		}

	}

