/**
 * MatrixTester.java
 * 
 * This program creates multiple different matrices and tests the functions created in the
 * Matrix.java file. The program first creates five different matrices then uses/tests the 
 * times, plus, and equals functions contained in the Matrix.java file.
 * 
 * Author: Brandon Mouser, mouser
 * Last Edited: January 19, 2016
 */

package assignment01;

public class MatrixTester {
	public static void main(String[] args) {
		Matrix M1 = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } });
		Matrix M2 = new Matrix(new int[][] { { 4, 5 }, { 3, 2 }, { 1, 1 } });
		Matrix M3 = new Matrix(new int[][] { { 1, 2 }, { 3, 4 } });
		Matrix M4 = new Matrix(new int[][] { { 5, 6 }, { 7, 8 } });
		Matrix M5 = new Matrix(new int[][] { { 4, 5, 6 }, { 7, 8, 9 } });

		System.out.println("Welcome! This program tests the functions made in the Matrix.java file.");
		System.out.println("First, we'll start with five Matrices. Then we test the functions on them.\n");
		System.out.println("Matrix M1 is:\n" + M1);
		System.out.println("Matrix M2 is:\n" + M2);
		System.out.println("Matrix M3 is:\n" + M3);
		System.out.println("Matrix M4 is:\n" + M4);
		System.out.println("Matrix M5 is:\n" + M5);
		System.out.println("Each of these matrices uses the .toString() method to display the matrix.");
		System.out.println("Next, let's use these five matrices with the other functions in the Matrix.java file");
		System.out.println("to see if the functions are correct.");
		System.out.println("First let's test the .times functions.\n");
		System.out.println("M3 * M1 equals:\n" + M3.times(M1));
		System.out.println("M4 * M5 equals:\n" + M4.times(M5));
		System.out.println("M2 * M3 equals:\n" + M2.times(M3));
		System.out.println("M1 * M2 equals:\n" + M1.times(M2));
		System.out.println("Now let's test the .plus function. \n");
		System.out.println("M3 + M4 equals:\n" + M3.plus(M4));
		System.out.println("M1 + M5 equals:\n" + M1.plus(M5));
		System.out.println("Finally, let's test the .equals function.");
		System.out.println("If two matrices are equal, the function returns true, otherwise");
		System.out.println("the function returns false.");
		System.out.println("Let's create a new Matrix called M6 that is the matrix of M3 * M1. \n");
		Matrix M6 = new Matrix(new int[][] { { 5, 12, 15 }, { 11, 26, 33 } });
		System.out.println("Matrix M6 is: \n" + M6);
		System.out.println("Now if we were to call M6.equals(M3.times(M1)),");
		System.out.println("the function should return true. Let's see... \n");
		System.out.println(M6.equals(M3.times(M1)) + "\n");
		System.out.println("Hooray! The two matrices do equal each other! That is...");
		System.out.println("This matrix, M6, \n" + M6);
		System.out.println("does equal M3.times(M1).\n" + M3.times(M1));
		System.out.println("Let's try the .equals function again.");
		System.out.println("Let's create a new Matrix called M7 that is the matrix of M1 * M2. \n");
		Matrix M7 = new Matrix(new int[][] { { 13, 12 }, { 29, 26 } });
		System.out.println("Matrix M7 is: \n" + M7);
		System.out.println("Now if we were to call M7.equals(M1.times(M2)),");
		System.out.println("the function should return true. Let's see... \n");
		System.out.println(M7.equals(M1.times(M2)) + "\n");
		System.out.println("Once again, the two matrices do equal each other! That is...");
		System.out.println("This matrix, M7, \n" + M7);
		System.out.println("does equal M1.times(M2).\n" + M1.times(M2));
		System.out.println("That's all for now! See you later!");
	}
}
