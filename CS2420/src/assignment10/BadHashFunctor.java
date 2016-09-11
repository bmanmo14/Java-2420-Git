package assignment10;

/**
 * This Hash Functor generates a really bad hash by returning the length of the String
 * that was passed in.
 * 
 * @author Brandon Mouser and Kale Thompson
 */
public class BadHashFunctor implements HashFunctor {

	@Override
	public int hash(String item) {
			return item.length();
	}

}
