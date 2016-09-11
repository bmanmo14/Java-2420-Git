package assignment_13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>
 * This class represents a graph of flights and airports along with specific
 * data about those flights. It is recommended to create an airport class and a
 * flight class to represent nodes and edges respectively. There are other ways
 * to accomplish this and you are free to explore those.
 * </p>
 * 
 * <p>
 * Testing will be done with different criteria for the "best" path so be sure
 * to keep all information from the given file. Also, before implementing this
 * class (or any other) draw a diagram of how each class will work in relation
 * to the others. Creating such a diagram will help avoid headache and confusion
 * later.
 * </p>
 * 
 * <p>
 * Be aware also that you are free to add any member variables or methods needed
 * to completed the task at hand
 * </p>
 * 
 * @author CS2420 Teaching Staff - Spring 2016
 */
public class NetworkGraph {
	public Airport airportOrigin;
	public Airport airportDestination;
	public Flight flights;
	public double averageFlight;
	public ArrayList<String> allAirportNames;
	public ArrayList<String> airportDestinationNames;
	public ArrayList<Airport> allAirports;
	public ArrayList<Flight> allFlights;

	/**
	 * <p>
	 * Constructs a NetworkGraph object and populates it with the information
	 * contained in the given file. See the sample files or a randomly generated
	 * one for the proper file format.
	 * </p>
	 * 
	 * <p>
	 * You will notice that in the given files there are duplicate flights with
	 * some differing information. That information should be averaged and
	 * stored properly. For example some times flights are canceled and that is
	 * represented with a 1 if it is and a 0 if it is not. When several of the
	 * same flights are reported totals should be added up and then reported as
	 * an average or a probability (value between 0-1 inclusive).
	 * </p>
	 * 
	 * @param flightInfoPath
	 *            - The path to the file containing flight data. This should be
	 *            a *.csv(comma separated value) file
	 * 
	 * @throws FileNotFoundException
	 *             The only exception that can be thrown in this assignment and
	 *             only if a file is not found.
	 */
	public NetworkGraph(String flightInfoPath) throws FileNotFoundException {
		String pattern = ",";
		String line = "";

		allFlights = new ArrayList<Flight>();
		allAirportNames = new ArrayList<String>();
		airportDestinationNames = new ArrayList<String>();
		allAirports = new ArrayList<Airport>();
		
		try {
			FileReader flight = new FileReader(flightInfoPath);
			Scanner readFlightData = new Scanner(flight);
			readFlightData.nextLine();
			while (readFlightData.hasNextLine()) {
				line = readFlightData.nextLine();
				String[] values = line.split(pattern);
				String origin = values[0];
				String destination = values[1];
				String carrier = values[2];
				
				int delayTime = Integer.parseInt(values[3]);
				int canceled = Integer.parseInt(values[4]);
				double time = Double.parseDouble(values[5]);
				int distance = Integer.parseInt(values[6]);
				double cost = Double.parseDouble(values[7]);
				
				if (allAirportNames.contains(origin)) {
					int index = allAirportNames.indexOf(origin);
					airportOrigin = allAirports.get(index);
					
					if (allAirportNames.contains(destination)) {
						int destinationIndex = allAirportNames.indexOf(destination);
						airportDestination = allAirports.get(destinationIndex);
					}
					else {
						airportDestination = new Airport(destination);
						allAirportNames.add(destination);
						allAirports.add(airportDestination);
					}
					
					flights = new Flight(airportOrigin, airportDestination);
					flights.addFlightInfo(carrier, delayTime, canceled, time, distance, cost);
					airportOrigin.addFlight(flights);
					allFlights.add(flights);
				} 
				else {
					airportOrigin = new Airport(origin);
					
					if (allAirportNames.contains(destination)) {
						int destinationIndex = allAirportNames.indexOf(destination);
						airportDestination = allAirports.get(destinationIndex);
					} 
					else {
						airportDestination = new Airport(destination);
						allAirportNames.add(destination);
						allAirports.add(airportDestination);
					}
					
					flights = new Flight(airportOrigin, airportDestination);
					flights.addFlightInfo(carrier, delayTime, canceled, time, distance, cost);
					airportOrigin.addFlight(flights);

					allFlights.add(flights);
					allAirports.add(airportOrigin);
					allAirportNames.add(origin);

				}
			}
			readFlightData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method returns a BestPath object containing information about the
	 * best way to fly to the destination from the origin. "Best" is defined by
	 * the FlightCriteria parameter <code>enum</code>. This method should throw
	 * no exceptions and simply return a BestPath object with information
	 * dictating the result. For example, if a destination or origin is not
	 * contained in this instance of NetworkGraph simply return a BestPath with
	 * no path (not a <code>null</code> path). If origin or destination are
	 * <code>null</code> return a BestPath object with null as origin or
	 * destination (which ever is <code>null</code>.
	 * 
	 * @param origin
	 *            - The starting location to find a path from. This should be a
	 *            3 character long string denoting an airport.
	 * 
	 * @param destination
	 *            - The destination location from the starting airport. Again,
	 *            this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria
	 *            - This enum dictates the definition of "best". Based on this
	 *            value a path should be generated and return.
	 * 
	 * @return - An object containing path information including origin,
	 *         destination, and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria) {
		for(int i = 0; i < allAirports.size(); i++){
			allAirports.get(i).weight = Double.POSITIVE_INFINITY;
			allAirports.get(i).visited = false;
		}
		int originIndex = 0;
		if (allAirportNames.contains(origin)) {
			originIndex = allAirportNames.indexOf(origin);
		}
		int destinationIndex = 0;
		if (allAirportNames.contains(destination)) {
			destinationIndex = allAirportNames.indexOf(destination);
		}

		Airport start = allAirports.get(originIndex);
		Airport goal = allAirports.get(destinationIndex);

		PriorityQueue<Airport> queue = new PriorityQueue<Airport>();
		LinkedList<String> path = new LinkedList<String>();

		start.setWeight(0);
		queue.add(start);
		Airport current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current.getAirport().compareTo(goal.getAirport()) == 0) {
				double finalWeight = current.getWeight();
				while (current != start) {
					path.addFirst(current.getAirport());
					current.visited = false;
					current.weight = Double.POSITIVE_INFINITY;
					current = current.getPrevious();
				}
				start.visited = false;
				start.weight = Double.POSITIVE_INFINITY;
				path.addFirst(start.getAirport());
				BestPath bestPath = new BestPath(path, finalWeight);
				return bestPath;

			}

			current.visited = true;
			Airport neighbor = current;
			ArrayList<Flight> currentFlights;
			for (int i = 0; i < current.size(); i++) {
				currentFlights = new ArrayList<Flight>();
				currentFlights = current.getOutgoingFlights();
				neighbor = currentFlights.get(i).getDestination();
				double neighborWeight = neighbor.getWeight();
				if (criteria.equals(FlightCriteria.TIME)) {
					double averageTime = current.getAverageTime(neighbor);
					currentFlights.get(i).setTime(averageTime);
					currentFlights.get(i).setWeight(criteria);
				} else if (criteria.equals(FlightCriteria.DELAY)) {
					double averageTime = current.getAverageDelay(neighbor);
					currentFlights.get(i).setDelayTime(averageTime);
					currentFlights.get(i).setWeight(criteria);
				} 
				else if(criteria.equals(FlightCriteria.CANCELED)){
					double averageTime = current.getAverageCanceled(neighbor);
					currentFlights.get(i).setCanceled(averageTime);
					currentFlights.get(i).setWeight(criteria);
				}
				else {
					currentFlights.get(i).setWeight(criteria);
				}
				double flightWeight = currentFlights.get(i).getFlightWeight();
				if (neighborWeight > (current.getWeight() + flightWeight)) {
					queue.add(neighbor);
					neighbor.setPrevious(current);
					neighbor.setWeight(current.getWeight() + flightWeight);

				}
			}
		}
		return null;
	}

