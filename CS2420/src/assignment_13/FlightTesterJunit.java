package assignment_13;

import org.junit.Test;

public class FlightTesterJunit {

	
	/**
	 *  This test attempts to find a path to an airport that does not exist within the file
	 * Then attempts to find a path starting at an airport that does not exist.
	 * Both Paths should be empty because no such path exists.
	 */
	@Test
	public void TestEdgeCaseOne(){
		System.out.println("TEST-1");
		System.out.println("------");
		NetworkGraph test = null;
		try {
			test = new NetworkGraph("testfile.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BestPath testPath = test.getBestPath("NAH", "SLC", FlightCriteria.DISTANCE);
		System.out.println(testPath.toString());
		BestPath testPath2 = test.getBestPath("SLC", "NAH", FlightCriteria.DISTANCE);
		System.out.println(testPath2.toString());
		System.out.println();
	}
	/**
	 * This test ensures that the items within the Network Graph are being reset, two calls to the same path 
	 * should result in the same path.
	 */
	@Test
	public void TestEdgeCaseTwo() {
		System.out.println("TEST-2");
		System.out.println("------");
		NetworkGraph test = null;
		try {
			test = new NetworkGraph("testfile.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BestPath testPath = test.getBestPath("FGL", "ZLN", FlightCriteria.DISTANCE);
		System.out.println(testPath.toString());
		BestPath testPath2 = test.getBestPath("FGL", "ZLN", FlightCriteria.DISTANCE);
		System.out.println(testPath2.toString());
		System.out.println();
	}
	

	/** This test ensures that the method BestPaht will return  he shortest path in regards to the criteria passed in.
	 *  In order to test this we manually calculated the value of the shortest distance - time and compared them to the 
	 *  values returned in this test. I also manually added a flight that went directly from the start port to the goal 
	 *  port. In this flight I made one variable (canceled), smaller than all other flight paths and the remaining 
	 *  variables very large. The function passes this test because even when there is a path that only has two airports,
	 *  the algorithm correctly identifies that the path with three airports is still shorter for all variables EXCEPT
	 *  the canceled variable.
	 * 
	 */
	@Test
	public void TestCriteria(){
		System.out.println("TEST-3");
		System.out.println("------");
		NetworkGraph test = null;
		try {
			test = new NetworkGraph("testfile.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//BestPath testPath = test.getBestPath("FGL", "ZLN", FlightCriteria.DISTANCE);
		BestPath testPath2 = test.getBestPath("FGL", "ZLN", FlightCriteria.CANCELED);
		BestPath testPath3 = test.getBestPath("FGL", "ZLN", FlightCriteria.COST);
		BestPath testPath4 = test.getBestPath("FGL", "ZLN", FlightCriteria.DELAY);
		BestPath testPath5 = test.getBestPath("FGL", "ZLN", FlightCriteria.TIME);
		//System.out.println(testPath.toString());
		System.out.println(testPath2.toString());
		System.out.println(testPath3.toString());
		System.out.println(testPath4.toString());
		System.out.println(testPath5.toString());
		System.out.println();
	}
	
	
	@Test
	public void TestCriteriaLarge(){
		System.out.println("TEST-4");
		System.out.println("------");
		NetworkGraph test = null;
		try {
			test = new NetworkGraph("flights-2015-q3.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Returns the shortest distance path of flights from MOB to ACV
		// Solution: a path of ['MOB', 'DFW', 'SFO', 'ACV'] and distance of 2253
		BestPath shortestDistancePath = test.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
		System.out.println(shortestDistancePath.toString());

		// Returns the shortest distance path of flights from SFO to DWF when
		// flying with DL
		// Solution: a path of ['SFO', 'SLC', 'DFW'] and distance of 1588
		BestPath shortestDistancePath2 = test.getBestPath("MOB", "ACV", FlightCriteria.CANCELED);
		System.out.println(shortestDistancePath2.toString());

		// Returns the shortest flight time path from MOB to SLC
		// Solution: a path of ['MOB', 'DFW', 'SLC'] and time of ~269.25
		BestPath shortestTimePath = test.getBestPath("MOB", "SLC", FlightCriteria.TIME);
		System.out.println(shortestTimePath.toString());

		// Returns the fiscally cheapest path of flights from LAS to LAX
		// Solution: a path of ['LAS', 'LAX'] and cost of ~138.39
		BestPath cheapestPath = test.getBestPath("LAS", "LAX", FlightCriteria.COST);
		System.out.println(cheapestPath.toString());
		System.out.println();
	}
	
	@Test
	/** This test will ensure that the algorithm correctly identifies the shortest path to the goal given the constraint
	 * of which airliner to fly on. With the same test file used above, we manually added two new flights that go 
	 * directly from the start port to the goal port, (the shortest amount of nodes). We made both flights have values
	 * for all criteria variables that were much larger than the other flights on the normal airlines. The second 
	 * flight we added was twice as big as the first meaning that between the two flights on that airline there was a clear
	 * choice for which was better. The test passes because it correctly identified the two flights on the "NEW" airline, 
	 * (evident that the values for canceled and delay were averaged with the larger flight and none of the other normal 
	 * flights), and that the values that were not average belonged to the smaller flight on the new airline.
	 *  * 
	 */
	public void testCriteriaCarrier(){
		System.out.println("TEST-5");
		System.out.println("------");
		NetworkGraph test = null;
		try {
			test = new NetworkGraph("testfile.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BestPath testPath = test.getBestPath("FGL", "ZLN", FlightCriteria.DISTANCE, "NEW");
		BestPath testPath2 = test.getBestPath("FGL", "ZLN", FlightCriteria.CANCELED, "NEW") ;
		BestPath testPath3 = test.getBestPath("FGL", "ZLN", FlightCriteria.COST, "NEW");
		BestPath testPath4 = test.getBestPath("FGL", "ZLN", FlightCriteria.DELAY, "NEW");
		BestPath testPath5 = test.getBestPath("FGL", "ZLN", FlightCriteria.TIME, "NEW");
		System.out.println(testPath.toString());
		System.out.println(testPath2.toString());
		System.out.println(testPath3.toString());
		System.out.println(testPath4.toString());
		System.out.println(testPath5.toString());
		System.out.println();
	}
	
	

}
