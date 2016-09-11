package assignment13;

public class Flight {
	public Airport destination;
	public String carrier;
	public int delayTime;
	public int canceled;
	public double time;
	public int distance;
	public double cost;
	public double weight;
	
	public Flight(Airport _destination, String _carrier, int _delayTime, int _canceled, double _time, int _distance, double _cost){
		this.destination = _destination;
		this.carrier = _carrier;
		this.delayTime = _delayTime;
		this.canceled = _canceled;
		this.time = (double)_time;
		this.distance = _distance;
		this.cost = _cost;
	}
	
	public void setTime(double newTime){
		this.time = newTime;
	}
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
	
	public double getFlightWeight(){
		return weight;
	}
	
	public String getCarrier(){
		return carrier;
	}
	
	public Airport getDestination(){
		return destination;
	}
	
	public int getDelayTime(){
		return delayTime;
	}
	
	public double getCost(){
		return cost;
	}
	
	public int getCanceled(){
		return canceled;
	}
	public int getDistance(){
		return distance;
	}
	
	public double getTravelTime(){
		return time;
	}
	

}
