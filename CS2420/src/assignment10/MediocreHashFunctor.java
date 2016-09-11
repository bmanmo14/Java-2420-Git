package assignment10;

/**
 * This MediocreHashFunctor implements HashFunctor and computes a hash value based on each character
 * in a String word. A String is passed into the functor and the hash value is computed by adding up the 
 * integer values of each character in the word. This should be a decent functor, not great, because most
 * words will have a different hash value, unless two words contain the exact same letters, then the hashes will
 * be the same.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class MediocreHashFunctor implements HashFunctor {

	@Override
	public int hash(String item) {
		int hash = 0;
        for (int i = 0; i < item.length(); i++) {
			hash += item.charAt(i);
        }
		return Math.abs(hash);
	}

}
