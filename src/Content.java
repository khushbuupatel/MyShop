import java.util.ArrayList;

/**
 * Abstract Content class provides implementation to create new object of
 * Content type objects like Application, Book and Magazine. It also provides
 * implementation for methods to display item details, add reviews to different
 * content items, display reviews, sets price, and displays downloads
 * 
 */
public abstract class Content {

	// variables to store details of Content objects
	private String ID, name;
	private int itemDownloads = 0;
	private double price;

	// arraylist to store comments for particular content
	ArrayList<Comment> itemComments = new ArrayList<Comment>();

	/**
	 * Constructor to initialize Content type objects
	 * 
	 * @param ID
	 * @param name
	 * @param price
	 */
	Content(String ID, String name, double price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
	}

	/**
	 * This method is used to display Content type object details
	 */
	protected void showItemDetails() {
		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
	}

	/**
	 * This method is used to add reviews to particular Content
	 * 
	 * @param comment object of Comment type
	 */
	protected void addReview(Comment comment) {
		this.itemComments.add(comment);
	}

	/**
	 * This method is used to display content item reviews
	 */
	protected void showReviews() {
		System.out.println("******* Review(s) of item '" + this.name + "' *******");

		for (Comment itemReview : this.itemComments) {
			itemReview.showComment();
			System.out.println();
		}
	}

	/**
	 * This method is used to update price of the content
	 * 
	 * @param isAdmin boolean variable returned from login() method of Admin class
	 * @param price   updated price of the content
	 */
	protected void setPrice(boolean isAdmin, double price) {

		// check if the Admin details are valid
		if (isAdmin) {

			// update the price of the content
			this.price = price;
			System.out.println("Price has been set to: " + this.price + " for item " + this.name + "\n");

		} else {
			// print error message if Admin login details are incorrect
			System.out.println("Please enter your correct admin password");
		}
	}

	/**
	 * This methods shows total downloads of a particular content item
	 */
	protected void showDownloads() {
		System.out.println("\n" + this.name + ": " + this.itemDownloads + " download(s)");
	}

	/**
	 * This method returns the ID of the content item
	 * 
	 * @return ID
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * This method returns the Name of the content item
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method updates the content item downloads count
	 * 
	 * @param itemDownloads
	 */
	public void setItemDownload(int itemDownloads) {
		this.itemDownloads = itemDownloads;
	}

	/**
	 * This method returns the content item downloads count
	 * 
	 * @return itemDownloads
	 */
	public int getItemDownloads() {
		return this.itemDownloads;
	}

	/**
	 * This method updates the content item price
	 * 
	 * @param price updated price
	 */
	public void setItemPrice(double price) {
		this.price = price;
	}

	/**
	 * This method returns the content item price
	 * 
	 * @return price
	 */
	public double getItemPrice() {
		return this.price;
	}
}
