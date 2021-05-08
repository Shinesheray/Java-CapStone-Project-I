
class RestaurantDetails {// this is our restaurant class folder where

// we create our restaurant attributes 
	public String restaurantName;
	public String restaurantLocation;
	public String restaurantPhoneNumber;
	
	// the restaurant contructor method 
public RestaurantDetails(String restaurantName, String restaurantLocation, String restaurantPhoneNumber) {
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantPhoneNumber = restaurantPhoneNumber;
	}

//below we call our restaurant attributes with methods 
public String getRestaurantName() {
	return restaurantName;
}

public String getRestaurantNumber() {
	return restaurantPhoneNumber;
}

public String getRestaurantLocation() {
	return restaurantLocation;	
}

public String toString() { // we use the method toString to create the restaurant details in order when displayed
	 String output = "Restaurant: " + getRestaurantName() + "\n";
	 output += "Phone number: " + getRestaurantNumber() + "\n";
	 output += "Location: " + getRestaurantLocation() + "\n";
	 
	 return output;
	
 }	
}

//References: 
//All references are on the main Class orderForfiller.java
