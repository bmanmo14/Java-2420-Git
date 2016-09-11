package assignment13;

import java.util.ArrayList;


public class Airport implements Comparable<Airport>{
	
	public String origin;
	public ArrayList<Flight> flights;
	public boolean visited;
	public int count;
	public Double weight;
	public Airport previous;
	public int totalWeight;
	
	public Airport(String _origin){
		count = 0;
		visited = false;
		origin = _origin;
		flights = new ArrayList<Flight>();
		weight = Double.POSITIVE_INFINITY;
		previous = null;
		totalWeight = 0;
	}
	

	public void addFilght(Flight flightData){
		flights.add(flightData);
		count++;
	}
	
	public int size(){
		return count;
	}
	public String getAirport(){
		return origin;
	}
	
	public ArrayList<String> getDestinations(){
		ArrayList<String> allDestinations = new ArrayList<String>();
		for(int i = 0; i < flights.size(); i++){
			if(!allDestinations.contains(flights.get(i).getDestination().getAirport())){
			allDestinations.add(flights.get(i).getDestination().getAirport());
			}
		}
		return allDestinations;
	}
	
	public ArrayList<Flight> getOutgoingFlights(){
		return flights;
	}
	
	public void setWeight(double _weight){
		weight = _weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void setPrevious(Airport _previous){
		previous = _previous;
	}
	
	public Airport getPrevious(){
		return previous;
	}

	@Override
	public int compareTo(Airport rhs) {
		if(this.getWeight() > rhs.getWeight()){
			return -1;
		}
		if(rhs.getWeight() > this.getWeight()){
			return 1;
		}
		else if(rhs.getWeight() == this.getWeight()){
			return 0;
		}
		return 0;
	}
}
