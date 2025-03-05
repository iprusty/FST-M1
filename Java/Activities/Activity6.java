package activities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTakeoffTime;
	private Date lastLandingTime;

public Plane(int maxPassengers) {
	this.maxPassengers = maxPassengers;
	this.passengers = new ArrayList<>();
}
public void onboard(String passengerName) {
if(passengers.size()<=maxPassengers){
    this.passengers.add(passengerName);
}else {
	System.out.println("plane is full");
}
}public void setTakeoff() {
	this.lastTakeoffTime = new Date();
}
	
public Date gettakeOff() {
    return this.lastTakeoffTime;
    
}

public void setLand() {
    this.lastLandingTime = new Date();
    this.passengers.clear();
}

public Date getLastTimeLanded() {
    return this.lastLandingTime;
}

public List<String> getPassengers() {
    return passengers;
}
}

public class Activity6 {


	    public static void main(String[] args) throws InterruptedException {
	       
	        Plane b747 = new Plane(10);
	   
	        b747.onboard("ipsita");
	        b747.onboard("irshika");
	        b747.onboard("mama");
	  
	        System.out.println("Plane took off at: " +  b747.gettakeOff());
	     
	        System.out.println("People on the plane: " +  b747.getPassengers());
	
	        Thread.sleep(5000);
	       
	        b747.setLand();
	     
	        System.out.println("Plane landed at: " +  b747.getLastTimeLanded());
	        System.out.println("People on the plane after landing: " +  b747.getPassengers());
	    }
	}
	