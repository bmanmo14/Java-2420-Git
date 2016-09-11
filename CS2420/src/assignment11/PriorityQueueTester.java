package assignment11;

public class PriorityQueueTester {

	public static void main(String[] args) {
		PriorityQueue<Integer> test = new PriorityQueue<Integer>();
		
		for(int i = 10; i > 0; i--){
			test.add(i);
		}
		//test.add(0);
		System.out.println(test.deleteMin());
		//System.out.println(test.deleteMin());
		//test.add(1);
		test.generateDotFile("testPriorityQueue.dot");
	}

}
