package assignment12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This class just tests the efficiency of our Huffman Algorithm by creating three different text files
 * and adding different combinations of characters to these text files.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class HuffmanEfficiency {

	public static void main(String[] args) {
		HuffmanTree test = new HuffmanTree();
		int sizeSet = 100;
		try (FileWriter outputText = new FileWriter("CompressionResults.txt")) {
			File textFile01 = new File("goodTextFile.txt");
			File textFile02 = new File("mediocreTextFile.txt");
			File textFile03 = new File("randomTextFile.txt");
			
			File compressedFile01 = new File("compressedGood.txt");
			File compressedFile02 = new File("compressedMediocre.txt");
			File compressedFile03 = new File("compressedRandom.txt");
		for(int i = 0; i < 11; i++) {
			try (FileWriter allCharTextFile = new FileWriter("mediocreTextFile.txt")) {
				try (FileWriter randomTextFile = new FileWriter("randomTextFile.txt")) {
					try (FileWriter textFile = new FileWriter("goodTextFile.txt")) {
						
						for(int j = 1; j <= sizeSet; j++){
							for(int k = 1; k <= sizeSet; k++){
								textFile.write((char)97);
							}
							textFile.write("\n");
						}
						Random rand = new Random();
					
					for(int k = 1; k <= sizeSet; k++){
						for(int j = 1; j <= sizeSet; j++){
							randomTextFile.write((char)(32 + rand.nextInt(94)));
						}
						randomTextFile.write("\n");
					}
					
					for(int k = 1; k <= sizeSet; k++){
						for(int j = 1; j <= sizeSet; j++){
							allCharTextFile.write((char)(97+ rand.nextInt(13)));
						}
						allCharTextFile.write("\n");
					}
					
					test.compressFile(textFile01, compressedFile01);
					test.compressFile(textFile02, compressedFile02);
					test.compressFile(textFile03, compressedFile03);
					
						outputText.write(sizeSet + "\t" + textFile01.length() + "\t" + compressedFile01.length() +
								"\t" + compressedFile02.length() +
								"\t" + compressedFile03.length() + "\n");
					sizeSet+= 25;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}
