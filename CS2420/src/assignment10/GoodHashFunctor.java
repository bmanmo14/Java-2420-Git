package assignment10;

/**
 * This GoodHashFunctor implements HashFunctor and returns a hash that is unique for the String that
 * was passed in. The hash is based on the Bernstein Hash and uses a bitwise XOR with the hash and each 
 * character in the String. This Number is then multiplied by 5381 and that continues until every character 
 * in the String has been visited. The number 5381 is used for a few different reasons. Firstly, the algorithm
 * that this functor is based off of is a well known algorithm, and it uses the number 33. I tested the 
 * number 33 as well as many prime numbers to see which one performed better. Then, while researching the
 * Bernstein Hash algorithm, I came across a post that had "Magic Number" 5381. The post explained that 
 * 5381 is the optimal number for hash functions. When I tested this number, it did run faster than the 
 * other numbers I had chose before, so I decided to keep this number and use it in this functor.
 * Using this algorithm, the hash created should be unique for every string that is passed in.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class GoodHashFunctor implements HashFunctor {

	@Override
	public int hash(String item) {
		int hash = 0;
		for (int i = 0; i < item.length(); i++) {
			hash = 5381 * hash^item.charAt(i);
		}
		return Math.abs(hash);
	}
}
