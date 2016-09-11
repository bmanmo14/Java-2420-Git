/**
 * Matrix.java
 * 
 * This is a java class that creates and implements a Matrix object.
 * The class first creates a Matrix, then implements a toString method, equals method,
 * plus method, and times method. Each of these methods does something different and is 
 * used in the MatrixTester.java file.
 * 
 * Author: Brandon Mouser, mouser
 * Last Edited: January 19, 2016
 */

package assignment01;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];

	/**
	 * This is the default constructor of the Matrix. The constructor takes in
	 * the dimensions/values of the Matrix that the user creates.
	 * 
	 * @param int data[][] -- Either the actual values or the size of the Matrix
	 *        that is being created.
	 */
	public Matrix(int data[][]) {
		numRows = data.length; // d.length is the number of 1D arrays in the 2D array
		if (numRows == 0) {
			numColumns = 0;
		} 
		else {
			numColumns = data[0].length; // d[0] is the first 1D array
		}
		this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}

	/**
	 * This function determines if two Matrices are equal to each other. If the
	 * two Matrices are equal, the function returns true. If the Matrices do not
	 * equal each other, or the user passes in an object that is not a Matrix,
	 * the function returns false.
	 * 
	 * @param Object
	 *            other -- The Object/Matrix that is being compared to the
	 *            original Matrix.
	 * 
	 * @return boolean -- If the Matrices equal each other, return true. Else
	 *         return false.
	 */
	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix matrix = (Matrix) other; // if the above was not true, we know
										// it's safe to treat 'o' as a Matrix
		if (matrix.numRows == numRows && matrix.numColumns == numColumns) {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numColumns; j++) {
					if (matrix.data[i][j] == data[i][j]) {
						return true;
					} 
					else {
						return false;
					}
				}
			}
		}
		return false;
	}

	/**
	 * This function is a basic toString method for a Matrix. It creates a user
	 * friendly string that represents what a Matrix would look like.
	 * 
	 * @return String -- The string of the Matrix.
	 */
	@Override
	public String toString() {
		String matrice = "";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				matrice += data[i][j] + " ";
			}
			matrice += "\n";
		}
		return matrice;
	}

	/**
	 * This function multiplies two Matrices together if the first Matrix has
	 * the same number of columns as the second Matrix has rows. If the two
	 * Matrices can be multiplied together, a new Matrix is created that is the
	 * two Matrices multiplied together. If not, the function returns null.
	 * 
	 * @param Matrix
	 *            matrix -- The Matrix that is being multiplied to the Matrix
	 *            that called the function.
	 * 
	 * @return Matrix -- The Matrix of the two Matrices multiplied together, if
	 *         the two Matrices can be multiplied together.
	 */
	public Matrix times(Matrix matrix) {
		Matrix other = new Matrix(new int[numRows][matrix.numColumns]);
		if (matrix.numRows == numColumns) {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < matrix.numColumns; j++) {
					for (int h = 0; h < matrix.numRows; h++) {
						other.data[i][j] += data[i][h] * matrix.data[h][j];
					}
				}
			}
			return other;
		}
		return null;
	}

	/**
	 * This function adds two Matrices together if the two Matrices have the
	 * same number of rows and columns. If the Matrices can be added together,
	 * the function creates a new Matrix that is the sum of these two Matrices.
	 * If not, the function returns null.
	 * 
	 * @param Matrix
	 *            matrix -- The Matrix that is being added to the Matrix that
	 *            called the function.
	 * 
	 * @return Matrix -- A Matrix of the two Matrices added together, if they
	 *         can be added together.
	 */
	public Matrix plus(Matrix matrix) {
		Matrix other = new Matrix(new int[numRows][numColumns]);
		if (numRows == matrix.numRows && numColumns == matrix.numColumns) {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numColumns; j++) {
					other.data[i][j] = data[i][j] + matrix.data[i][j];
				}
			}
			return other;
		}
		return null;
	}
}
