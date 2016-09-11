package assignment_13;

import java.util.ArrayList;

/**
 * This Airport class is the basis for all of the Airports that we have. This class creates a new Airport object that 
 * has a name and a list of all of the flights going from this Airport to any other Airport. This class also computes
 * the average Flight Time and average Delay Time of all the flights from one Airport to another. This Airport class is
 * also comparable based on its weight. There are also links to the Airport that the Flight came from, (Previous), and
 * various getter functions used in the NetworkGraph Class.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class Airport implements Comparable<Airport>{
	
	public String origin;
	public ArrayList<Double> flightDelayTimes;
	public ArrayList<Flight> flights;
	public ArrayList<String> flightDestinations;
	public ArrayList<Double> flightTimes;
	public ArrayList<Integer> flightCount;
	public ArrayList<Flight> flightCarrier;
	public ArrayList<Double> flightCancellation;
	public boolean visited;
	public int count;
	public Double weight;
	public Airport previous;
	public int carrierCount;
	
	/**
	 * This is just the basic constructor for the Airport Class. This makes a new Airport with the name as a parameter.
	 * 
	 * @param String _origin -- The name of the Airport.
	 */
	public Airport(String _origin){
		count = 0;
		visited = false;
		origin = _origin;
		flights = new ArrayList<Flight>();
		weight = Double.POSITIVE_INFINITY;
		previous = null;
		flightTimes = new ArrayList<Double>();
		flightDestinations = new ArrayList<String>();
		flightCount = new ArrayList<Integer>();
		flightDelayTimes = new ArrayList<Double>();
		flightCarrier = new ArrayList<Flight>();
		flightCancellation = new ArrayList<Double>();
		carrierCount = 0;
	}
	
	/**
	 * This function adds a flight to this Airport. This function also adds Flight Times and Delay Times to different
	 * ArrayLists to be used for calculating the average flight times and average delay times in the following functions.
	 * 
	 * @param Flight _flights -- The flight that is being added to this Airport.
	 */
	public void addFlight(Flight _flights){
		
		if(!flightDestinations.contains(_flights.getDestination().getAirport())){
			flightDestinations.add(_flights.getDestination().getAirport());
			flightTimes.add(_flights.time);
			flightDelayTimes.add(_flights.delayTime);
			flightCancellation.add(_flights.canceled);
			flightCount.add(1);
		}
		else if(flightDestinations.contains(_flights.getDestination().getAirport())){
			int index = flightDestinations.indexOf(_flights.getDestination().getAirport());
			double originalTime = flightTimes.get(index);
			double originalFlightDelay = flightDelayTimes.get(index);
			double originalFlightCancelled = flightCancellation.get(index);
			flightCancellation.set(index, (originalFlightCancelled + _flights.canceled));
			flightDelayTimes.set(index, (originalFlightDelay + _flights.delayTime));
			flightTimes.set(index, (originalTime+_flights.time));
			int counter = flightCount.get(index);
			flightCount.set(index, counter+1);
			
		}
		flights.add(_flights);
		count++;
	}
	
	/**
	 * This function computes the average flight time between this airport and the destination airport as specified 
	 * by the parameter.
	 * 
	 * @param Airport goal -- The destination Airport.
	 * @return double -- The Average Flight Time from this Airport to the destination Airport.
	 */
	public double getAverageTime(Airport goal){
		int index = this.flightDestinations.indexOf(goal.getAirport());
		return this.flightTimes.get(index)/flightCount.get(index);
		
	}
	/**
	 * This function computes the average delay time between this airport and the destination airport as specified 
	 * by the parameter.
	 * 
	 * @param Airport goal -- The destination Airport.
	 * @return double -- The Average Delay Time from all flights from this Airport to the destination Airport.
	 */
	public double getAverageDelay(Airport goal){
		int index = this.flightDestinations.indexOf(goal.getAirport());
		return this.flightDelayTimes.get(index)/flightCount.get(index);
	}
	/**
	 * This function computes the average probability of a cancellation based on all of the flights from this Airport
	 * to the destination Airport.
	 * @param Airport goal -- The destination Airport.
	 * @return double -- The Average Probability of a Cancellation.
	 */
	public double getAverageCanceled(Airport goal){
		int index = this.flightDestinations.indexOf(goal.getAirport());
		return this.flightCancellation.get(index)/flightCount.get(index);
	}
	/**
	 * This function sets the weight of this Airport depending on the Flights to and from this Airport as well as 
	 * the FLightCriteria specified by the user.
	 * 
	 * @param double _weight -- The new weight of this Airport.
	 */
	public void setWeight(double _weight){
		weight = _weight;
	}
	/**
	 * This function just returns the weight of this Airport.
	 * 
	 * @return double -- The weight of this Airport.
	 */
	public double getWeight(){
		return weight;
	}
	
	/**
	 * This function sets a pointer to the Previous Airport that a Flight came from to get to this Airport.
	 * Mostly just used for computing the path from one Airport to another.
	 * 
	 * @param Airport _previous -- The Airport that a Flight came from to get to this Airport.
	 */
	public void setPrevious(Airport _previous){
		previous = _previous;
	}
	/**
	 * This function just returns the previous Airport.
	 * 
	 * @return Airport -- The Airport that a Flight came from to get to this Airport.
	 */
	public Airport getPrevious(){
		return previous;
	}
	
	/**
	 * This function returns an ArrayList of all of the outgoing flights from this Airport.
	 * @return ArrayList<Flight> -- The list of all Flights leaving this Airport.
	 */
	public ArrayList<Flight> getOutgoingFlights(){
		return flights;
	}
	
	/**
	 * This function returns the size of this Airport, or how many flights are leaving this Airport.
	 * @return int -- The number of flights leaving this Airport.
	 */
	public int size(){
		return count;
	}
	
	/**
	 * This function just returns the name of this Airport.
	 * 
	 * @return String -- The name of this Airport.
	 */
	public String getAirport(){
		return origin;
	}
	
	/**
	 * This is a basic compareTo()/Comparator for this Airport class. Objects are compared by their weight.
	 * 
	 * @parameter Airport rhs -- The Airport that this Airport is being compared to.
	 * @return int -- 0 if the two Airport weights are the same.
	 * 			   -- 1 if the this Airport is bigger than the parameter Airport.
	 * 			   -- -1 if this Airport is smaller than the parameter Airport.
	 */
	@Override
	public int compareTo(Airport rhs) {
		if(this.getWeight() > rhs.getWeight()){
			return 1;
		}
		if(rhs.getWeight() > this.getWeight()){
			return -1;
		}
		else {
			return 0;
		}
	}
}
