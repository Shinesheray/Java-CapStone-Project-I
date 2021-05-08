
import java.util.Scanner; // we import scanner to read user input 
import java.io.BufferedReader; // we import a buffer reader to read through our CSV file and get the values of each row correctly 
import java.io.FileWriter; // we import file writer to write to the new file our output text such as the invoice
import java.io.IOException; // we need to throw an exception for the try catch statement to read our file drivers.TXT
import java.util.ArrayList; // we import arraylist in order to assist with our object of drivers array
import java.util.List; // we import list to assit with array List in order to list our drivers 
import java.nio.charset.StandardCharsets;  // this i learnt from java.96 to assit with the ASSCII numbers 
import java.nio.file.Files; // this is to help read a file which is in another folder
import java.nio.file.Path; // to assist with the buffer reader and is the representation of location in particular file system
import java.nio.file.Paths; // this assists the above path to create a method to get the path file

public class orderForfiler {

	// we create the main attributes for our order forfiller class
    public int subTotal; // the final total
    public static int runningTotal; // the costs being added each time the user makes a purchase and adds more to the quanntity
    private static int itemPrice; // the cost of each menu item
    static boolean ordering = true; // while the customer is still ordering the switch statement will carry out the conditions
    public static Scanner input = new Scanner(System.in); // this is our main input which gets the menue ordered items 
    static int j= 0;// j will store the ruunning total and the subtotal amounts
    public static String orderedItem1 = "Burger";// our menu items who have to be public static variables in order to accssess them across the whole page
    public static String orderedItem2 = "Fries";
    public static String orderedItem3 = "Soda";
    static int burgercount = 0; // for the quantities of each menue item ordered 
    static int friescount = 0;
    static int sodacount= 0;

    public static void menu() { // our menu method which determines which item has been purchased and displayes a message to the user that they have purchased a burger or fries or a soda
	    System.out.println("\n See below menu from the Retaurant \n1. Burger (R50) \n2. Fries (R45)\n3. Soda (R22) \n4. Done \n");
	    }

	    public static int ItemPrice(int foodItem) {
	    if (foodItem == 1) {
	        // burger= R50
	        System.out.println("You've ordered a " + orderedItem1);
	        itemPrice = 50; // the items price are int numbers which will be calculated to show the cost for the quantity purchased as well as the subtotal for all costs
	        
	    }if (foodItem == 2) {
	        // fries = R45
	        System.out.println("You've ordered " + orderedItem2);
	        itemPrice = 45;
	        
	    }if (foodItem == 3) {
	        // soda = R22
	        System.out.println("You've ordered a " + orderedItem3);
	        itemPrice = 22;
	    }
	    
	    quantity();
	    return j;
	}

	public static int quantity() { // our quantity method to determine the amount of items purchased and we ask the user how many of each item they would like
	    System.out.println("Enter quantity");
	    int quantity = input.nextInt();
	    burgercount = quantity ;// I added quantity to the variables in order to keep track of how many of each item was purchased and will be displayed in the invoice
	    friescount = quantity;
	    sodacount = quantity;
	    subTotal(quantity, itemPrice);
	    
	    return quantity;
	}

	public static int subTotal(int quantity, int itemPrice) { // we create a sub total method to calculate the quntitly of all the items ordered by the costs for each and we then get one full total at the end 
	    int subTotal = quantity * itemPrice;
	    System.out.println("Subtotal: R" + subTotal);
	    j=subTotal;
	    return subTotal;
	}

	public static void done(int runningTotal) { // this is our finished ordering method for when the user has completed their order
	    ordering = false;
	    System.out.println("Your Food has been orderd!");
	}
    
