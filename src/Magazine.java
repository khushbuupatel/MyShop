/**
 * Magazine class extends abstract Publication class to create new Magazine
 * objects
 *
 */
public class Magazine extends Publication {

	// variable to store Magazine objects details
	private double volume;

	/**
	 * Constructor to initialize new Magazine objects
	 * 
	 * @param ID
	 * @param name
	 * @param price
	 * @param publisher
	 * @param noOfPages
	 * @param volume
	 */
	Magazine(String ID, String name, double price, String publisher, int noOfPages, double volume) {
		super(ID, name, price, publisher, noOfPages);
		this.volume = volume;
	}

	/**
	 * This method is used to display Magazine object detailss
	 */
	public void showItemDetails() {
		System.out.println("****** Magazine ID: " + this.getID() + " ******");
		super.showItemDetails();
		System.out.println("Volume: " + this.volume);
		System.out.println("-----------------------------------");
	}
}
