package assign8;

/**
 * This program creates and uses Fraction objects. The Fractions that are
 * created will be: Added together, Multiplied by each other, Subtracted by each
 * other, And divided by each other.
 * 
 * @author Brandon Mouser, mouser Last updated: November 3, 2015
 */

public class Fraction {
	private long numerator;
	private long denominator;

	/**
	 * This function reduces this fraction object. It first computes the
	 * greatest common divisor (GCD) of the numerator and denominator. Then, it
	 * divides both the numerator and denominator by that GCD.
	 */
	private void reduce() {
		long gcd = numerator;
		long remainder = denominator;

		while (remainder != 0) {
			long temp = remainder;
			remainder = gcd % remainder;
			gcd = temp;
		}
		numerator /= gcd;
		denominator /= gcd;
	}

	/**
	 * Fraction default constructor
	 * 
	 * Sets the fraction to 0/1 (which is 0).
	 */
	public Fraction() {
		numerator = 0;
		denominator = 1;
	}

	/**
	 * Fraction constructor
	 * 
	 * Sets the fraction using the supplied values. A denominator of 0 is not
	 * allowed.
	 * 
	 * @param long numerator -- The Fraction numerator that is passed in.
	 * @param long denominator -- The Fraction denominator that is passed in.
	 */
	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;

		reduce();

		if (denominator < 0) {
			denominator = denominator * -1;
			numerator = numerator * -1;
		}
	}

	/**
	 * The purpose of this function is to create a string that contains a text
	 * representation of a Fraction object.
	 * 
	 * @param long numerator -- some numerator that is passed in.
	 * @param long denominator -- some denominator that is passed in.
	 * 
	 * @return -- Returns a string that is a Fraction.
	 */
	public String toString() {
		String buffer = null;
		if (denominator != 1) {
			buffer = numerator + "/" + denominator;
		}
		if (denominator == 1) {
			buffer = numerator + "";
		}
		return buffer;
	}

	/**
	 * The purpose of this function is to create a double that contains a true
	 * representation of a Fraction object.
	 * 
	 * @param long numerator -- the numerator that is passed in.
	 * @param long denominator -- the denominator that is passed in.
	 * 
	 * @return double -- The numerator divided by denominator.
	 */
	public double toDouble() {
		double buffer;
		buffer = numerator / (double) denominator;
		return buffer;
	}

	/**
	 * The purpose of this function is to add two fractions together.
	 * 
	 * @param Fraction other -- The fraction that is being added.
	 * @return Fraction -- A fraction of two fractions added together.
	 */
	public Fraction add(Fraction other) {
		long sumNumerator;
		long sumDenominator;

		sumNumerator = numerator * other.denominator + other.numerator
				* denominator;
		sumDenominator = denominator * other.denominator;

		Fraction result = new Fraction(sumNumerator, sumDenominator);

		return result;

	}

	/**
	 * The purpose of this function is to multiply two fractions together.
	 * 
	 * @param Fraction other -- The fraction that is being multiplied.
	 * @return Fraction -- A fraction of two fractions multiplied together.
	 */
	public Fraction multiply(Fraction other) {
		long productNumerator;
		long productDenominator;

		productNumerator = numerator * other.numerator;
		productDenominator = denominator * other.denominator;

		Fraction result = new Fraction(productNumerator, productDenominator);

		return result;
	}

	/**
	 * The purpose of this function is to subtract two fractions from each
	 * other.
	 * 
	 * @param Fraction other -- The fraction that is being subtracted.
	 * @return Fraction -- A fraction of two fractions subtracted from each
	 *         other.
	 */
	public Fraction subtract(Fraction other) {
		long subtractDenominator;
		long subtractNumerator;

		subtractNumerator = (numerator * other.denominator)
				- (other.numerator * denominator);
		subtractDenominator = denominator * other.denominator;

		Fraction result = new Fraction(subtractNumerator, subtractDenominator);

		return result;
	}

	/**
	 * The purpose of this function is to divide two fractions by each other.
	 * 
	 * @param Fraction other -- The fraction that is being divided.
	 * @return Fraction -- A fraction of two fractions divided by each other.
	 */
	public Fraction division(Fraction other) {
		long divideDenominator;
		long divideNumerator;

		divideNumerator = numerator * other.denominator;
		divideDenominator = denominator * other.numerator;

		Fraction result = new Fraction(divideNumerator, divideDenominator);

		return result;
	}

	public static void main(String[] args) {
		System.out.println("Hello, working...");
		Fraction f1 = new Fraction(1, 8);
		Fraction f2 = new Fraction(1, 6);
		Fraction f3 = new Fraction(-5, -7);
		Fraction f4 = new Fraction(6, -9);
		Fraction f5 = new Fraction(-7, -9);

		System.out.println("Fraction f1 is " + f1.toString());
		System.out.println("Fraction f2 is " + f2.toString());
		System.out.println("Fraction f3 is " + f3.toString());
		System.out.println("Fraction f4 is " + f4.toString());
		System.out.println("Fraction f5 is " + f5.toString());

		Fraction f6 = new Fraction(1, 1);

		f6 = f1.add(f2);
		System.out.println(f1.toString() + " plus " + f2.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble() + ".");
		f6 = f3.add(f4);
		System.out.println(f3.toString() + " plus " + f4.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());

		f6 = f5.subtract(f1);
		System.out.println(f5.toString() + " minus " + f1.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());
		f6 = f4.subtract(f2);
		System.out.println(f4.toString() + " minus  " + f2.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());

		f6 = f2.multiply(f3);
		System.out.println(f2.toString() + " multiplied by " + f3.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());
		f6 = f1.multiply(f5);
		System.out.println(f1.toString() + " multiplied by " + f5.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());

		f6 = f3.division(f2);
		System.out.println(f3.toString() + " divided by " + f2.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());
		f6 = f5.division(f4);
		System.out.println(f5.toString() + " divided by " + f4.toString()
				+ " equals " + f6.toString() + " or " + f6.toDouble());
	}

}
