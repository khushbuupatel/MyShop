
public class Comment {

	private Customer customer;
	private String commentMsg;
	private int rating;

	Comment(Customer customer, String commentMsg) {
		this.customer = customer;
		this.commentMsg = commentMsg;
	}

	Comment(Customer customer, int rating) {
		this.customer = customer;
		this.rating = rating;
	}

	Comment(Customer customer, int rating, String commentMsg) {
		this(customer, rating);
		this.commentMsg = commentMsg;
	}

	Comment(Customer customer, String commentMsg, int rating) {
		this(customer, commentMsg);
		this.rating = rating;
	}

	protected void showComment() {

		this.customer.showUserDetails();

		if (this.commentMsg != null)
			System.out.println("Comments: " + commentMsg);

		if (this.rating != 0)
			System.out.println("Ratings: " + this.rating);
	}

}
