
class Driver { // we create our Driver class object to create their structured attributes
	
	// once the file reader has read through the driver file each of the values will be assigned to the following attributes 
	public String nameOfDrvier;
	public String driverCapacity;
	public String locationOfDriver;
	
	// below we create our driver constructor method
	public Driver(String nameOfDrvier, String driverCapacity, String locationOfDriver) { 
		
		this.nameOfDrvier = nameOfDrvier;
		this.driverCapacity = driverCapacity; 
		this.locationOfDriver = locationOfDriver;
	} 
	
	// we call our driver attributes with the following methods which makes it easier to use in our condition statement in the main class file Orderforfiler.java
	public String getName() { 
		return nameOfDrvier;  // the name of the selected driver who is closest to the customer and restaurant
		} 

	public String getCapacity() {
		return driverCapacity; // the amount of orders the driver has 
		} 
 
	public String getLocation() { 
			return locationOfDriver; // where the driver is located 
			} 
}

				
//References: 
// All references are on the main Class orderForfiller.java

