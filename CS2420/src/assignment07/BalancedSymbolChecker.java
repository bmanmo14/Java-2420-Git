package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched. If not, the program will return an error message
 * depending on what went wrong. If any brackets don't match, the program returns an error message
 * with the bracket that didn't match, the location of this bracket, and what the program expected to see.
 * This program also checks to make sure comments are close off correctly and that there are no extra or missing brackets 
 * at the end of the file. 
 * 
 * @author Brandon Mouser and David Ord
 */
public class BalancedSymbolChecker {

	/**
	 * This function reads in a file (Most likely some sort of Java file) and searches the file 
	 * to make sure that all brackets match throughout the file. This method also makes sure there are 
	 * no unfinished comments in the file. If everything matches in the file, the method returns
	 * "No errors found. All symbols match." Otherwise the method tells the user what went wrong and where.
	 * Throws FileNotFoundException if the file does not exist.
	 * 
	 * @param String filename -- The file that is being opened and validated.
	 * @return String -- A message telling if the file matches or not. If not, the function returns what went wrong.
	 * @throws FileNotFoundException -- Throws FileNotFoundException if the file does not exist.
	 */
	public String checkFile(String filename) throws FileNotFoundException {
		File bookFile = new File(filename);
		Scanner s = null;

		try {
			s = new Scanner(bookFile);
		} 
		catch (FileNotFoundException e) {
			throw e;
		}
		
		LinkedListStack<Character> words = new LinkedListStack<Character>();
		int row = 0;
		
		while(s.hasNext()) {
			s.useDelimiter(Pattern.compile("\n"));
			String wordsFile = s.next();
			int column = 1;
			for (int i = 0; i < wordsFile.length(); i++) {
				if (wordsFile.contains("/*")) {
					if (wordsFile.contains("*/")) {
						i = wordsFile.lastIndexOf("*/");
						break;
					} else {
						while (s.hasNext()) {
							wordsFile = s.next();
							if (wordsFile.contains("*/")) {
								i = wordsFile.lastIndexOf("*/");
								break;
							}
						}
						if (!wordsFile.contains("*/")) {
							s.close();
							return unfinishedComment();
						}
					}
					i = wordsFile.lastIndexOf("*/");
					break;
				} else if (wordsFile.charAt(i) == '/'&& wordsFile.charAt(i + 1) == '/') {
					break;
				}
				if (wordsFile.charAt(i) == '\'') {
					int index = 1;
					while (s.hasNext()) {
						if (wordsFile.charAt(i + index) == '\'') {
							i += index;
							break;
						} else {
							index++;
						}
					}
				}
				if (wordsFile.charAt(i) == '\"') {
					int index = i;
					i = wordsFile.lastIndexOf('\"');
					column += (i - index);
				}
				if (wordsFile.charAt(i) == '{' || wordsFile.charAt(i) == '[' || wordsFile.charAt(i) == '(') {
					words.push(wordsFile.charAt(i));
				}
				if (wordsFile.charAt(i) == '}' || wordsFile.charAt(i) == ']'|| wordsFile.charAt(i) == ')') {
					if (words.size() == 0 || words.isEmpty()) {
						column = 0;
						column++;
						row++;
						s.close();
						return unmatchedSymbol(row, column,wordsFile.charAt(i), ' ');
					}
					char popped = words.pop();
					if (popped == '[' && wordsFile.charAt(i) != ']') {
						row++;
						s.close();
						return unmatchedSymbol(row, column,wordsFile.charAt(i), ']');
					}
					if (popped == '{' && wordsFile.charAt(i) != '}') {
						row++;
						s.close();
						return unmatchedSymbol(row, column,wordsFile.charAt(i), '}');
					}
					if (popped == '(' && wordsFile.charAt(i) != ')') {
						row++;
						s.close();
						return unmatchedSymbol(row, column,wordsFile.charAt(i), ')');
					}
				}
				column++;
			}
			if (s.delimiter() != null) {
				row++;
			}
		}
		if (!s.hasNext()) {
			if (words.size() != 0) {
				char popped = words.pop();
				if (popped == '[') {
					s.close();
					return unmatchedSymbolAtEOF(']');
				}
				if (popped == '{') {
					s.close();
					return unmatchedSymbolAtEOF('}');
				}
				if (popped == '(') {
					s.close();
					return unmatchedSymbolAtEOF(')');
				}
			}
		}
		s.close();
		return allSymbolsMatch();
	}
	
	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 * 
	 * @param int lineNumber -- Row where the error occurred.
	 * 		  int colNumber -- Column where the error occurred.
	 *		  char symbolRead -- The incorrect symbol that was read in by the file
	 *		  char symbolExpected -- The symbol that should have been there.
	 *
	 *@return String -- An error message telling what went wrong in the file.
	 */
	private String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 * 
	 * @param char symbolExpected -- The expected symbol at the end of the file.
	 * 
	 * @return String -- An error message saying there is at Unmatched Symbol at the end of the file
	 * 					 and what the symbol should be.
	 */
	private String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 * 
	 * @return String -- An error message saying that there is an unfinished comment in the file.
	 */
	private String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 * 
	 * @return String -- A message saying that all symbols match.
	 */
	private String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}