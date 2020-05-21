/**
 * Publication class extends abstract Content class to create new Publication
 * type objects
 *
 */
public abstract class Publication extends Content {

	// variables to store Publication details
	private String publisher;
	private int noOfPages;

	/**
	 * Constructor to initialize the Publication object
	 * 
	 * @param ID
	 * @param name
	 * @param price
	 * @param publisher
	 * @param noOfPages
	 */
	Publication(String ID, String name, double price, String publisher, int noOfPages) {
		super(ID, name, price);
		this.publisher = publisher;
		this.noOfPages = noOfPages;
	}

	/**
	 * This method is used to display publication details
	 */
	public void showItemDetails() {
		super.showItemDetails();
		System.out.println("Publisher: " + this.publisher);
		System.out.println("No of Pages: " + this.noOfPages);
	}

}
