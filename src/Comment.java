/**
 * Comment class provides implementation to create new objects of Comment type
 * and display its details
 *
 */
public class Comment {

	// variables to store details of comment objectss
	private Customer customer;
	private String commentMsg;
	private int rating;

	/**
	 * Constructor to initialize Comment object containing only comment message
	 * 
	 * @param customer
	 * @param commentMsg
	 */
	Comment(Customer customer, String commentMsg) {
		this.customer = customer;
		this.commentMsg = commentMsg;
	}

	/**
	 * Constructor to initialize Comment object containing only ratings
	 * 
	 * @param customer
	 * @param rating
	 */
	Comment(Customer customer, int rating) {
		this.customer = customer;
		this.rating = rating;
	}

	/**
	 * Constructor to initialize Comment object containing rating and comment
	 * message
	 * 
	 * @param customer
	 * @param rating
	 * @param commentMsg
	 */
	Comment(Customer customer, int rating, String commentMsg) {
		this(customer, rating);
		this.commentMsg = commentMsg;
	}

	/**
	 * Constructor to initialize Comment object containing comment message and
	 * ratings
	 * 
	 * @param customer
	 * @param commentMsg
	 * @param rating
	 */
	Comment(Customer customer, String commentMsg, int rating) {
		this(customer, commentMsg);
		this.rating = rating;
	}

	/**
	 * This method displays the comments of particular content
	 */
	protected void showComment() {

		// display the name of customer who gave the comment
		System.out.println("Username: " + this.customer.getUsername());

		// display comment message if given by user
		if (this.commentMsg != null)
			System.out.println("Comments: " + commentMsg);

		// display ratings if given by user
		if (this.rating != 0)
			System.out.println("Ratings: " + this.rating);
	}

}
