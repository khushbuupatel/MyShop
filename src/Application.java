/**
 * Application class extends abstract Content class and provides implementation
 * to create new Application objects and display its details
 *
 */
public class Application extends Content {

	// variable to store Application specific details
	private String osType;

	/**
	 * Constructor to initialize new application objects which are free
	 * 
	 * @param ID
	 * @param name
	 * @param os
	 */
	Application(String ID, String name, String os) {
		this(ID, name, 0.0, os);
	}

	/**
	 * Constructor to initialize new application objects with price
	 * 
	 * @param ID
	 * @param name
	 * @param price
	 * @param os
	 */
	Application(String ID, String name, double price, String os) {
		super(ID, name, price);
		this.osType = os;
	}

	/**
	 * This method displays details for Application objects
	 */
	protected void showItemDetails() {
		System.out.println("****** Application ID: " + this.getID() + " ******");

		super.showItemDetails();
		System.out.println("Operating System: " + this.osType);

		System.out.println("-----------------------------------");
	}

}
