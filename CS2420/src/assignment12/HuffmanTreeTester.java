package assignment12;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * This JUnit test file tests the compression and decompression algorithms in the HuffmanTree class. 
 * This test file tests five different .txt files with five random movie quotes in them. The files are first compressed,
 * the decompressed to a new .txt file. These two files are then read in by a Scanner and added to a String element.
 * Then we check to see if the original text file and the new decompressed text file are the same. If not, an error
 * will appear. This JUnit test case uses the 5 HuffmanTest text files that were included in the zip file with this program.
 * 
 * @author Brandon Mouser and Kale Thompson
 */
public class HuffmanTreeTester {

	public String fileOne;
	public String fileTwo;
	public String fileThree;
	public String fileFour;
	public String fileFive;
	
	public String decompressedOne;
	public String decompressedTwo;
	public String decompressedThree;
	public String decompressedFour;
	public String decompressedFive;
	
	/**
	 * This test just compresses and decompresses the text files to be used with the next test case.
	 */
	@Test
	@Before
	public void testHuffman() {
		
		fileOne = "HuffmanTest1.txt";
		fileTwo = "HuffmanTest2.txt";
		fileThree = "HuffmanTest3.txt";
		fileFour = "HuffmanTest4.txt";
		fileFive = "HuffmanTest5.txt";
		
		String outFileOne = "outHuffmanTest1.txt";
		String outFileTwo = "outHuffmanTest2.txt";
		String outFileThree = "outHuffmanTest3.txt";
		String outFileFour = "outHuffmanTest4.txt";
		String outFileFive = "outHuffmanTest5.txt";
		
		decompressedOne = "decompressedTest1.txt";
		decompressedTwo = "decompressedTest2.txt";
		decompressedThree = "decompressedTest3.txt";
		decompressedFour = "decompressedTest4.txt";
		decompressedFive = "decompressedTest5.txt";
		
		HuffmanTree t = new HuffmanTree();
	    t.compressFile(new File(fileOne), new File(outFileOne));
	    t.compressFile(new File(fileTwo), new File(outFileTwo));
	    t.compressFile(new File(fileThree), new File(outFileThree));
	    t.compressFile(new File(fileFour), new File(outFileFour));
	    t.compressFile(new File(fileFive), new File(outFileFive));
	    
	    t.decompressFile(new File(outFileOne), new File(decompressedOne));
	    t.decompressFile(new File(outFileTwo), new File(decompressedTwo));
	    t.decompressFile(new File(outFileThree), new File(decompressedThree));
	    t.decompressFile(new File(outFileFour), new File(decompressedFour));
	    t.decompressFile(new File(outFileFive), new File(decompressedFive));
	}
	
	/**
	 * This test reads in the two text files, the original one and the new decompressed one and
	 * tests to make sure they are the same.
	 */
	@Test
	public void testHuffmanAlgorithm(){
		
		// Create new String objects to store the values of the original text file and the decompressed text file.
		String originalFileOne = "";
		String originalFileTwo = "";
		String originalFileThree = "";
		String originalFileFour = "";
		String originalFileFive = "";
		
		String newFileOne = "";
		String newFileTwo = "";
		String newFileThree = "";
		String newFileFour = "";
		String newFileFive = "";
		
		try{
			// Create new Scanners to read in all of the words from both text files.
			FileReader inFileReaderOne = new FileReader(fileOne);
			FileReader inFileReaderTwo = new FileReader(fileTwo);
			FileReader inFileReaderThree = new FileReader(fileThree);
			FileReader inFileReaderFour = new FileReader(fileFour);
			FileReader inFileReaderFive = new FileReader(fileFive);

			FileReader outFileReaderOne = new FileReader(decompressedOne);
			FileReader outFileReaderTwo = new FileReader(decompressedTwo);
			FileReader outFileReaderThree = new FileReader(decompressedThree);
			FileReader outFileReaderFour = new FileReader(decompressedFour);
			FileReader outFileReaderFive = new FileReader(decompressedFive);
			
			Scanner inScannerOne = new Scanner(inFileReaderOne);
			Scanner inScannerTwo = new Scanner(inFileReaderTwo);
			Scanner inScannerThree = new Scanner(inFileReaderThree);
			Scanner inScannerFour = new Scanner(inFileReaderFour);
			Scanner inScannerFive = new Scanner(inFileReaderFive);
			
			Scanner outScannerOne = new Scanner(outFileReaderOne);
			Scanner outScannerTwo = new Scanner(outFileReaderTwo);
			Scanner outScannerThree = new Scanner(outFileReaderThree);
			Scanner outScannerFour = new Scanner(outFileReaderFour);
			Scanner outScannerFive = new Scanner(outFileReaderFive);
			
			// Add these words to the String objects created above.
			while(inScannerOne.hasNext()){
				originalFileOne += inScannerOne.nextLine();
			}
			while(inScannerTwo.hasNext()){
				originalFileTwo += inScannerTwo.nextLine();
			}
			while(inScannerThree.hasNext()){
				originalFileThree += inScannerThree.nextLine();
			}
			while(inScannerFour.hasNext()){
				originalFileFour += inScannerFour.nextLine();
			}
			while(inScannerFive.hasNext()){
				originalFileFive += inScannerFive.nextLine();
			}
			
			while(outScannerOne.hasNext()){
				newFileOne += outScannerOne.nextLine();
			}
			while(outScannerTwo.hasNext()){
				newFileTwo += outScannerTwo.nextLine();
			}
			while(outScannerThree.hasNext()){
				newFileThree += outScannerThree.nextLine();
			}
			while(outScannerFour.hasNext()){
				newFileFour += outScannerFour.nextLine();
			}
			while(outScannerFive.hasNext()){
				newFileFive += outScannerFive.nextLine();
			}
			// Close all of the scanners.
			inScannerOne.close();
			inScannerTwo.close();
			inScannerThree.close();
			inScannerFour.close();
			inScannerFive.close();
			
			outScannerOne.close();
			outScannerTwo.close();
			outScannerThree.close();
			outScannerFour.close();
			outScannerFive.close();
			
		} catch (FileNotFoundException e){
			System.out.println("File Not Found :(");
		}
		
		// Test to make sure the original and decompressed files match.
		assertEquals(originalFileOne, newFileOne);
		assertEquals(originalFileTwo, newFileTwo);
		assertEquals(originalFileThree, newFileThree);
		assertEquals(originalFileFour, newFileFour);
		assertEquals(originalFileFive, newFileFive);
	}
}
