package assignment10;

public class QuadProbeTester {
	public static void main(String[] args) {
		QuadProbeHashTable test = new QuadProbeHashTable(5, new GoodHashFunctor());
		System.out.println(test.add("hello"));
		System.out.println(test.add("whats"));
		System.out.println(test.add("jelly"));
		System.out.println(test.add("grape"));
		System.out.println(test.add("hi"));
		System.out.println(test.add("HI"));
		System.out.println(test.add("weird"));
		System.out.println(test.size());
		System.out.println(test.contains("hi"));
		
		MYChainingHashTable testChain = new MYChainingHashTable(7, new MediocreHashFunctor());
		System.out.println(testChain.add("hey"));
		System.out.println(testChain.contains("hey"));
		System.out.println(testChain.add("wow"));
		System.out.println(testChain.contains("wow"));
		System.out.println(testChain.size());
		System.out.println(testChain.add("wow"));
	}
}