	/**
	 * <p>
	 * This overloaded method should do the same as the one above only when
	 * looking for paths skip the ones that don't match the given airliner.
	 * </p>
	 * 
	 * @param origin
	 *            - The starting location to find a path from. This should be a
	 *            3 character long string denoting an airport.
	 * 
	 * @param destination
	 *            - The destination location from the starting airport. Again,
	 *            this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria
	 *            - This enum dictates the definition of "best". Based on this
	 *            value a path should be generated and return.
	 * 
	 * @param airliner
	 *            - a string dictating the airliner the user wants to use
	 *            exclusively. Meaning no flights from other airliners will be
	 *            considered.
	 * 
	 * @return - An object containing path information including origin,
	 *         destination, and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria, String airliner) {
		for(int i = 0; i < allAirports.size(); i++){
			allAirports.get(i).weight = Double.POSITIVE_INFINITY;
			allAirports.get(i).visited = false;
		}
		int originIndex = 0;
		if (allAirportNames.contains(origin)) {
			originIndex = allAirportNames.indexOf(origin);
		}
		int destinationIndex = 0;
		if (allAirportNames.contains(destination)) {
			destinationIndex = allAirportNames.indexOf(destination);
		}

		Airport start = allAirports.get(originIndex);
		Airport goal = allAirports.get(destinationIndex);
		
		PriorityQueue<Airport> queue = new PriorityQueue<Airport>();
		LinkedList<String> path = new LinkedList<String>();

		start.setWeight(0);
		queue.add(start);
		Airport current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current.getAirport().compareTo(goal.getAirport()) == 0) {
				double finalWeight = current.getWeight();
				while (current != start) {
					path.addFirst(current.getAirport());
					current.visited = false;
					current.weight = Double.POSITIVE_INFINITY;
					current = current.getPrevious();
					
				}
				start.visited = false;
				start.weight = Double.POSITIVE_INFINITY;
				path.addFirst(start.getAirport());
				BestPath bestPath = new BestPath(path, finalWeight);
				return bestPath;

			}

			current.visited = true;
			Airport neighbor = current;
			ArrayList<Flight> currentFlights;

			for (int i = 0; i < current.size(); i++) {
				currentFlights = new ArrayList<Flight>();
				currentFlights = current.getOutgoingFlights();
				if (currentFlights.get(i).carrier.compareTo(airliner) == 0) {
					neighbor = currentFlights.get(i).getDestination();
					
					double neighborWeight = neighbor.getWeight();
					if (criteria.equals(FlightCriteria.TIME)) {
						double averageTime = current.getAverageTime(neighbor);
						currentFlights.get(i).setTime(averageTime);
						currentFlights.get(i).setWeight(criteria);
						
					} else if (criteria.equals(FlightCriteria.DELAY)) {
						double averageTime = current.getAverageDelay(neighbor);
						currentFlights.get(i).setDelayTime(averageTime);
						currentFlights.get(i).setWeight(criteria);
					}
					else {
					currentFlights.get(i).setWeight(criteria);
					}
					double flightWeight = currentFlights.get(i).getFlightWeight();
					if ((neighborWeight > (current.getWeight() + flightWeight))) {
						queue.add(neighbor);
						neighbor.setPrevious(current);
						neighbor.setWeight(current.getWeight() + flightWeight);
					}
				}
			}
		}
		return null;
	}
}
