package assignment_13;

/**
 * This Flight class represents a flight from one airport to another. Included in this FLight class are:
 * 		
 * 		-Links to origin Airport and Destination Airport
 * 		-Flight Carrier/Airliner
 * 		-Delay Time of the flight
 * 		-Whether or not it's canceled
 * 		-The Flight Time
 * 		-The distance from the origin to destination
 * 		-The cost of the flight
 * 
 * Also included in this class is a setWeight function that sets the weight of the class to whatever it should be depending
 * on the criteria given by the user.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class Flight {
	
	public Airport origin;
	public Airport destination;
	public String carrier;
	public double delayTime;
	public double canceled;
	public double time;
	public int distance;
	public double cost;
	public double weight;
	
	/**
	 * Basic constructor for this Flight class. Just adds the airport this flight is coming from and
	 * where this flight is headed to.
	 * 
	 * @param airportOrigin -- The starting Airport.
	 *		  airportDestination -- The destination Airport.
	 */
	public Flight(Airport airportOrigin, Airport airportDestination){
		this.origin = airportOrigin;
		this.destination = airportDestination;
	}
	
	/**
	 * Simply returns the Origin Airport.
	 * 
	 * @return Airport -- The Flights Origin Airport
	 */
	public Airport getOrigin(){
		return origin;
	}
	
	/**
	 * Simply returns the destination Airport.
	 * 
	 * @return Airport -- The Flights Destination Airport.
	 */
	public Airport getDestination(){
		return destination;
	}
	
	/**
	 * This function adds all of the flight info to the flight including the Flights carrier, delay, if it's canceled or not,
	 * the flight distance, and the cost.
	 * 
	 * @param String _carrier -- The Flights Carrier
	 * 		  int _delayTime -- How long of a delay this flight has
	 *  	  int _canceled -- Whether or not the flight is canceled or not.
	 * 		  double _time -- The time this flight takes to get from origin to destination.
	 * 		  double _distance -- The distance from origin to destination.
	 * 	 	  double _cost -- The cost of this flight.
	 */
	public void addFlightInfo(String _carrier, double _delayTime, double _canceled, double _time, int _distance, double _cost){
		this.carrier = _carrier;
		this.delayTime = _delayTime;
		this.canceled = _canceled;
		this.time = _time;
		this.distance = _distance;
		this.cost = _cost;
	}
	
	/**
	 * This function is used to set the average Flight Time when there are multiple flights to one destination.
	 * @param double newTime -- The new average Flight Time.
	 */
	public void setTime(double newTime){
		this.time = newTime;
	}
	
	/**
	 * This function is used to set the average Delay Time when there are multiple flights to one destination.
	 * @param double newTime -- The new average Delay Time.
	 */
	public void setDelayTime(double newTime){
		this.delayTime = newTime;
	}
	
	/**
	 * This function is used to set the average Delay Time when there are multiple flights to one destination.
	 * @param double newTime -- The new average Delay Time.
	 */
	public void setCanceled(double newCanceled){
		this.canceled = newCanceled;
	}
	/**
	 * This function is used to set the weight of the Flight depending on the users criteria.
	 * 
	 * @param FlightCriteria criteria -- The criteria the user wants to search for flights with.
	 */
	public void setWeight(FlightCriteria criteria){
		switch (criteria) {
        case COST:
            weight = cost;
            break;      
        case DELAY:
            weight = delayTime;
            break;           
        case DISTANCE: 
        	weight = distance;
        	break;
        case CANCELED:
            weight = canceled;
            break;
		case TIME:
			weight = time;
			break;
		}
	}
	
	/**
	 * This function simply returns the weight of the flight depending on what the weight was set to by the user.
	 * 
	 * @return double -- The weight of the Flight.
	 */
	public double getFlightWeight(){
		return weight;
	}
}
