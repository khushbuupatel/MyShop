/**
 * Book class extends abstract Publication class to provide implementation to
 * create new Book objects and display its details
 *
 */
public class Book extends Publication {

	// variable to store Book specific details
	private String[] authors;

	/**
	 * Constructor to initialize new Book objects
	 * 
	 * @param ID
	 * @param name
	 * @param price
	 * @param publisher
	 * @param noOfPages
	 * @param authors
	 */
	Book(String ID, String name, double price, String publisher, int noOfPages, String[] authors) {
		super(ID, name, price, publisher, noOfPages);
		this.authors = authors;
	}

	/**
	 * This method displays details of Book object
	 */
	public void showItemDetails() {
		
		// string to store the author names
		String authorNames = "";
		
		System.out.println("****** Book ID: " + this.getID() + " ******");

		super.showItemDetails();
		System.out.print("Author(s): ");

		for (String author : this.authors)
			authorNames += author + ", ";
		
		System.out.print(authorNames.substring(0, authorNames.length()-2) + "  ");

		System.out.println("\n-----------------------------------");
	}
}