	public static void main(String[] args) throws IOException {
		  int menuOption; // a local variable to assit with the switch statement for the menu selection
		    int foodItem = 0; // we create local variables in our main method in order not to loose the main functionality

		 // Capturing user the restaurant into class attributes and creating a new restaurant object
			    Scanner input1 = new Scanner(System.in);
			    System.out.println("Enter your Name");
			String customerName = input1.nextLine();

			    System.out.println("Enter your email adress");
		   String customerEmail = input1.nextLine();

			    System.out.println("Enter Address");
	       String customerAddress = input1.nextLine();

			    System.out.println("Enter Location");
          String customerLocation = input1.nextLine();

			    System.out.println("Please enter your number");
		 String customerPhoneNumber = input1.nextLine();
	
		CustomerDetails customer = new CustomerDetails(customerName, customerEmail, customerAddress, customerLocation, customerPhoneNumber);
				System.out.print(customer);
				
	    // Capturing user the restaurant into class attributes and creating a new restaurant object
			    Scanner input2 = new Scanner(System.in);
			    System.out.println("Enter the restaurant Name");
			String restaurantName = input2.nextLine();

			    System.out.println("Enter restaurant Location");
          String restaurantLocation = input2.nextLine();

			    System.out.println("Please enter the restaurant number");
		 String restaurantPhoneNumber = input2.nextLine();

		 RestaurantDetails restaurant = new RestaurantDetails(restaurantName, restaurantLocation, restaurantPhoneNumber);
				System.out.print(restaurant);
						
			// this section we are going through a switch statment with nested if statements which will action out what the user selcetion if of the menu metthod  
			 input = new Scanner(System.in);
			 
		      String orderedItem1 = " Burger ";// these varibles will hold the name of the selected item and display in the invoice
		      String orderedItem2 = " Fries ";
		      String orderedItem3 = " Soda ";
			 String test1 = "";
			 String test2 = "";
			 String test3 = "";
		Object	 metro1 = ""; // needed to create these as objects in order to take the int varible counter and display it as a string and because it could display an empty string if the item was not selected
		Object	 metro2 = "";
		Object	 metro3 = ""; // these variables are to determine the out put strings which will be entered into the invoice 
		String fargo = "";
			    int runningTotal=0;
			    while(ordering) {
			    menu(); // here we call the menu method which will be part of the following cases and what do display based on the user choice 
			    menuOption = input.nextInt();
			    switch(menuOption){
			    
			    case 1:
			    foodItem = 1; // this is the burger option
			    runningTotal += ItemPrice(foodItem); // if the user has picked this option the burger item cost will run from our running total and out itemprice method
			    if (foodItem == 1) { // if the item is a burger the invoice text will be displayed in the invoice 
			    	  test1 += orderedItem1 + "(R50.00)";
			    	  metro1 = burgercount + "x ";
			    } else if (foodItem != 1) { // if is not the burger selected we will display an empty string to the invoice and the burger will not show
			    	 test1 += "";
			    	 metro1 = fargo;	 
			    }
			   // as per the  above the same happens for item 2 and item 3
			    break;
			    case 2:
			    foodItem = 2;
			    runningTotal += ItemPrice(foodItem);
			    if (foodItem == 2) {
			    	  test2 += orderedItem2 + "(R45.00)";
			    	  metro2 = friescount + "x ";
			    } else if (foodItem != 2) {
			    	 test2 += "";
			    	 metro2 = fargo;	 
			    }
			
			    break;
			    case 3:
			    foodItem = 3;
			    runningTotal += ItemPrice(foodItem);
			    if (foodItem == 3) {
			    	  test3 += orderedItem3 + "(R22.00)";
			    	  metro3 = sodacount + "x ";
			    } else if (foodItem != 3) {
			    	 test3 += "";
			    	 metro3 = fargo;	 
			    }
			  
			    break;
			    
			    case 4: // once the user has completed their order and presses 4 we now show them the full total of their order and we display your food has been ordered
			    done(runningTotal);
			    break;
			    default: // if the user has not selected any valid item number we display invalid option
			    System.out.println("Invalid option.");
			    }
			    } 
			    System.out.println("Total amount: R" + runningTotal + "\n");
			  
			    // in this section we ask the user whether they have any special reuquests which we then add to the invoice and we display it in the console for them to see it is there
			    Scanner sc = new Scanner(System.in);
			    System.out.println("Do you have a special request");
			    String request = sc.nextLine();
			    
			    System.out.println("You have instructed us to " + request + "\n");
			    
			    // this section is for the creation of the invoice and the selection of a driver below we get the file path of the driver.txt and store it in a string variable
			    String path = "C:\\Users\\shine\\OneDrive\\Documents\\HyperionDev_level_2\\Task 7\\Compulsory Task 2 complete\\drivers.txt";
			
			    boolean found = false; // we need to create a boolean or else the if statement in the forloop will still execute the else statement within the loop even if the statement is true, so this prevents that from happening and executes only the code which is true or false
			  
			    List<Driver> drivers = readDriversFromCSV(path); // from the drivers path we create a list of all drivers which was created in the method create drivers which has all the drivers in an arrayList
		
			    // let's print all the persons read from CSV file one by 1 using a for loop	
				for (Driver b : drivers) {
					String	driversName = "";// this is the drivers name of whom is closest to the restaurant and the customer
					
				if (b.getLocation().contains(restaurantLocation) && b.getLocation().contains(customerLocation)) { // I needed to use the contains method because my condition will not work if I used ==, so if the driver file contains the same area as the restaurant and customer, it will execute the code
							System.out.println(b.getName() + b.getCapacity()); // i decided to print out to console becuase it would make it esier to see each of the drivers distance but I was unable to make the drivers distance an int as the code would no longer work
							
							driversName = b.getName(); // this will be the drivers name whom will be posted to the invoice 
							
							found = true; // this boolean is for if the statement is true it will execute this block of code 
							 String invoiceText = ""; // we store the invoice concatinated text in this invoice variable
							 
								while (true) { // we use a while loop to concatinate the text into a well formated invoice string which will displayed in new file line for line neatly 
									invoiceText = invoiceText.concat(customer + "\r\n"
											+ "You have ordered the following from " + restaurantName + " in " + restaurantLocation + ":" + "\r\n"
											+ metro1 + test1 + "\r\n" +
											metro2 + test2 + "\r\n" + 
											metro3 +  test3 + "\r\n" + // here I have added the ordered items in the string but will only be displayed if the user has selected these items, if not it will display an empty string 
											"\r\n" +
											"Special instructions: " + request + "\r\n" 
										+	"\r\n" + 
											"Total: R" + runningTotal + ".00 \r\n"
											
											+ "\r\n" + driversName + " is nearest to the restaurant and they will be delivering your\r\n"
													+ "order to you at:\r\n"
											+ "\r\n" + customerAddress + "\r\n" +
											customerLocation + "\r\n" 
											+ " \r\n" + 
											"If you need to contact the restaurant, their number is " + restaurantPhoneNumber + ".");
									 break;// we need to stop the while loop here or else it will continue to add the text continuesly 
								}
								
								System.out.println(invoiceText); // we output the invoice to the console in order to see what the final text
								//i found that from file writer we can write to other files but we should always import the package file writer
								FileWriter invice = new FileWriter("C:\\Users\\shine\\OneDrive\\Documents\\HyperionDev_level_2\\Task 7\\Compulsory Task 2 complete\\Invoice.txt");
								invice.write(invoiceText);
								invice.close(); // we close file writer
							
							} 
} if ( ! found ){// if the location of the driver does not match the customers location we then write to the invoice "Sorry our driver is too far "
						
						String sorryText = "Sorry! Our\r\n"
								+ "drivers are too far away from you to be able to\r\n"
								+ "deliver to your location.";
						//i found that from file writer we can write to other files but we should always import the package file writer
						FileWriter invice2 = new FileWriter("C:\\\\Users\\\\shine\\\\OneDrive\\\\Documents\\\\HyperionDev_level_2\\\\Task 7\\\\Compulsory Task 2 complete\\\\Invoice.txt");
						invice2.write(sorryText);
						
						System.out.print(sorryText);
						invice2.close(); // we close file writer
			}  
			    input1.close(); // I needed to close all my Scanners at the end of the program in order for it to run correctly I saw no error in the code but got a error in the console this was an running error
			    input2.close();
			    input.close();
			    sc.close();
	}
	
