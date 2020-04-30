import java.util.ArrayList;

public abstract class Content {

	protected String ID, name;
	protected int itemDownloads = 0;
	protected double price;

	ArrayList<Comment> itemComments = new ArrayList<Comment>();

	Content(String ID, String name, double price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
	}

	protected void showItemDetails() {
		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
	}

	protected void addReview(Comment comment) {
		this.itemComments.add(comment);
	}

	protected void showReviews() {
		System.out.println("**** COMMENTS ****");
		System.out.println("# " + this.name);

		for (Comment itemReview : this.itemComments) {
			itemReview.showComment();
			System.out.println();
		}
	}

	protected void showDownloads() {
		System.out.println(this.name + ": " + this.itemDownloads + " download(s)");
	}

	protected void setPrice(boolean isAdmin, double price) {
		if (isAdmin) {
			this.price = price;
		} else
			System.out.println("Please enter your correct admin password");
	}
}