	/// below we create our driver  methods
	public static List<Driver> readDriversFromCSV(String fileName) { // we create our first method read drivers from the csv list which will be a list method
		List<Driver> drivers = new ArrayList<>(); // when we create a new driver list we turn the values into an array list for easier reading of each of the rows
		Path pathToFile = Paths.get(fileName);  // we get the file path to the folder which we use to assist in getting the file in the main method

		// create an instance of BufferedReader
	// using try with resource, Java 7 feature to close resources
	try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
		
		// read the first line from the text file 
		String line = br.readLine(); 
		
		// loop until all lines are read 
		while (line != null) {
		// use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
			String[] attributes = line.split(",");

			Driver driver = createDrvier(attributes); 
			// adding the driver into ArrayList
			drivers.add(driver); // read next line before looping 
			
			// if end of file reached, line would be null
			line = br.readLine();
			}
		
	} catch (IOException ioe) { 
		ioe.printStackTrace(); 
		} 

	return drivers; 
	} 
	
	public static Driver createDrvier(String[] values) { // in this method we create the names and attributes of the driver we created 
		String nameOfDrvier = values[0];  // in the CSV file as the first row will have the values separated by comas we have them by index
		String locationOfDriver = values[1];
		String driverCapacity = values[2];
		
		return new Driver(nameOfDrvier, driverCapacity, locationOfDriver);  // now we push to create a new driver object 
		}
	}

	

// references :
//I found this method to make my integer scanner work https://stackoverflow.com/questions/52746809/type-mismatch-cannot-convert-from-string-to-int-java
//I found a method on stackoverflow to make my customer enter details from https://stackoverflow.com/questions/38134721/creating-object-using-user-input-to-store-in-java-array
// I found a method to make my if statements respond correctly from stack overflow https://stackoverflow.com/questions/59333348/else-statement-proceeds-to-execute-even-if-statements-are-encountered
// I found a resource t help me create a drvier object from the given CSV(comma separated values) file from  https:www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html#ixzz6qCeureyU
//I found a method to find specific items in my csv text file from stack overflow https:stackoverflow.com/questions/53332909/read-a-particular-data-corresponding-to-a-row-column-in-csv
// I found another example on how to create the order structure for my menu from https://stackoverflow.com/questions/16483295/novice-programmer-trying-to-make-a-java-restaurant-menu